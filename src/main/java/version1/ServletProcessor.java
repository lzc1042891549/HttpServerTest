package version1;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Created by liuzhichao on 17/4/9.
 */
public class ServletProcessor implements BaseProcessor{

    public void process(Request request, Response response) throws ServletException, IOException {
        new PrimitiveServlet().service((ServletRequest) request,(ServletResponse) response);
    }
}
