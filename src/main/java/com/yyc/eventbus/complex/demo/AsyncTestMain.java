package com.yyc.eventbus.complex.demo;

import static java.util.concurrent.Executors.*;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.yyc.eventbus.complex.demo.asynListenter.AsyncListener;
import com.yyc.eventbus.complex.demo.asyncEventBus.AsyncEventBusCenter;
import com.yyc.eventbus.simple.demo.event.EventBusCenter;
import com.yyc.eventbus.simple.demo.listener.DataListenerOne;
import com.yyc.eventbus.simple.demo.listener.DataListenerTwo;
import com.yyc.eventbus.simple.demo.listener.DeadListener;

/**
 * @program: eventbus
 * @description:
 * @author: Anakin Yang
 * @create: 2021-10-26 17:06
 **/
public class AsyncTestMain {
    private AsyncEventBus asyncEventBus;

    public static void main(String[] args) throws InterruptedException {
        AsyncListener dataListenerOne = new AsyncListener();
        AsyncEventBus asyncEventBus = AsyncEventBusCenter.getInstance();
        asyncEventBus.register(dataListenerOne);
        System.out.println("开始发送消息");
        asyncEventBus.post("这是消息");
        System.out.println("开始睡眠");
        TimeUnit.SECONDS.sleep(5L);
        System.out.println("睡眠结束");
    }

}
