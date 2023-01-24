package jypark.blog.controllers.common;

import jypark.blog.entities.Documents;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApiPayload<T> {

    private boolean ok;
    private int statusCode;
    private T payload;

    public ApiPayload(T payload, int code) {
        this.ok = true;
        this.statusCode = code;
        this.payload = payload;
    }

    public static <T> ApiPayload create(T payload) {
        return new ApiPayload<>(payload, 201);
    }

    public static ApiPayload<Documents> badRequest() {
        return new ApiPayload<>(null, 400);
    }
}
