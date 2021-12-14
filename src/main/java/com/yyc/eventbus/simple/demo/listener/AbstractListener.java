package com.yyc.eventbus.simple.demo.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.eventbus.Subscribe;

/**
 * @program: eventbus
 * @description:
 * @author: Anakin Yang
 * @create: 2021-10-26 17:15
 **/
public abstract class AbstractListener {
    private final static Logger LOGGER = LoggerFactory.getLogger(AbstractListener.class);

    /**
     *在观察者模式中，事件源中会维护一个Listener的列表，而且向这个事件源注册的Listener一般只会收到一类事件的通知，
     *如果Listener对多个不同类的事件感兴趣，则需要向多个事件源注册。EventBus是怎样实现Listener一次注册，
     * 能够知道Listener对那些事件感兴趣的，进而在有某类事件发生时通知到Listener的呢？答案在SubscriberRegistry这个类中。
     * 在SubscriberRegister有一个实例属性ConcurrentMap<Class<?>, CopyOnWriteArraySet<Subscriber>> subscribers，
     * 它维护了某个事件类型和对其感兴趣的Subscriber的列表。
     *
     * 事件注册的逻辑已写入代码注释中，主要为：
     *
     * 获取监听此对象的所有带注解的方法map；
     * 遍历class，获取所有的subscribers；
     * 如果内存中还没有此类的记录，添加一个new set；
     * 内存中已有此记录，直接叠加即可。
    **/
    @Subscribe
    public void commonTask(final String event){
        if (LOGGER.isInfoEnabled()){
            LOGGER.info("Received event [{}] will be handle by {}.{}", new Object[]{event,this.getClass().getSimpleName(),"commonTask"});
        }
    }
}
