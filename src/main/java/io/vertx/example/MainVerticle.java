package io.vertx.example;

import io.vertx.core.*;
import io.vertx.example.eventbus.*;
import io.vertx.example.future.FutureCompositionExample;
import io.vertx.example.future.FutureCoordinationExample;
import io.vertx.example.future.FuturePromise;
import io.vertx.example.http.HttpClientExample;
import io.vertx.example.http.HttpServerExample;
import io.vertx.example.tcpserver.TcpClient;
import io.vertx.example.tcpserver.TcpServer;
import io.vertx.example.worker.WorkerVerticle;

public class MainVerticle extends AbstractVerticle {

    @Override
    public void start()
    {
        Vertx vertx = Vertx.vertx(new VertxOptions().setBlockedThreadCheckInterval(1000));

        System.out.println(new VertxOptions().getBlockedThreadCheckInterval());

        System.out.println(new VertxOptions().getMaxEventLoopExecuteTime());

        System.out.println(new VertxOptions().getEventLoopPoolSize());

        System.out.println(new VertxOptions().getMaxWorkerExecuteTime() );

        System.out.println(new VertxOptions().getInternalBlockingPoolSize());

        System.out.println(new VertxOptions().getWorkerPoolSize());

        //vertx.deployVerticle(new TcpServer());
        //vertx.deployVerticle(new TcpClient());
        vertx.deployVerticle(new HttpServerExample());
        vertx.deployVerticle(new HttpClientExample());
    }

    public static void main(String[] args) throws InterruptedException {
        Vertx vertx = Vertx.vertx(new VertxOptions().setBlockedThreadCheckInterval(1000));

        System.out.println(new VertxOptions().getBlockedThreadCheckInterval());

        System.out.println(new VertxOptions().getMaxEventLoopExecuteTime());

        System.out.println(new VertxOptions().getEventLoopPoolSize());

        System.out.println(new VertxOptions().getMaxWorkerExecuteTime() );

        System.out.println(new VertxOptions().getInternalBlockingPoolSize());

        System.out.println(new VertxOptions().getWorkerPoolSize());


        //vertx.deployVerticle(new vertxcore());

        //vertx.deployVerticle(new TestEventBusvertical());

        //vertx.deployVerticle(new FuturePromise());

       // vertx.deployVerticle(new FutureCompositionExample());

//        vertx.deployVerticle(new FutureCoordinationExample()).onComplete(result -> {
//            System.out.println(result.result()+" dep done");
//        });



//        vertx.deployVerticle(new WorkerVerticle(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER)).onComplete(result -> {
//            System.out.println(result.result()+" dep done of worker");
//        });
//
//        vertx.deployVerticle(new EventBusreciver());
//        vertx.deployVerticle(new TestEventBusvertical());


//        vertx.deployVerticle(new RequestSender());
//        vertx.deployVerticle(new RequestSender2());
//        vertx.deployVerticle(new RequestReciver());

        //vertx.deployVerticle(new TestEventBusvertical());

        vertx.deployVerticle(new TcpServer());
        vertx.deployVerticle(new TcpClient());


    }




}
