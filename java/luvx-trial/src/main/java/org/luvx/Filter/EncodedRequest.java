package org.luvx.Filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;

public class EncodedRequest extends HttpServletRequestWrapper {
    private HttpServletRequest request;

    public EncodedRequest(HttpServletRequest request) {
        super(request);
        this.request = request;
    }

    @Override
    public String getParameter(String name) {
        //获取请求方式
        String m = request.getMethod();
        if ("get".equalsIgnoreCase(m)) {
            //get请求
            String value = request.getParameter(name);
            try {
                return new String(value.getBytes("iso8859-1"), "utf-8");
            } catch (UnsupportedEncodingException e) {
            }
        } else if ("post".equalsIgnoreCase(m)) {
            try {
                request.setCharacterEncoding("utf-8");
            } catch (UnsupportedEncodingException e) {
            }
            return request.getParameter(name);

        }
        return super.getParameter(name);
    }
}
