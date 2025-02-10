package io.vertx.example.http;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.util.*;

public class HttpServerExample extends AbstractVerticle {

    @Override
    public void start() throws Exception {
        HttpServer server = vertx.createHttpServer(new HttpServerOptions().setLogActivity(true));
        server.requestHandler(req -> {

//            if (req.method() == HttpMethod.POST) {
//                req.bodyHandler(body -> {
//                    JsonObject json = new JsonObject(body);
//                    System.out.println("req body: "+json);
//                    req.response().setStatusCode(200).end(json.put("server","recived").encode());
//                });
//            }




            Map<String, Object> map = new HashMap<>();
            map.put("id", 101);
            map.put("name", "Jenil");

            Set<String> set = new HashSet<>(Arrays.asList("apple", "banana", "cherry"));

            List<Integer> list = Arrays.asList(10, 20, 30, 40);

            JsonObject json = new JsonObject()
                    .put("map", new JsonObject(map))   // Convert Map to JsonObject
                    .put("set", new JsonArray(new ArrayList<>(set))) // Convert Set to JsonArray
                    .put("list", new JsonArray(list)); // Convert List to JsonArray


            System.out.println(json.encodePrettily());
            System.out.println(req.path()+req.query()+req.method()+req.params());
            req.response().setStatusCode(201).end(json.encodePrettily());
        });
        server.listen(8080,"localhost").onComplete(result -> {
            if (result.succeeded()) {
                System.out.println("HTTP server started on port 8080");
            }
        });


    }

}
