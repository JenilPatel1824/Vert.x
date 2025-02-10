package io.vertx.example;

import io.vertx.core.*;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.example.eventbus.*;
import io.vertx.example.file.FileVerticle;
import io.vertx.example.future.FutureCompositionExample;
import io.vertx.example.future.FutureCoordinationExample;
import io.vertx.example.future.FuturePromise;
import io.vertx.example.http.HttpClientExample;
import io.vertx.example.http.HttpServerExample;
import io.vertx.example.router.HttpserverRouter;
import io.vertx.example.router.RouterWithSession;
import io.vertx.example.tcpserver.TcpClient;
import io.vertx.example.tcpserver.TcpServer;
import io.vertx.example.test.TestingVerticle;
import io.vertx.example.worker.*;

public class MainVerticle extends AbstractVerticle
{
    @Override
    public void start()
    {
        System.out.println(new VertxOptions().getBlockedThreadCheckInterval());

        System.out.println(new VertxOptions().getMaxEventLoopExecuteTime());

        System.out.println(new VertxOptions().getEventLoopPoolSize());

        System.out.println(new VertxOptions().getMaxWorkerExecuteTime() );

        System.out.println(new VertxOptions().getInternalBlockingPoolSize());

        System.out.println(new VertxOptions().getWorkerPoolSize());

        vertx.deployVerticle(new FutureCoordinationExample());

        //vertx.deployVerticle(new WorkerVerticle());

//        vertx.deployVerticle(new HttpserverRouter());
//
//        vertx.deployVerticle(new HttpClientExample());
//
//        vertx.deployVerticle(new HttpClientExample());





        //vertx.deployVerticle(new TcpServer());
        //vertx.deployVerticle(new TcpClient());
//        vertx.deployVerticle(new RouterWithSession()).onComplete(result -> {
//            System.out.println("HttpServerExample deployed");
//        });
//        vertx.deployVerticle(new HttpClientExample()).onComplete(result -> {
//            System.out.println("HTTP client deployed");
//        });
    }



    public static void main(String[] args) throws InterruptedException {




        System.out.println(Thread.currentThread().getName()+" Main called");

        Vertx vertx = Vertx.vertx(new VertxOptions().setBlockedThreadCheckInterval(1000).setWorkerPoolSize(3));


        System.out.println(new VertxOptions().getBlockedThreadCheckInterval());

        System.out.println(new VertxOptions().setMaxEventLoopExecuteTime(2000000000));



        System.out.println(new VertxOptions().getEventLoopPoolSize());

        System.out.println(new VertxOptions().getMaxWorkerExecuteTime() );

        System.out.println(new VertxOptions().getInternalBlockingPoolSize());





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

//        vertx.deployVerticle(new TcpServer());
//        vertx.deployVerticle(new TcpClient());

//        System.out.println("deploying verticle after 10 sec");
//        vertx.setPeriodic(1000, l -> {
//            System.out.println(Thread.currentThread().getName()+" ..................................................................vertx");
//        });

        //Thread.sleep(10000);



//        vertx.deployVerticle(new FutureCoordinationExample()).onComplete(result -> {
//            if (result.succeeded()) {
//                System.out.println("deployed verticle future coordination example");
//            }
//        });
//
//        vertx.deployVerticle(new TestingVerticle()).onComplete(result -> {
//            if (result.succeeded()) {
//                System.out.println("deployed testing verticle");
//            }
//        });

   //     System.out.println("main sleeping again 20 seconds");

        //Thread.sleep(20000);

//        vertx.deployVerticle(new FileVerticle()).onComplete(stringAsyncResult -> {
//            if (stringAsyncResult.succeeded()) {
//                System.out.println("file deplyed succ");
//            }
//        });
//        vertx.deployVerticle(new WorkerVerticle(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolSize(1));
//        vertx.deployVerticle(new WorkerVerticle(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolSize(1));
//        vertx.deployVerticle(new WorkerVerticle(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolSize(1));
//        vertx.deployVerticle(new WorkerVerticle(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolSize(1));
//        vertx.deployVerticle(new WorkerVerticle(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolSize(1));
//        vertx.deployVerticle(new WorkerVerticle(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolSize(1));
//        vertx.deployVerticle(new WorkerVerticle(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolSize(1));
//        vertx.deployVerticle(new WorkerVerticle(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolSize(1));
//        vertx.deployVerticle(new WorkerVerticle(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolSize(1));
//        vertx.deployVerticle(new WorkerVerticle(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolSize(1));
//        vertx.deployVerticle(new WorkerVerticle(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolSize(1));
//        vertx.deployVerticle(new WorkerVerticle(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolSize(1));
//        vertx.deployVerticle(new WorkerVerticle(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolSize(1));
//        vertx.deployVerticle(new WorkerVerticle(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolSize(1));
//        vertx.deployVerticle(new WorkerVerticle(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolSize(1));
//        vertx.deployVerticle(new WorkerVerticle(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolSize(1));
//        vertx.deployVerticle(new WorkerVerticle(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolSize(1));
//        vertx.deployVerticle(new WorkerVerticle(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolSize(1));


//        vertx.deployVerticle(new WorkerHandler(),new DeploymentOptions().setWorkerPoolSize(1));
//        vertx.deployVerticle(new FutureCoordinationExample(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER));
//        vertx.deployVerticle(new WorkerVerticle(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolSize(1).setWorkerPoolName("worker 1"));

        //vertx.deployVerticle(new WorkerHandler());
//
//        vertx.deployVerticle(new WorkerVerticle(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolSize(1));
//        vertx.deployVerticle(new WorkerVerticle2(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolSize(1));
//        vertx.deployVerticle(new BlokingWorker(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolSize(1));

//        vertx.deployVerticle(new BlockingWorker(),new DeploymentOptions().setWorkerPoolName("BlokingWorker").setThreadingModel(ThreadingModel.WORKER));
//        vertx.deployVerticle(new BlockingWorker2(),new DeploymentOptions().setWorkerPoolName("BlokingWorker").setThreadingModel(ThreadingModel.WORKER));
//        vertx.deployVerticle(new BlockingWorker3(),new DeploymentOptions().setWorkerPoolName("BlokingWorker").setThreadingModel(ThreadingModel.WORKER));
//        vertx.deployVerticle(new BlockingWorker4(),new DeploymentOptions().setWorkerPoolName("BlokingWorker").setThreadingModel(ThreadingModel.WORKER));



      //  vertx.deployVerticle(new BlockingWorker(),new DeploymentOptions().setWorkerPoolName("BlokingWorker").setThreadingModel(ThreadingModel.WORKER));

//        vertx.deployVerticle(new WorkerVerticle2(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolName("worker"));
//        vertx.deployVerticle(new BlokingWorker(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolName("worker"));
//        vertx.deployVerticle(new WorkerVerticle(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolName("worker"));
//        vertx.deployVerticle(new WorkerVerticle2(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolName("worker"));
//        vertx.deployVerticle(new BlokingWorker(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolName("worker"));
//        vertx.deployVerticle(new WorkerVerticle(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolName("worker"));
//        vertx.deployVerticle(new WorkerVerticle2(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolName("worker"));
//        vertx.deployVerticle(new BlokingWorker(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolName("worker"));
//        vertx.deployVerticle(new WorkerVerticle(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolName("worker"));
//        vertx.deployVerticle(new WorkerVerticle2(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolName("worker"));
//        vertx.deployVerticle(new BlokingWorker(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolName("worker"));
//        vertx.deployVerticle(new WorkerVerticle(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolName("worker"));
//        vertx.deployVerticle(new WorkerVerticle2(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolName("worker"));
//        vertx.deployVerticle(new BlokingWorker(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolName("worker"));
//        vertx.deployVerticle(new WorkerVerticle(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolName("worker"));
//        vertx.deployVerticle(new WorkerVerticle2(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolName("worker"));
//        vertx.deployVerticle(new BlokingWorker(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolName("worker"));
//        vertx.deployVerticle(new WorkerVerticle(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolName("worker"));
//        vertx.deployVerticle(new WorkerVerticle2(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolName("worker"));
//        vertx.deployVerticle(new BlokingWorker(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolName("worker"));
//        vertx.deployVerticle(new BlokingWorker(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolName("worker"));
//        vertx.deployVerticle(new BlokingWorker(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolName("worker"));
//        vertx.deployVerticle(new BlokingWorker(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolName("worker"));
//        vertx.deployVerticle(new BlokingWorker(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolName("worker"));
//        vertx.deployVerticle(new BlokingWorker(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolName("worker"));
//        vertx.deployVerticle(new BlokingWorker(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolName("worker"));
//        vertx.deployVerticle(new BlokingWorker(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolName("worker"));
//        vertx.deployVerticle(new BlokingWorker(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolName("worker"));
//        vertx.deployVerticle(new BlokingWorker(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolName("worker"));
//        vertx.deployVerticle(new BlokingWorker(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolName("worker"));
//        vertx.deployVerticle(new BlokingWorker(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolName("worker"));
//        vertx.deployVerticle(new BlokingWorker(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolName("worker"));
//        vertx.deployVerticle(new BlokingWorker(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolName("worker"));
//        vertx.deployVerticle(new BlokingWorker(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolName("worker"));
//        vertx.deployVerticle(new BlokingWorker(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolName("worker"));
//
//        vertx.deployVerticle(new BlokingWorker(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolName("worker1"));
//        vertx.deployVerticle(new BlokingWorker(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolName("worker1"));
//        vertx.deployVerticle(new BlokingWorker(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolName("worker1"));
//        vertx.deployVerticle(new BlokingWorker(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolName("worker1"));
//        vertx.deployVerticle(new BlokingWorker(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolName("worker1"));
//        vertx.deployVerticle(new BlokingWorker(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolName("worker1"));
//        vertx.deployVerticle(new BlokingWorker(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolName("worker1"));
//        vertx.deployVerticle(new BlokingWorker(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolName("worker1"));
//        vertx.deployVerticle(new BlokingWorker(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolName("worker1"));
//        vertx.deployVerticle(new BlokingWorker(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolName("worker1"));
//        vertx.deployVerticle(new BlokingWorker(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolName("worker1"));
//        vertx.deployVerticle(new BlokingWorker(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolName("worker1"));
//        vertx.deployVerticle(new BlokingWorker(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolName("worker1"));
//        vertx.deployVerticle(new BlokingWorker(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolName("worker1"));
//        vertx.deployVerticle(new BlokingWorker(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolName("worker1"));
//        vertx.deployVerticle(new BlokingWorker(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolName("worker1"));
//
////
//        vertx.deployVerticle(new BlokingWorker(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER));
//        vertx.deployVerticle(new BlokingWorker(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER));
//        vertx.deployVerticle(new BlokingWorker(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER));



        //      //  vertx.deployVerticle(new WorkerHandler(), new DeploymentOptions().setWorkerPoolSize(5).setWorkerPoolName("worker.1"));
//        vertx.deployVerticle(new BlokingWorker(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolSize(1).setWorkerPoolName("Blocking Worker "));

       // System.out.println("dep option worker pool size: "+new DeploymentOptions().getWorkerPoolSize());

//        vertx.deployVerticle(new WorkerVerticle(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolSize(1));
//        vertx.deployVerticle(new WorkerVerticle(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolSize(1));
//        vertx.deployVerticle(new WorkerVerticle(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolSize(1));
//        vertx.deployVerticle(new WorkerVerticle(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolSize(1));
//        vertx.deployVerticle(new WorkerVerticle(),new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setWorkerPoolSize(1));

      //  System.out.println(Thread.currentThread().getName()+" Main ended");

//        vertx.deployVerticle(new HttpserverRouter());
//
//        vertx.deployVerticle(new HttpClientExample());
//
//        vertx.deployVerticle(new HttpClientExample());
//        vertx.deployVerticle(new WorkerHandler(), new DeploymentOptions().setWorkerPoolSize(2).setWorkerPoolName("workerrrrr"));
                vertx.deployVerticle(new BlockingWorker(),new DeploymentOptions().setWorker(true));


    }
}
