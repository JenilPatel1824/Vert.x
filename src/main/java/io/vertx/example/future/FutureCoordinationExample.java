package io.vertx.example.future;

import io.vertx.core.*;

public class FutureCoordinationExample extends AbstractVerticle {

    @Override
    public void start() throws InterruptedException {

        Context ctx = vertx.getOrCreateContext();
        System.out.println(context.isWorkerContext());
        // Start the two independent async tasks
        Future<String> service1Data = fetchDataFromService1();
        Future<String> service2Data = fetchDataFromService2();

        // Combine the results of both tasks
        CompositeFuture.all(service1Data, service2Data)
                .onSuccess(composite -> {
                    // Once both tasks are complete, process the results
                    String result1 = composite.resultAt(0);
                    String result2 = composite.resultAt(1);

                    System.out.println("Service 1 Data: " + result1);
                    System.out.println("Service 2 Data: " + result2);

                    // Further processing with both results
                    System.out.println("Both services have completed, processing combined results.");
                })
                .onFailure(err -> {
                    // Handle failure (if any of the tasks fail)
                    System.out.println("An error occurred: " + err.getMessage());
                });

        Future.join(service1Data, service2Data).onSuccess(result -> {
            System.out.println("Service 1 Data: " + service1Data.result());
            System.out.println("Service 2 Data: " + service2Data.result());
        });
    }

    // Simulate fetching data from service 1
    private Future<String> fetchDataFromService1() throws InterruptedException {
        Promise<String> promise = Promise.promise();

        System.out.println("service 1 fetching data is executed by + "+ Thread.currentThread().getName());

        vertx.setTimer(1000, id -> {

            // Simulate async operation
            promise.complete("Data from Service 1");
        });

        return promise.future();
    }

    // Simulate fetching data from service 2
    private Future<String> fetchDataFromService2() {
        Promise<String> promise = Promise.promise();

        vertx.setTimer(2500, id -> {
            // Simulate async operation
            promise.complete("Data from Service 2");
        });

        return promise.future();
    }
}
