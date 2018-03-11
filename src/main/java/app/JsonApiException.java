package app;

import javax.ws.rs.WebApplicationException;

public class JsonApiException extends WebApplicationException {

    private int status;
    private String code;
    private String title;
    private String detail;

    public JsonApiException(int status, String code, String title, String detail) {
        super(detail, status);
        this.status = status;
        this.code = code;
        this.title = title;
        this.detail = detail;
    }

    public int getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDetail() {
        return detail;
    }

}
