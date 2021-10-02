package com.luanmateus.springessentials.util.error;

import lombok.Data;

@Data
public class ErrorDetail {
    private String title;
    private Integer status;
    private String detail;
    private Long timestamp;
    private String developerMessage;
}
