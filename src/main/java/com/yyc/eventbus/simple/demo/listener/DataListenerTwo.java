package com.yyc.eventbus.simple.demo.listener;
  
import com.google.common.eventbus.Subscribe;  
  
/** 
 * Created by zhangzh on 2017/1/10. 
 */  
public class DataListenerTwo extends AbstractListener{
    /** 
     * post() 不支持自动装箱功能,只能使用Integer,不能使用int,否则handlersByType的Class会是int而不是Intege 
     * 而传入的int msg参数在post(int msg)的时候会被包装成Integer,导致无法匹配到 
     */  
    @Subscribe  
    public void func(Integer msg) {  
        System.out.println("Integer msg: " + msg);  
    }  
}  