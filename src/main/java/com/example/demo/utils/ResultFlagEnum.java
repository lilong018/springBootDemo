package com.example.demo.utils;

public enum ResultFlagEnum {
    SUCCESS("0"), //成功
    FAILED("1"),//程序、服务器异常
    OTHEREXCEPTION("999");//假象判断

    private String value;

    ResultFlagEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    public static ResultFlagEnum getEnum(String code){
        switch (code){
            case "0":
                return SUCCESS;
            case "1":
                return FAILED;
            default:
                return OTHEREXCEPTION;
        }

    }
}
