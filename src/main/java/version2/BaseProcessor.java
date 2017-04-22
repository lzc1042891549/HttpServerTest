package version2;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Created by liuzhichao on 17/4/9.
 */
public interface BaseProcessor {

    void process(Request request, Response response) throws IOException, ServletException;
}
