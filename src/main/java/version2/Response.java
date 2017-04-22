package version2;

import constant.GlobalConstants;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import java.io.*;
import java.util.Locale;

/**
 * Created by liuzhichao on 17/4/9.
 */
public class Response implements ServletResponse{


    private static final int BUFFER_SIZE = 1024;

    private OutputStream output;
    private Request request;

    public Response(OutputStream output){
        this.output = output;
    }

    public void sentStaticResource() throws IOException{
        byte[] buffer = new byte[BUFFER_SIZE];
        FileInputStream fis = null;
        try {
            File file = new File(GlobalConstants.STATIC_RESOURCE_PATH,request.getUri());
            fis = new FileInputStream(file);

            int ch = fis.read(buffer,0,BUFFER_SIZE);
            while (ch != -1){
                output.write(buffer,0,ch);
                ch = fis.read(buffer,0,BUFFER_SIZE);
            }
        } catch (Exception e){
            e.printStackTrace();
            String errorMsg = "HTTP/1.1 404 File Not Found\r\n";
            errorMsg += "Content-Type: text/html\r\n";
            errorMsg += "Content-Length: 23\r\n";
            errorMsg += "\r\n";
            errorMsg += "<h1>File Not Found</h1>\r\n";
            output.write(errorMsg.getBytes());
        } finally {
            if (fis != null){
                fis.close();
            }
        }
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public OutputStream getOutput() {
        return output;
    }

    public void setOutput(OutputStream output) {
        this.output = output;
    }

    //****      ServletResponse default implements      ****
    public String getCharacterEncoding() {
        return null;
    }

    public String getContentType() {
        return null;
    }

    public ServletOutputStream getOutputStream() throws IOException {
        return null;
    }

    public PrintWriter getWriter() throws IOException {
        //auto flush is true,println will flush, but print will not.
        return new PrintWriter(output,true);
    }

    public void setCharacterEncoding(String s) {

    }

    public void setContentLength(int i) {

    }

    public void setContentType(String s) {

    }

    public void setBufferSize(int i) {

    }

    public int getBufferSize() {
        return 0;
    }

    public void flushBuffer() throws IOException {

    }

    public void resetBuffer() {

    }

    public boolean isCommitted() {
        return false;
    }

    public void reset() {

    }

    public void setLocale(Locale locale) {

    }

    public Locale getLocale() {
        return null;
    }
}
