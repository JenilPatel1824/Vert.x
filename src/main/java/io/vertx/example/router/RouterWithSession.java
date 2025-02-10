package io.vertx.example.router;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.Session;
import io.vertx.ext.web.handler.SessionHandler;
import io.vertx.ext.web.sstore.LocalSessionStore;
import io.vertx.ext.web.sstore.SessionStore;

public class RouterWithSession extends AbstractVerticle
{
    @Override
    public void start() throws Exception
    {
        Router router = Router.router(vertx);

        SessionStore store = LocalSessionStore.create(vertx);

        router.route().handler(SessionHandler.create(store));

        router.get("/login/:name/:pass").handler(routingContext ->
        {
            System.out.println("Got login request");

            Session session = routingContext.session();

            session.put("name", routingContext.request().getParam("name"));

            routingContext.request().response().setStatusCode(200).end(new JsonObject().put(routingContext.pathParam("name"), routingContext.queryParam("pass")).put("login","success").encodePrettily());

        });

        router.get("/profile").handler(routingContext ->{

           Session session = routingContext.session();

           String username = session.get("name");

           if(username != null)
           {
               routingContext.request().response().setStatusCode(200).end(new JsonObject().put("name", username).encodePrettily());
           }
           if (username==null)
           {
               routingContext.response().setStatusCode(404).end(new JsonObject().put("message", "User not found").encodePrettily());
           }
        });

        vertx.createHttpServer().requestHandler(router).listen(8080).onComplete(result ->{
            if (result.succeeded())
            {
                System.out.println("HTTP server started on port: "+result.result().actualPort());
            }
        });


    }
}
