package io.vertx.example;

import io.vertx.core.*;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.json.JsonObject;

public class LMS extends AbstractVerticle {

//    public static Future<Void> run()
//    {
//        Promise promise=Promise.<Void>promise();
//        promise.complete();
//        try
//        {
//            throw new RuntimeException();
//        }
//        catch (Exception e)
//        {
//            promise.fail(e);
//        }
//        return promise.future();
//    }
//
//    public static void main(String[] args) {
//        run().onComplete(result->{
//            System.out.println(result.succeeded());
//        });
//


//    }

    @Override
    public void start()
    {


            System.out.println(Thread.currentThread().getName() + " started l");

            try{

            vertx.eventBus().consumer("test", message -> {

                System.out.println("got msg " + message.body());

                    Thread.sleep(3000);

                message.reply(message.body());

            });
        }
        catch (Exception e) {
            System.out.println("caught");
        }
    }

    public static void main(String[] args)
    {
        try {
            Vertx vertx = Vertx.vertx(new VertxOptions().setWarningExceptionTime(1));


        vertx.deployVerticle(new LMS()).onComplete(result -> {
            System.out.println(Thread.currentThread().getName()+" deployed l");
        });
        vertx.eventBus().request("test", new JsonObject(),new DeliveryOptions().setSendTimeout(2000),result -> {


            if(result.succeeded())
            {
                System.out.println(Thread.currentThread().getName()+" succ "+result.result().body());
            }

            else
            {
                System.out.println(Thread.currentThread().getName()+" fail    vgvjg  tyujb rajjjj"+result.cause());
            }
        });
        }
        catch (Exception e) {
            System.out.println("caught");
        }

    }

}
