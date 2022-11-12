package com.mainsoft.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> implements Serializable {

    private static final long serialVersionUID = 8478965420460393974L;

    private String message;
    private T data;

    public Response(String message) {
        this.message = message;
    }
}
