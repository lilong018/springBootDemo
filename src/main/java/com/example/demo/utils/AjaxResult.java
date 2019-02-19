package com.example.demo.utils;

import java.util.HashMap;

// TODO: 2019/2/13  修改此类或者新建一个类

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
/**
 * 操作消息提醒
 * 
 * @author ruoyi
 */
public class AjaxResult extends HashMap<String, Object>
{
    private static final long serialVersionUID = 1L;

    /**
     * 初始化一个新创建的 Message 对象
     */
    public AjaxResult()
    {
    }

    /**
     * 返回错误消息
     * 
     * @return 错误消息
     */
    public static AjaxResult error()
    {
        return error(1, "操作失败");
    }

    /**
     * 返回错误消息
     * 
     * @param msg 内容
     * @return 错误消息
     */
    public static AjaxResult error(String msg)
    {
        return error(500, msg);
    }

    /**
     * 返回错误消息
     * 
     * @param code 错误码
     * @param msg 内容
     * @return 错误消息
     */
    public static AjaxResult error(int code, String msg)
    {
        AjaxResult json = new AjaxResult();
        json.put("code", code);
        json.put("msg", msg);
        return json;
    }

    /**
     * 返回成功消息
     * 
     * @param msg 内容
     * @return 成功消息
     */
    public static AjaxResult success(String msg)
    {
        AjaxResult json = new AjaxResult();
        json.put("msg", msg);
        json.put("code", 0);
        return json;
    }

    /**
     *  添加跳转url信息
     *
     * @param ajaxResult
     * @return 成功消息
     */
    public static AjaxResult successUrl(AjaxResult ajaxResult,String url)
    {
        AjaxResult json = new AjaxResult();
        json.put("msg", ajaxResult.get("msg"));
        json.put("code", 0);
        json.put("url",url);
        return json;
    }
    
    /**
     * 返回成功消息
     * 
     * @return 成功消息
     */
    public static AjaxResult success()
    {
        return AjaxResult.success("操作成功");
    }

    /**
     * 返回成功消息
     * 
     * @param key 键值
     * @param value 内容
     * @return 成功消息
     */
    @Override
    public AjaxResult put(String key, Object value)
    {
        super.put(key, value);
        return this;
    }
}
