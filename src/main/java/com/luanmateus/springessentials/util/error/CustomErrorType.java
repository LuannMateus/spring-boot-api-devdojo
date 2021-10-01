package com.luanmateus.springessentials.util.error;

import lombok.Data;

@Data
public class CustomErrorType {
    private String errorMessage;

    public CustomErrorType(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
