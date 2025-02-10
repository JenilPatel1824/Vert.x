package io.vertx.example.file;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.file.FileSystem;

import java.util.concurrent.atomic.AtomicInteger;

public class FileVerticle extends AbstractVerticle {
    @Override
    public void start() throws Exception
    {

        AtomicInteger i= new AtomicInteger();

//        vertx.setPeriodic(300, l -> {
//            System.out.println(i.getAndIncrement());
//        });

        Thread.sleep(5000);
        System.out.println(Thread.currentThread().getName() + " FileVerticle started");

        FileSystem fileSystem = vertx.fileSystem();

        fileSystem.createFile("/home/jenil/Documents/vertx.txt").onComplete(result -> {
            if (result.succeeded()) {
                System.out.println("file created");
            }
        }).onFailure(failure -> {
            System.out.println(failure.getMessage());
        });

        fileSystem.writeFile("/home/jenil/Documents/vertx.txt",Buffer.buffer("hello it is being written from vertx code")).onComplete(result -> {
            if (result.succeeded()) {
                System.out.println("file written");
            }
        });
    }
}
