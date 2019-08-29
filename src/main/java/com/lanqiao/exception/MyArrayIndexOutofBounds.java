package com.lanqiao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Auther: zhaomengyi
 * @Date: 2019/8/29 17:06
 * @Description:自定义异常页面
 */
@ResponseStatus(value= HttpStatus.FORBIDDEN,reason = "数组越界")
public class MyArrayIndexOutofBounds extends Exception{//自定义异常

}
