package io.vertx.example;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.file.FileProps;
import io.vertx.core.file.FileSystem;

public class vertxcore extends AbstractVerticle {
    @Override
    public void start()
    {

//        EventBus eb = vertx.eventBus();
//
//        eb.consumer("publisher", msg -> {
//            System.out.println("Received by subscriber" + msg.body());
//        });
//
//        eb.consumer("sender", msg -> {
//            System.out.println("Received by reciver: " + msg.body());
//        });
//
//        eb.consumer("request", msg -> {
//            System.out.println("Received by request: " + msg.body());
//            msg.reply("recived request take the response");
//        });
//
//        long timerID = vertx.setTimer(1000, id -> {
//            System.out.println("And one second later this is printed");
//        });

//        long tid = vertx.setPeriodic(10000, id -> {
//            System.out.println("And every second this is printed");
//        });

        System.out.println("First this is printed");

        System.out.println("First this is printed");


        FileSystem fs = vertx.fileSystem();

        Future<FileProps> future = fs.props("/home/jenil/Documents/Vertx/src/main/resources/my_file.txt");
        future.onComplete((
                AsyncResult<FileProps> ar) -> {
            if (ar.succeeded()) {
                FileProps props = ar.result();
                System.out.println("File size = " + props.size());
            } else {
                System.out.println("Failure: " + ar.cause().getMessage());
            }
        });
    }
}
