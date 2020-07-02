package com.iLearntToday.articleManagentService.entity;

import lombok.Data;

@Data
public class ResponseStatus {

    int responseCode;
    String message;

    public ResponseStatus(int responseCode, String message) {
        this.responseCode = responseCode;
        this.message = message;
    }
}
