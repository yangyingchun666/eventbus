package com.yyc.eventbus.simple.demo.listener;
  
import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.Subscribe;

/** 
 * Created by zhangzh on 2017/1/10. 
 */  
public class DeadListener extends AbstractListener {
  
    /** 
     * 只有通过@Subscribe注解的方法才会被注册进EventBus 
     * 而且方法有且只能有1个参数 
     * 
     * @param event
     */
    @Subscribe
    public void handle(DeadEvent event){
        //获取事件源
        System.out.println("deadEvent:"+event.toString());//DEAD-EVENT-BUS
        //获取事件
        System.out.println("deadEvent:"+event.getEvent());//DeadEventListener event
    }

}  