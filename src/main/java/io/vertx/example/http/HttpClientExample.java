package io.vertx.example.http;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;

public class HttpClientExample extends AbstractVerticle {
    @Override
    public void start() throws Exception {

        System.out.println("http client "+Thread.currentThread().getName());
        System.out.println("Client started"); // Debug log

        HttpClient client = vertx.createHttpClient();

        vertx.setTimer(2000,id-> {


            client.request(HttpMethod.POST, 8080, "localhost", "/").onComplete(requestResult -> {
                if (requestResult.succeeded()) {
                    System.out.println("Request created successfully"); // Debug log

                    requestResult.result().send(new JsonObject().put("hello","123").encode()).onComplete(responseResult -> {
                        if (responseResult.succeeded()) {
                            System.out.println("status code: "+responseResult.result().statusCode());
                            responseResult.result().body().onComplete(bodyResult -> {
                                if (bodyResult.succeeded()) {
                                    System.out.println("Response received: " + bodyResult.result());
                                } else {
                                    System.err.println("Failed to read response body: " + bodyResult.cause());
                                }
                            });
                        } else {
                            System.err.println("Request failed: " + responseResult.cause());
                        }
                    });
                } else {
                    System.err.println("Failed to create request: " + requestResult.cause());
                }
            });
        });
    }
}
