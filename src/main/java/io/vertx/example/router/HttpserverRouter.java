package io.vertx.example.router;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.Cookie;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.SessionHandler;

import java.util.NoSuchElementException;

public class HttpserverRouter extends AbstractVerticle
{

    @Override
    public void start()
    {

        System.out.println("Httpserver "+Thread.currentThread().getName());
        Router router = Router.router(vertx);



//        router.get("/jsondata").handler(routingContext -> {
//           routingContext.response().setStatusCode(200).end(new JsonObject().put("message","json data route").encode());
//        });

        Router productRouter = Router.router(vertx);

        productRouter.get("/product/:id").handler(routingContext -> {
            routingContext.response().end(new JsonObject().put("id", routingContext.request().getParam("id")).encodePrettily());
            System.out.println("product : id called");
        });

        router.route("/product/*").subRouter(productRouter);

        productRouter.get("/sub").handler(routingContext -> {
            if(routingContext.request().getCookie("my-cookie") != null)
                System.out.println("cookie: "+routingContext.request().getCookie("my-cookie").getValue());
            else
                System.out.println("no cookie");

            routingContext.response().addCookie(Cookie.cookie("my-cookie", "my-cookie-value").setMaxAge(7 * 24 * 60 * 60));
            System.out.println("product : sub called");
            routingContext.response().end("sub");
        });

        router.get("/jsondata/:name/:age").handler(routingContext -> {
           //routingContext.response().setStatusCode(200).end(new JsonObject().put("message", "jsondata /name/age route").put("age",routingContext.pathParam("age")).put("name",routingContext.pathParam("name")).encodePrettily());

           routingContext.reroute("/reroute");
        });

        router.get("/reroute").handler(routingContext -> {
            System.out.println("reroute called");
            routingContext.response().setStatusCode(200).end(new JsonObject().put("reroute","re").encodePrettily());
        });

//        router.route().handler(routingContext -> {
//            routingContext.response().end("Hello World");
//        });

        vertx.createHttpServer().requestHandler(router).listen(8080).onComplete(res->
                {
                    if(res.succeeded())
                    {
                        System.out.println("HTTP server started on port 8080");
                    }
                }
        );
    }



}
