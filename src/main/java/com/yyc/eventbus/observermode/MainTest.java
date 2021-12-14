package com.yyc.eventbus.observermode;

public class MainTest {

    public static void main(String[] args) {

        //创建被观察者对象
        BadGuy badGuy=new Bad1();

        //创建观察者对象
        Observer observer=new Police();

        //关键词（消息内容）
        String message="又卖了一批货";

        badGuy.notice(message);
    }
}