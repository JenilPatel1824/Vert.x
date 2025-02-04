package io.vertx.example.eventbus;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.Message;
import io.vertx.core.eventbus.MessageConsumer;
import io.vertx.core.json.Json;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.JsonObject;



public class TestEventBusvertical extends AbstractVerticle {



    @Override
    public void start()
    {
        EventBus eb = vertx.eventBus();

        System.out.println("sending events");

        System.out.println(new DeliveryOptions().getSendTimeout());

        eb.publish("publisher", new JsonObject().put("message", "Hello from publisher"));

        MessageConsumer<JsonObject> firstConsumer=  eb.consumer("sender", message -> {
            System.out.println("received message by cons 1");
            System.out.println(message.body());
        });

        MessageConsumer<JsonObject> secondConsumer = eb.consumer("sender", message -> {
            System.out.println("received message by cons 2 ");
            System.out.println(message.body());
        });


        Buffer buff = Buffer.buffer();
        buff.appendString("Hello from publisher");
        buff.appendInt(5000);
        buff.appendString("Hello from publisher");

        System.out.println("buff: "+buff.getString(0,20));
        System.out.println("buff: "+buff.getInt(20));
        System.out.println("buff: "+buff.getString(24,buff.length()));




        System.out.println("cons 1 and 2 "+firstConsumer+" "+secondConsumer);

        firstConsumer.unregister();


        System.out.println("sending person");

        eb.send("sender", new JsonObject().put("message", "Hello from person"));

        System.out.println("Person sent");

        eb.send("sender", new JsonObject().put("message", "Hello from sender"));

        eb.send("sender", new JsonObject().put("message", "Hello from sender"));



        eb.request("request from "+Thread.currentThread().getName(), new JsonObject().put("message", "Hello from request"),new DeliveryOptions().setSendTimeout(4000), reply -> {
            if (reply.succeeded()) {
                System.out.println("received reply "+reply.result().body());
            }
            else {
                System.out.println("timed out");
            }
        });



    }
}
