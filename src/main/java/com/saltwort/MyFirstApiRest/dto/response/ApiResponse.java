package com.saltwort.MyFirstApiRest.dto.response;
import lombok.Data;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ApiResponse<T> {
    private String timeRequest;
    private String error;
    private boolean isSuccessfully;
    private int code;
    private T data;

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(LocalDateTime.now().toString(), null, true, 200, data);
    }

    public static <T> ApiResponse<T> error(String errorMessage, int code) {
        return new ApiResponse<>(LocalDateTime.now().toString(), errorMessage, false, code, null);
    }
}
