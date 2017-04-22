package version2;

import javax.servlet.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

/**
 * Created by liuzhichao on 17/4/9.
 */
public class Request implements ServletRequest {

    private InputStream input;

    private String uri;

    public Request(InputStream input){
        this.input = input;
    }

    public void parse(){
        if (input == null){
            return;
        }
        StringBuilder sb = new StringBuilder();
        byte[] buffer = new byte[2048];
        int i = 0;
        try {
            i = input.read(buffer);
        } catch (Exception e){
            e.printStackTrace();
            i = -1;
        }

        for (int k = 0 ; k < i ; k++){
            sb.append((char) buffer[k]);
        }

        System.out.println("ready parse request : "+sb.toString());
        uri = parseUrl(sb.toString());
    }

    private String parseUrl(String requestStr) {
        int index1 ,index2;
        index1 = requestStr.indexOf(" ");
        if (index1 != -1){
            index2 = requestStr.indexOf(" ",index1+1);
            if (index2 > index1){
                return requestStr.substring(index1+1,index2);
            }
        }
        return null;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    //****     ServletRequest default implements     ****
    public Object getAttribute(String s) {
        return null;
    }

    public Enumeration<String> getAttributeNames() {
        return null;
    }

    public String getCharacterEncoding() {
        return null;
    }

    public void setCharacterEncoding(String s) throws UnsupportedEncodingException {

    }

    public int getContentLength() {
        return 0;
    }

    public String getContentType() {
        return null;
    }

    public ServletInputStream getInputStream() throws IOException {
        return null;
    }

    public String getParameter(String s) {
        return null;
    }

    public Enumeration<String> getParameterNames() {
        return null;
    }

    public String[] getParameterValues(String s) {
        return new String[0];
    }

    public Map<String, String[]> getParameterMap() {
        return null;
    }

    public String getProtocol() {
        return null;
    }

    public String getScheme() {
        return null;
    }

    public String getServerName() {
        return null;
    }

    public int getServerPort() {
        return 0;
    }

    public BufferedReader getReader() throws IOException {
        return null;
    }

    public String getRemoteAddr() {
        return null;
    }

    public String getRemoteHost() {
        return null;
    }

    public void setAttribute(String s, Object o) {

    }

    public void removeAttribute(String s) {

    }

    public Locale getLocale() {
        return null;
    }

    public Enumeration<Locale> getLocales() {
        return null;
    }

    public boolean isSecure() {
        return false;
    }

    public RequestDispatcher getRequestDispatcher(String s) {
        return null;
    }

    public String getRealPath(String s) {
        return null;
    }

    public int getRemotePort() {
        return 0;
    }

    public String getLocalName() {
        return null;
    }

    public String getLocalAddr() {
        return null;
    }

    public int getLocalPort() {
        return 0;
    }

    public ServletContext getServletContext() {
        return null;
    }

    public AsyncContext startAsync() throws IllegalStateException {
        return null;
    }

    public AsyncContext startAsync(ServletRequest servletRequest, ServletResponse servletResponse) throws IllegalStateException {
        return null;
    }

    public boolean isAsyncStarted() {
        return false;
    }

    public boolean isAsyncSupported() {
        return false;
    }

    public AsyncContext getAsyncContext() {
        return null;
    }

    public DispatcherType getDispatcherType() {
        return null;
    }
}
