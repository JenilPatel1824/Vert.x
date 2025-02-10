package io.vertx.example.worker;

import io.vertx.core.AbstractVerticle;

public class BlockingWorker2 extends AbstractVerticle
{
    @Override
    public void start() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+" 2BlockingWorker2  started");

        vertx.executeBlocking(promis -> {
            System.out.println(Thread.currentThread().getName()+" 2exe Blocking started");
            try {
                System.out.println(Thread.currentThread().getName()+" 2inside exe Blocking going to slp");
                Thread.sleep(60000);
                promis.complete();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },asyncResult -> {
            if(asyncResult.succeeded())
            {
                System.out.println(Thread.currentThread().getName()+" 2exe Blocking done");
            }
        });




        System.out.println(Thread.currentThread().getName()+" Blocking started 2 line abobve");


        // Thread.sleep(60000);
    }
}
