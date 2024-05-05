package ZERL.server.models;

import jakarta.servlet.http.HttpServletRequest;

public class ErrorInfo {

    public final String url;
    public final String type;
    public final String error;

    public ErrorInfo(HttpServletRequest url, String type, Exception error) {
        this.url = url.getRequestURL().toString();
        this.type = type;
        this.error = error.getLocalizedMessage();
    }
}
