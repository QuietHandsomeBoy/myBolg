package com.pro.test.core.common.springmvc;

import com.pro.test.core.common.springmvc.entity.RequestResolver;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by hxpeng on 2016/5/27.
 */
public class BolgMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        Class<?> parameterClass = methodParameter.getParameterType();
        if (HttpServletRequest.class.equals(parameterClass) || HttpServletResponse.class.equals(parameterClass) || RequestResolver.class.equals(parameterClass)) {
            return true;
        }
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        Class<?> paramClass = methodParameter.getParameterType();
        HttpServletRequest request = (HttpServletRequest) nativeWebRequest.getNativeRequest();
        HttpServletResponse response = (HttpServletResponse) nativeWebRequest.getNativeResponse();
        if(HttpServletRequest.class.equals(paramClass)){
            return request;
        }
        if(HttpServletResponse.class.equals(paramClass)){
            return response;
        }
        if(RequestResolver.class.equals(paramClass)){
            return new RequestResolver(request,response);
        }
        return null;
    }
}
