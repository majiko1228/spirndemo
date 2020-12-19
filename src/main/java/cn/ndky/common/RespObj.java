package cn.ndky.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespObj {

    public static int SUCCESS_CODE = 200;
    public static String SUCCESS_MESSAGE = "操作成功";
    public static int FAIL_CODE = 400;
    public static String FAIL_MESSAGE = "操作失败";
    private int code;
    private String message;
    private Object data;

    public static RespObj build(int code,String message,Object data){
        return new RespObj(code,message,data);
    }
    public static RespObj build(Object data){
        return new RespObj(SUCCESS_CODE,SUCCESS_MESSAGE,data);
    }

    public static RespObj fail(int code,String message,Object data){
        return new RespObj(code,message,data);
    }
    public static RespObj fail(Object data){
        return new RespObj(FAIL_CODE,FAIL_MESSAGE,data);
    }
}
