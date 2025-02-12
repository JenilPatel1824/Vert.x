package io.vertx.example;

import io.vertx.core.AbstractVerticle;

public class v extends AbstractVerticle
{
    @Override
    public void start() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName()+  " Hello World" + deploymentID());
        vertx.setTimer(2000,id->{
            System.out.println("intrupting");
            Thread.currentThread().interrupt();

        });
    }

    @Override
    public void stop()
    {
        System.out.println("stop");
        Thread.currentThread().interrupt();
    }
}