package io.vertx.example;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.BlockingQueue;

class vx extends AbstractVerticle
{
    @Override
    public void start(Promise<Void> startPromise)
    {

        startPromise.complete();

        EventBus eb = vertx.eventBus();
        eb.consumer("test", msg -> {
            System.out.println(msg.body());
        });
        eb.consumer("test", msg -> {
            System.out.println(msg.body());
        });
        eb.consumer("test", msg -> {
            System.out.println(msg.body());
        });


        Map m =new HashMap();
        m.put("map", new HashSet<>());
        Set s = new HashSet();
        s.add("set");
        s.add("set2");

        JsonObject json = new JsonObject();
        json.put("hello","123");
        json.put("map",m);
        //json.put("set",s);

        eb.publish("test",json);

        System.out.println(Thread.currentThread().getName()+  " Hello World");

        vertx.deployVerticle(new v(),new DeploymentOptions().setInstances(2));
//        try{
//            Thread.sleep(7000);
//        }
//        catch (Exception e)
//        {
//            System.out.println("catch called.....");
//        }
    }
}

public class Main3
{
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        System.out.println(new DeploymentOptions().getInstances());
        vertx.deployVerticle(v.class.getName(),new DeploymentOptions().setInstances(5)).onComplete(result->
        {

            if(result.succeeded())
            {
                System.out.println("Vert.x deployed");
            }
            else
            {
                System.out.println("Vert.x failed to deploy");
            }
            vertx.setTimer(2000,id->{
                vertx.undeploy(result.result()).onComplete(result2->{
                    if(result2.succeeded()) {
                        System.out.println("undeploy completed");
                    }
                });

            });
            vertx.setTimer(3000,id->
            {
                vertx.deployVerticle(new v());
            });
        });

        System.out.println(v.class.getName());

    }
}
