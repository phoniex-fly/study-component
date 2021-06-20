package com.demo.common.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class GcUtil {


    /**
     * 信息放入session
     *
     * @param request
     * @param name
     * @param value
     */
    public static void addSessionAttr(HttpServletRequest request, String name, Object value) {
        HttpSession session = request.getSession(true);
        Object attribute = session.getAttribute(name);
        if (null != attribute) {
            session.removeAttribute(name);
        }
        session.setAttribute(name, value);
    }

    /**
     * 获取session中信息
     *
     * @param request
     * @param name
     * @return
     */
    public static String getSessionAttr(HttpServletRequest request, String name) {
        HttpSession session = request.getSession(true);
        Object attribute = session.getAttribute(name);
        if (attribute != null) {
            return attribute.toString();
        }
        return null;
    }


}
