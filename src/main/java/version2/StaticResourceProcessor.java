package version2;

import java.io.IOException;

/**
 * Created by liuzhichao on 17/4/9.
 */
public class StaticResourceProcessor implements BaseProcessor{

    public void process(Request request, Response response) throws IOException {
        if (response == null){
            return;
        }
        response.sentStaticResource();
    }
}
