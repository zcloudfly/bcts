package com.bcts.common.constants;

public enum  HttpStatusConstants {
    BAD_GETEAY("502","上游服务无法连接");
    private String status;
    private String content;

    HttpStatusConstants(String status, String content) {
        this.status = status;
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public String getContent() {
        return content;
    }
}
