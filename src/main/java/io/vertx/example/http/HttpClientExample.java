package io.vertx.example.http;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpMethod;

public class HttpClientExample extends AbstractVerticle {
    @Override
    public void start() throws Exception {
        try {
            HttpClient client = vertx.createHttpClient();

            client.request(HttpMethod.GET, 8080, "localhost", "/").onComplete(result -> {
                if (result.succeeded()) {
                    System.out.println(result.result());
                } else {
                    System.out.println(result.cause());
                }
            });
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
