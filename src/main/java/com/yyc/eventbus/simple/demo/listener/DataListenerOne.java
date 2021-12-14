package com.yyc.eventbus.simple.demo.listener;
  
import com.google.common.eventbus.Subscribe;  
  
/** 
 * Created by zhangzh on 2017/1/10. 
 */  
public class DataListenerOne extends AbstractListener {
  
    /** 
     * 只有通过@Subscribe注解的方法才会被注册进EventBus 
     * 而且方法有且只能有1个参数 
     * 
     * @param msg 
     */  
    @Subscribe  
    public void func(String msg) {
        try {
            Thread.sleep(100);
            System.out.println("String msg: " + msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
  
}  