package com.yyc.eventbus.observermode;

public class Bad1  implements BadGuy{

   private Police police=new Police();

    @Override
    public void notice(String message) {

        //在观察
        police.handle(message);
    }
}