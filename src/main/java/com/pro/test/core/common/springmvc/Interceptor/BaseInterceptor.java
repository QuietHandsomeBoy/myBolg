package com.pro.test.core.common.springmvc.Interceptor;

import com.pro.test.core.common.annotation.Token;
import com.pro.test.core.common.exception.WebHandleException;
import com.pro.test.core.common.global.BaseVariables;
import com.pro.test.core.common.global.WebConstants;
import com.pro.test.core.util.IpUtils;
import com.pro.test.core.util.TokenUtils;
import com.pro.test.core.util.UserAgentParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * Created by hxpeng on 2016/8/23.
 */
public class BaseInterceptor extends HandlerInterceptorAdapter {

    /** 属性名sessionLoginAccount,保存具有session生命周期的用户名*/
    protected String sessionValidateKey = "sessionLoginAccount";

    /** 来宾*/
    protected String guestName = "Guest";

    /** 日志处理*/
    private static final Logger logger = LoggerFactory.getLogger(BaseInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("现在开始进行拦截===========================================");
        String servletPath = request.getServletPath();
        String queryString = request.getQueryString();

        String ipAddress = IpUtils.getUserIp(request);
        String userAgent = request.getHeader("User-Agent");
        String currentURL = request.getContextPath() + request.getServletPath();
        currentURL += queryString == null ? "" : ("?" + queryString);
        currentURL = new String(currentURL.getBytes("iso-8859-1"), BaseVariables.global_encoding);
        String requestMethod = request.getMethod();
        String callingId = request.getHeader("x-up-calling-line-id");

        UserAgentParser userAgentParser = new UserAgentParser(userAgent);

        String webBrowser = userAgentParser.getBrowserName() + " " + userAgentParser.getBrowserVersion();
        String os = userAgentParser.getBrowserOperatingSystem();

        HttpSession session = request.getSession(false);

        String sessionId = session == null ? "null" : session.getId();
        String userId = session == null ? guestName : (String)session.getAttribute(sessionValidateKey);

        if (userId == null) {
            userId = guestName;
        }

        String visitLog = "[VISIT_RECORD][" + sessionId + "][" + userId + "][" + ipAddress + "]["
                + requestMethod + "][" + currentURL + "][" + webBrowser + "][" + os + "]";

        System.out.println(visitLog);
        logger.info(visitLog);

        HandlerMethod handlerMethod = (HandlerMethod)handler;
        Method method = getHandleMethod(handlerMethod);

        if (method == null) {
            return false;
        }

        Token token = method.getAnnotation(Token.class);

        if (token != null) {
            if (WebConstants.REQUEST_METHOD_POST.equals(requestMethod)) {
                String tokenStr = request.getParameter(WebConstants.PARAM_NAME_TOKEN);

                if (TokenUtils.validSessionToken(tokenStr, session)) {
                    //验证成功，更新token
                    request.setAttribute(WebConstants.PARAM_NAME_TOKEN, TokenUtils.createSessionToken(session));
                }else{
                    throw WebHandleException.getRequestRepeatException();
                }
            }
        }
//
//        if ("/".equals(servletPath) || servletPath.trim().length() == 0) {
//            return true;
//        }

//        // 判断是否已经登录
//        if (session == null || session.getAttribute(sessionValidateKey) == null) {
//            throw new WebHandleException(ErrorConstants.ERROR_CODE_NO_SESSION);
//        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        HttpSession session = request.getSession();
//        String requestMethod = request.getMethod();
//
//        HandlerMethod handlerMethod = (HandlerMethod)handler;
//
//        Method method = getHandleMethod(handlerMethod);
//
//        if (method == null) {
//            return;
//        }
//
//        Token token = method.getAnnotation(Token.class);
//
//        if (token != null && WebConstants.REQUEST_METHOD_GET.equals(requestMethod)) {
//            request.setAttribute(WebConstants.PARAM_NAME_TOKEN, TokenUtils.createSessionToken(session));
//        }
//
//        Class<?> returnType = method.getReturnType();
//
//        if (returnType.equals(ModelAndView.class)) {
//            return;
//        }
    }

    /**
     * 页面响应后的一些清除处理
     *
     * @param response 响应对象
     * @param modelAndView 模型与视图
     * @param responseContent 响应内容
     *
     * @throws IOException IO流异常
     */
    public void handleResponse(HttpServletResponse response, ModelAndView modelAndView, String responseContent) throws IOException {
        if (responseContent != null) {
            modelAndView.clear();

            PrintWriter printWriter = response.getWriter();
            printWriter.print(responseContent);
            printWriter.flush();

            return;
        }
    }

    /**
     * 获取操作方法
     *
     * @param handlerMethod 操作方法对象
     *
     * @return 返回操作方法
     */
    public Method getHandleMethod(HandlerMethod handlerMethod) {
        if (BaseVariables.global_develope_flag) {
            Method method = handlerMethod.getMethod();
            Class<?> c = handlerMethod.getBeanType();

            try {
                return c.getMethod(method.getName(), method.getParameterTypes());
            } catch (Exception e) {

            }

            return method;
        }

        return handlerMethod.getMethod();
    }

}
