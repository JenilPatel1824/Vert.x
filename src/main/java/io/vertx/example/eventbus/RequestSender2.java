package io.vertx.example.eventbus;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;

public class RequestSender2 extends AbstractVerticle {
    @Override
    public void start() throws Exception {
        EventBus eventBus = vertx.eventBus();
        eventBus.request("request","req sent from "+Thread.currentThread().getName(), reply -> {
            if(reply.succeeded())
            {
                System.out.println("Recived by "+Thread.currentThread().getName()+" "+reply.result().body());
            }
        });
    }
}
