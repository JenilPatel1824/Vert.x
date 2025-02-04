package io.vertx.example.future;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Promise;

public class FuturePromise extends AbstractVerticle {
    @Override
    public void start() {
        // Simulating a user query to a database
        String userId = "12345";

        // Start the simulated database query
        Future<String> userFuture = getUserDetails(userId);

        // Handle the result (success or failure)
        userFuture.onComplete(userDetails -> {
            System.out.println("User details fetched: " + userDetails.result());
        }).onFailure(err -> {
            System.out.println("Failed to fetch user details: " + err.getMessage());
        });
    }

    // Simulate a database query using Future and Promise
    private Future<String> getUserDetails(String userId) {
        // Create a Promise, which will eventually be completed with the user data
        Promise<String> promise = Promise.promise();

        // Simulate a delay (asynchronous operation)
        vertx.setTimer(1000, id -> {
            // After 1 second, we "fetch" user data (or simulate failure)
            if (userId.equals("12345")) {
                promise.complete("User [ID: " + userId + ", Name: John Doe, Age: 30]");
            } else {
                promise.fail("User not found");
            }
        });

        // Return the Future to allow the caller to handle success or failure
        return promise.future();
    }

}

