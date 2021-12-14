package com.yyc.eventbus.complex.demo.asynListenter;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;
import com.yyc.eventbus.simple.demo.listener.AbstractListener;

/**
 * @program: eventbus
 * @description:
 * @author: yangyc
 * @create: 2021-11-30 14:20
 **/
public class AsyncListener extends AbstractListener {

    /**
     * 只有通过@Subscribe注解的方法才会被注册进EventBus
     * 而且方法有且只能有1个参数
     *
     * @param msg
     */
    @Subscribe
    @AllowConcurrentEvents
    public void func(String msg) {
        System.out.println("收到消息: " + msg);
    }
}
