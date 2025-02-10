package io.vertx.example.worker;

import io.vertx.core.AbstractVerticle;

public class BlockingWorker extends AbstractVerticle
{
    @Override
    public void start() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+" 1BlockingWorker1 started");

        vertx.executeBlocking(promis -> {
            System.out.println(Thread.currentThread().getName()+" 1exe Blocking started");
            try {
                System.out.println(Thread.currentThread().getName()+"1 inside exe Blocking going to slp");
                Thread.sleep(60000);
                promis.complete();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },asyncResult -> {
            if(asyncResult.succeeded())
            {
                System.out.println(Thread.currentThread().getName()+" 1exe Blocking done");
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
