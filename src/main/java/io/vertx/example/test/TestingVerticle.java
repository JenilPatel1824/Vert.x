package io.vertx.example.test;

import io.vertx.core.AbstractVerticle;

public class TestingVerticle extends AbstractVerticle {
    @Override
    public void start() throws Exception {
        System.out.println(Thread.currentThread().getName()+" started testing verticle");

        Thread.sleep(5000);

        System.out.println(Thread.currentThread().getName()+" finished testing verticle");

    }
}
