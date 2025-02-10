package io.vertx.example.worker;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;

public class WorkerVerticle2 extends AbstractVerticle {
    @Override
    public void start() throws Exception

    {

        System.out.println(Thread.currentThread().getName()+" Worker2 started");
        Thread.sleep(60000);



        EventBus eventBus = vertx.eventBus();

        eventBus.consumer("event.queue",message ->
        {
            System.out.println(Thread.currentThread().getName()+" " +message.body());

            try
            {
                Thread.sleep(15000);
            }
            catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }

            System.out.println(Thread.currentThread().getName()+" worker vert 2 done" );

        });

    }
}
