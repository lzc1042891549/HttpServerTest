package version2;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by liuzhichao on 17/4/9.
 */
public class PrimitiveServlet implements Servlet{
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("now, the PrimitiveServlet is init....");
    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("doing PrimitiveServlet service.");
        PrintWriter printWriter = servletResponse.getWriter();
        //with println...
        printWriter.println("hello,there will be two string, i am the 1st.");
        //with <print> ,与上面的方法不同
        printWriter.print("hello,there will be two string, i am the 2nd.");

    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
