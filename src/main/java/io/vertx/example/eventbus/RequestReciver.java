package io.vertx.example.eventbus;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;

public class RequestReciver extends AbstractVerticle
{
    @Override
    public void start() throws Exception
    {
        EventBus eventBus = vertx.eventBus();
        eventBus.consumer("request",req ->{
            System.out.println("Recived "+req.body());
            req.reply(new JsonObject().put("message", "your req is processed"));
        });
    }
}
