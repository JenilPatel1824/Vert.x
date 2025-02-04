package io.vertx.example.eventbus;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.eventbus.EventBus;

public class EventBusreciver extends AbstractVerticle
{

    @Override
    public void start(Promise<Void> startPromise)
    {
        EventBus eventBus = vertx.eventBus();

        eventBus.consumer("publisher" , message ->{
            System.out.println("Received message: " + message.body());
        });

        eventBus.consumer("sender" , message ->{
            System.out.println("Received message: " + message.body());
        });

        eventBus.consumer("request" , request ->{

            vertx.setTimer(5000,id->{
                System.out.println("Received message: " + request.body());
                request.reply(request.body()+" !!markerd");
                request.reply(request.body());
            });

        });





    }
}
