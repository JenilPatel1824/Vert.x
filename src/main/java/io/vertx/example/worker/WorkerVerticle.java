package io.vertx.example.worker;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.WorkerExecutor;
import io.vertx.core.impl.NoStackTraceThrowable;

public class WorkerVerticle extends AbstractVerticle {

    @Override
    public void start() throws InterruptedException {

        System.out.println(Thread.currentThread().getName()+ " Starting worker verticle");
        Thread.sleep(5000);
        System.out.println(Thread.currentThread().getName()+ "  worker verticle over");
//        WorkerExecutor executor = vertx.createSharedWorkerExecutor("my-worker-pool");
//
//        // Simulating a long-running blocking task
//        executor.executeBlocking(promise -> {
//            try {
//                System.out.println("Trying to sleep");
//                Thread.sleep(2000); // Blocking for 5 seconds
//
//                promise.complete("Operation completed.");
//            } catch (InterruptedException e) {
//                System.out.println("cought interrupted");
//                promise.fail(new NoStackTraceThrowable("Blocking operation interrupted"));
//            }
//        }, res -> {
//            if (res.succeeded()) {
//                System.out.println("Blocking task completed: " + res.result());
//            } else {
//                System.err.println("Blocking task failed: " + res.cause());
//            }
//        });
    }
}
