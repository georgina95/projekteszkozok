package reportService.utility;

import lombok.Data;

@Data
public class Response<T> {

    private String error;
    private T data;

    public Response(String error, T data) {
        this.error = error;
        this.data = data;

    }

    public static <T> Response<T> ok(T data) {
        return new Response<T>(null, data);
    }

    public static <T> Response<T> error(String message) {
        return new Response<T>(message, null);
    }


    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
