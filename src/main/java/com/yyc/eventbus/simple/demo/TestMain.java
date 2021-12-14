package com.yyc.eventbus.simple.demo;

import com.google.common.eventbus.EventBus;
import com.yyc.eventbus.simple.demo.listener.DataListenerOne;
import com.yyc.eventbus.simple.demo.listener.DataListenerTwo;
import com.yyc.eventbus.simple.demo.event.EventBusCenter;
import com.yyc.eventbus.simple.demo.listener.DeadListener;

/**
 * @program: eventbus
 * @description:
 * @author: Anakin Yang
 * @create: 2021-10-26 17:06
 **/
public class TestMain {

    public static void main(String[] args) {
        final EventBus eventBus = new EventBus(){
            @Override public String toString() {
                return "DEAD-EVENT-BUS";
            }
        };
        DataListenerOne dataListenerOne = new DataListenerOne();
        DataListenerTwo dataListenerTwo = new DataListenerTwo();
        DeadListener deadListener = new DeadListener();
        /**
        * register(Object listener)的工作就是找出这个Listener对哪些事件感兴趣，
         * 然后把这种事件类型和该Listener构建成的Subscriber加到subscribers中。
         * unregister的过程和register类似，只从subscribers删掉Listener感兴趣的事件。
         * 下面我们分别看看18版本和19版本register，主要的区别就是一个是加锁的版本，一个用的是并发容器。
        **/
        /**
        * SubscriberRegister通过reflection找出该Listener对象(包括其父类）哪些Method用@Subscriber注解了，
         * 用@Subscriber注解的方法表示当某件事件发生时，希望收到事件通知。在@Subscriber注解的方法中只能包含一个参数那就是Event，否则会出错。
         * 在reflection的时候用LoadingCache<Class<?>, ImmutableList<Method>> subscriberMethodsCache缓存了该Listener Class和对应的Method，
         * 加快了后面对同一类Listener进行register的效率。用MethodIdentifier作为Map的key来判别Method的是否相等。
        **/
        EventBusCenter.register(dataListenerOne);
//        EventBusCenter.register(dataListenerTwo);
        EventBusCenter.register(deadListener);
        //重写EventBus的toString方法，使eventBus的名称为DEAD-EVENT-BUS
        System.out.println("============   start  ====================");

        // 只有注册的参数类型为String的方法会被调用
        //eventBus会根据Listener的参数类型的不同，分别向不同的Subscribe发送不同的消息。
        /**
         * 获取所有监听此事件的订阅者；
         * 如果有订阅者，给这些订阅者发送事件；
         * 如果没有订阅者，创建死事件类；
         * 获取当前线程的事件队列（queue类型为ThreadLocal)，并添加新增的事件；
         * 如果还没发送，依次将事件队列顺序发送。
        **/
        EventBusCenter.post("post string method");
        EventBusCenter.post(123);

//        System.out.println("============ after unregister ============");
//        // 注销observer2
//        EventBusCenter.unregister(dataListenerTwo);
//        EventBusCenter.post("post string method");
//        EventBusCenter.post(123);
//        System.out.println("============    end           =============");
    }

}
