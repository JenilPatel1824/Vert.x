package io.vertx.example;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

import java.util.concurrent.atomic.AtomicReference;

public class AuthenticationAndAuthorization extends AbstractVerticle {


    @Override
    public void start() throws Exception {
        Router router = Router.router(vertx);
        System.out.println(Thread.currentThread().getName()+" started");

//        JWTAuth jwtAuth = JWTAuth
    }

@Override
public void stop()
{
    System.out.println(Thread.currentThread().getName()+ " Stopping");
}

    public static void main(String[] args) throws InterruptedException {

        AtomicReference<String> depid=new AtomicReference<>();
        Vertx vertx = Vertx.vertx();
         vertx.deployVerticle(new AuthenticationAndAuthorization()).onComplete(result -> {
            if (result.succeeded()) {
                depid.set(result.result());
                System.out.println("Vert.x deployed");
            }
            else {
                depid.set(null);
                System.out.println("Vert.x failed to deploy");
            }
        });

         Thread.sleep(2000);

        vertx.undeploy(depid.get());

    }
}
