package com.yyc.eventbus.complex.demo.asyncEventBus;

import static java.util.concurrent.Executors.newFixedThreadPool;

import java.util.concurrent.Executors;

import com.google.common.eventbus.AsyncEventBus;

/**
 * @program: eventbus
 * @description:
 * @author: Anakin Yang
 * @create: 2021-11-02 11:53
 **/
public class AsyncEventBusCenter {

    private static final AsyncEventBus asyncEventBus = new AsyncEventBus(newFixedThreadPool(3));

    public static AsyncEventBus getInstance(){
        return asyncEventBus;
    }

    public static void register(Object obj) {
        asyncEventBus.register(obj);
    }

    public static void unregister(Object obj) {
        asyncEventBus.unregister(obj);
    }

    public static void post(Object obj) {
        asyncEventBus.post(obj);
    }
}
