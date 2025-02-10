package io.vertx.example.worker;

import io.vertx.core.AbstractVerticle;

public class BlockingWorker4 extends AbstractVerticle
{
    @Override
    public void start() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+" 4BlockingWorker4 started");

        vertx.executeBlocking(promis -> {
            System.out.println(Thread.currentThread().getName()+" 4exe Blocking 4 started");
            try {
                System.out.println(Thread.currentThread().getName()+"  4 inside exe 4 Blocking going to slp");
                Thread.sleep(60000);
                promis.complete();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },asyncResult -> {
            if(asyncResult.succeeded())
            {
                System.out.println(Thread.currentThread().getName()+" 4exe Blocking done");
            }
        });


        vertx.executeBlocking(promis -> {
            System.out.println(Thread.currentThread().getName()+" exe Blocking started2");
            try {
                System.out.println(Thread.currentThread().getName()+" inside exe Blocking going to slp2");
                Thread.sleep(60000);
                promis.complete();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },asyncResult -> {
            if(asyncResult.succeeded())
            {
                System.out.println(Thread.currentThread().getName()+" exe Blocking done2");
            }
        });

        System.out.println(Thread.currentThread().getName()+" Blocking started 2 line abobve");


        // Thread.sleep(60000);
    }
}
