package io.vertx.example.future;

import io.vertx.core.*;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;
import io.vertx.example.worker.WorkerVerticle;

import java.util.ArrayList;
import java.util.List;

public class FutureCoordinationExample extends AbstractVerticle {

    @Override
    public void start() throws InterruptedException {

        System.out.println(Thread.currentThread().getName()+" future coordination example started + ");

        Thread.sleep(30000);

        vertx.executeBlocking(promise->
        {
            try
            {
                System.out.println(Thread.currentThread().getName()+" executing in execute blocking + ");
                Thread.sleep(10000);
                System.out.println(Thread.currentThread().getName()+" execute blocking done ");
                promise.complete();
            }
            catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        },res->{
            if(res.succeeded())
            {
                System.out.println(Thread.currentThread().getName()+" result from exec blocking "+res.result());
            }
        });


        EventBus eventBus = vertx.eventBus();

        System.out.println(Thread.currentThread().getName()+" deploying verticle worker ");

        vertx.deployVerticle(new WorkerVerticle(), new DeploymentOptions().setWorker(true));

        Thread.sleep(2000);

        eventBus.request("worker.queue",new JsonObject().put("id","123").put("command","test")).onComplete(messageAsyncResult ->{
            if (messageAsyncResult.succeeded()) {
                System.out.println(Thread.currentThread().getName()+" recived reply from workr "+ messageAsyncResult.result().body());
            }
        });

        System.out.println("message sent on eb");

        eventBus.consumer("worker.queue",message -> {
            System.out.println("received message: " + message.body());
        });



        Context ctx = vertx.getOrCreateContext();
        System.out.println(context.isWorkerContext());

        Future<String> service1Data = fetchDataFromService1();
        Future<String> service2Data = fetchDataFromService2();
        Future<String> service3Data = fetchDataFromService1();
        Future<String> service4Data = fetchDataFromService2();
        Future<String> service5Data = fetchDataFromService1();
        Future<String> service6Data = fetchDataFromService2();
        Future<String> service7Data = fetchDataFromService1();
        Future<String> service8Data = fetchDataFromService2();
        Future<String> service9Data = fetchDataFromService1();
        Future<String> service10Data = fetchDataFromService2();

        List<Future> futures = new ArrayList<>();

        futures.add(service1Data);
        futures.add(service2Data);
        futures.add(service3Data);
        futures.add(service4Data);
        futures.add(service5Data);
        futures.add(service6Data);
        futures.add(service7Data);
        futures.add(service8Data);
        futures.add(service9Data);
        futures.add(service10Data);



        CompositeFuture.all(futures)
                .onSuccess(composite ->
                {
                    //System.out.println("all services have completed, processing combined results.");
                })
                .onFailure(err -> {
                    // Handle failure (if any of the tasks fail)
                  //  System.out.println("An error occurred: " + err.getMessage()+" "+ err.getCause());
                });

        System.out.println("outside all");



//        Future.join(service1Data, service2Data).onSuccess(result -> {
//            System.out.println("Service 1 Data: " + service1Data.result());
//            System.out.println("Service 2 Data: " + service2Data.result());
//        });
    }



    // Simulate fetching data from service 1
    private Future<String> fetchDataFromService1() throws InterruptedException {
        Promise<String> promise = Promise.promise();

        //System.out.println("service 1 fetching data is executed by + "+ Thread.currentThread().getName());

        vertx.setTimer(5000, id -> {

           // System.out.println("reslolving a1");

            // Simulate async operation
            promise.complete("Data from Service 1");
        });

        return promise.future();
    }

    // Simulate fetching data from service 2
    private Future<String> fetchDataFromService2() {
        Promise<String> promise = Promise.promise();

      //  System.out.println("service 2 fetching data is executed by + "+ Thread.currentThread().getName());

        vertx.setTimer(5000, id -> {
            // Simulate async operation
           // System.out.println("reslolving s2");
            promise.fail("Data from Service 2");

        });

        return promise.future();
    }
}
