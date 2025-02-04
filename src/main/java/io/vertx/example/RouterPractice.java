package io.vertx.example;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.MultiMap;
import io.vertx.core.Promise;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;

public class RouterPractice extends AbstractVerticle {
    @Override
    public void start(Promise<Void> startPromise)
    {


        vertx.deployVerticle("io.vertx.example.vertxcore");

        vertx.deployVerticle("io.vertx.example.eventbus.TestEventBusvertical");



        Router router = Router.router(vertx);

        router.route().handler(ctx -> {
            String address = ctx.request().connection().remoteAddress().toString();

            MultiMap queryParams = ctx.queryParams();

            String name = queryParams.contains("name")?queryParams.get("name"):"unknown";

            ctx.json(new JsonObject().put("name", name).put("address", address).put("message", "Hello " + name + " connected from " + address));

        });

        router.get("/api/v1/hello").handler(ctx->{
            ctx.request().response().end("Hello from api v1 hello");
        });

        router.get("/api/v1/hello/:name").handler(ctx->{

            String name = ctx.pathParam("name");
            ctx.request().response().end("Hello from api v1 hello "+name);
        });


        vertx.createHttpServer().requestHandler(router).listen(8080).onSuccess(server->
        {
            System.out.println("HTTP server started on port "+server.actualPort());
        });
    }

}
