package com.iLearntToday.articleManagentService.entity;

import lombok.Data;

@Data
public class ResponseVO {

    int responseCode;
    String message;

    public ResponseVO(int responseCode, String message) {
        this.responseCode = responseCode;
        this.message = message;
    }
}
