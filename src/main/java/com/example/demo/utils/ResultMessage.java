package com.example.demo.utils;

/**
 * api的json交互格式 如下
 * {
 *     "succeed":true, //业务成功的判断
 *     "code":-1, //业务成功== 0,失败== -1。其他值以后对应不同的操作
 *     "msg":"消息",
 *     "data":{},//只会是对象类型和数组类型
 *     // ... 可能会有其他字段单不恒定。可根据需求处理。但绝不是null
 * }
 */
public class ResultMessage {

    private String code;
    private String msg;
    private Object data;

    public ResultMessage(Object data){
        this.data = data;
        this.msg = "success";
        this.code = ResultFlagEnum.SUCCESS.getValue();
    }
    public ResultMessage(ResultFlagEnum status, String message, Object data){
        this.code = status.getValue();
        this.msg = message;
        this.data = data;
    }
    public ResultMessage(ResultFlagEnum status, String message){
        this.code = status.getValue();
        this.code = message;
        this.data = "{}";
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static ResultMessage sucess(Object result){
        return new ResultMessage(result);
    }

    public static ResultMessage fail(String code){
        return new ResultMessage(ResultFlagEnum.getEnum(code),"请求失败");
    }
    public static ResultMessage fail(String error,Object object){
        return new ResultMessage(ResultFlagEnum.FAILED,error,object);
    }
    public static ResultMessage sucess(){
        return new ResultMessage(ResultFlagEnum.SUCCESS,"success");
    }

    public static ResultMessage fail(){
        return new ResultMessage(ResultFlagEnum.FAILED,"false");
    }
}
