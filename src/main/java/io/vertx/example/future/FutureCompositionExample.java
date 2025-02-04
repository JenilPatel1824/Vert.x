package io.vertx.example.future;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Promise;

public class FutureCompositionExample extends AbstractVerticle {

    @Override
    public void start() {
        // Start the chain of futures
        fetchDataFromDatabase()
                .compose(data -> {
                    // Process the data once fetched
                    return processData(data);
                })
                .compose(processedData -> {
                    // Save the processed data
                    return saveToDatabase(processedData);
                })
                .onSuccess(result -> {
                    // Success callback
                    System.out.println("Data processed and saved successfully.");
                })
                .onFailure(err -> {
                    // Failure callback
                    System.out.println("Error: " + err.getMessage());
                });
    }

    // Simulate fetching data from a database
    private Future<String> fetchDataFromDatabase() {
        Promise<String> promise = Promise.promise();

        // Simulate an async operation (e.g., DB call)
        vertx.setTimer(1000, id -> {
            // Simulating successful fetch operation
            promise.complete("Fetched data from DB");
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        });

        return promise.future();
    }

    // Simulate processing the data
    private Future<String> processData(String data) {
        Promise<String> promise = Promise.promise();

        // Simulate an async operation (e.g., data transformation)
        vertx.setTimer(1000, id -> {
            // Simulate processing the data
            promise.complete(data + " processed");
        });

        return promise.future();
    }

    // Simulate saving the processed data to the database
    private Future<Void> saveToDatabase(String data) {
        Promise<Void> promise = Promise.promise();

        // Simulate an async operation (e.g., saving data to DB)
        vertx.setTimer(1000, id -> {
            // Simulate successful save operation
            System.out.println(data);
            promise.complete();
        });

        return promise.future();
    }
}
