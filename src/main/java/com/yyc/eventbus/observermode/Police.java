package com.yyc.eventbus.observermode;

public class Police implements Observer{

    @Override
    public void handle(String message) {
        System.out.println("有人偷东西了");
    }
}