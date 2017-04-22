package version1;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by liuzhichao on 17/4/9.
 */
public interface BaseProcessor {

    void process(Request request, Response response) throws IOException, ServletException;
}
