package com.iLearntToday.articleManagentService.entity;

import lombok.Data;

@Data
public class ResponseVO<T> {

    int responseCode;
    T body;

    public ResponseVO() {
    }

    public ResponseVO(int responseCode, T body) {
        this.responseCode = responseCode;
        this.body = body;
    }
}
