package com.pro.test.core.common.springmvc.entity;

import com.pro.test.core.common.mybatis.MappingConvertor;
import com.pro.test.core.common.mybatis.entity.Pagination;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by hxpeng on 2016/5/26.
 */
public class RequestResolver {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;

    public RequestResolver() {
    }

    public RequestResolver(HttpServletRequest request) {
        this.request = request;
        if (request != null) {
            this.session = request.getSession();
        }
    }

    public RequestResolver(HttpServletRequest request, HttpServletResponse response) {
        this(request);
        this.response = response;
    }

    public HttpServletRequest getRequest() {
        return this.request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public HttpServletResponse getResponse() {
        return this.response;
    }

    public HttpSession getSession() {
        return this.session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public Pagination getPagination() {
        Pagination pagination = null;
        if ((pagination = (Pagination) this.request.getAttribute("requestPagination")) == null) {
            String pageSize = getParameter("size");
            String currentPage = getParameter("page");
            pagination = new Pagination(pageSize, currentPage);

            setAttribute(pagination);

            return pagination;
        }
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        setAttribute("requestPagination", pagination);
    }

    public String getServletPath() {
        return this.request.getServletPath();
    }

    public ServletContext getServletContext() {
        return this.session.getServletContext();
    }

    public Object getSessionAttribute(String paramName) {
        return this.session.getAttribute(paramName);
    }

    public void setSessionAttribute(String paramName, Object object) {
        this.session.setAttribute(paramName, object);
    }

    public void removeSessionAttribute(String paramName) {
        this.session.removeAttribute(paramName);
    }

    public String[] getParameterValues(String paramName) {
        return this.request.getParameterValues(paramName);
    }

    public String getParameter(String paramName) {
        return this.request.getParameter(paramName);
    }

    public String getOrder() {
        return getParameter("order");
    }

    public String getRequestURI() {
        return this.request.getRequestURI();
    }

    public StringBuffer getRequestURL() {
        return this.request.getRequestURL();
    }

    public String getCurrentURL() {
        String queryString = this.request.getQueryString();
        String currentURL = this.request.getContextPath() + this.request.getServletPath();
        currentURL = currentURL + (queryString == null ? "" : new StringBuilder("?").append(queryString).toString());

        return currentURL;
    }

    public String getQueryString() {
        return this.request.getQueryString();
    }

    public Object getAttribute(String paramName) {
        return this.request.getAttribute(paramName);
    }

    public void setAttributes(Object... object) {
    }

    public void setAttribute(Object o) {
        if (o == null) {
            return;
        }
        this.request.setAttribute(MappingConvertor.toFormName(o.getClass().getSimpleName()), o);
    }

    public void setAttribute(String paramName, Object object) {
        setAttribute(paramName, object, true);
    }

    public void setAttribute(String paramName, Object object, boolean escapeFlag) {
        if ((escapeFlag) && (object != null) && (
                ((object instanceof String)) ||
                        ((object instanceof StringBuilder)) ||
                        ((object instanceof StringBuffer)))) {
            this.request.setAttribute(paramName, HtmlUtils.htmlEscape(object.toString()));

            return;
        }
        this.request.setAttribute(paramName, object);
    }

    public void setAttributeForDataList(List<?> dataList) {
        this.request.setAttribute("dataList", dataList);
    }

}
