package version1;

import constant.GlobalConstants;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by liuzhichao on 17/4/9.
 */
public class HttpServer {

    public static void main(String[] args) {
        HttpServer server = new HttpServer();
        server.await();
    }

    // 服务端监听
    private void await(){
        ServerSocket serverSocket = null;
        String ipStr = "127.0.0.1";
        int port = 8080;

        try {
            serverSocket = new ServerSocket(port,1,InetAddress.getByName(ipStr));
        } catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }

        boolean isShutdown = false;
        Socket socket = null;
        while (!isShutdown){
            try {
                socket = serverSocket.accept();
                InputStream input = socket.getInputStream();
                OutputStream out = socket.getOutputStream();

                Request request = new Request(input);
                request.parse();

                Response response = new Response(out);
                response.setRequest(request);

                isShutdown = request.getUri().startsWith(GlobalConstants.SHUTDOWN_COMMAND);
                if (isShutdown){
                    continue;
                }

                BaseProcessor processor = null;
                if (request.getUri().startsWith("/servlet/")){
                    processor = new ServletProcessor();
                } else {
                    processor = new StaticResourceProcessor();
                }
                processor.process(request,response);

            } catch (Exception e){
                e.printStackTrace();
                System.exit(1);
            } finally {
                if (socket != null){
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }


    }

}
