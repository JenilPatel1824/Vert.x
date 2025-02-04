package io.vertx.example.http;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.json.JsonObject;

public class HttpServerExample extends AbstractVerticle {

    @Override
    public void start() throws Exception {
        HttpServer server = vertx.createHttpServer(new HttpServerOptions().setLogActivity(true));
        server.requestHandler(req -> {
            req.uploadHandler(upload -> {
                upload.handler(buff -> {
                    System.out.println(buff.toString());
                });
            });
            System.out.println(req.path()+req.query()+req.method()+req.params());
            req.response().end(new JsonObject().put("hello","world").encode());
        });
        server.listen(8080,"localhost").onComplete(result -> {
            if (result.succeeded()) {
                System.out.println("HTTP server started on port 8080");
            }
        });

    }

}
