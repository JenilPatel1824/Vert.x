package io.vertx.example.tcpserver;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.net.NetServer;
import io.vertx.core.net.NetServerOptions;

import java.io.FileNotFoundException;

public class TcpServer extends AbstractVerticle {
    @Override
    public void start() throws Exception {

        NetServer server = vertx.createNetServer(new NetServerOptions().setLogActivity(true));

        server.connectHandler(socket -> {
            System.out.println("client connected"+socket.remoteAddress());
            socket.handler(buffer -> {
                System.out.println("recived by server "+buffer.toString());
                socket.write("response from server");
            });
            });
            System.out.println("Starting server");
            server.listen(8080).onComplete(result -> {
                if (result.succeeded()) {
                    System.out.println("Server started on port " + result.result().actualPort());
                } else {
                    System.out.println("Error: " + result.cause());
                }
            });




    }
}
