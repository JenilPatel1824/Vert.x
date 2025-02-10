package io.vertx.example.tcpserver;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.net.NetClient;
import io.vertx.core.net.NetSocket;

import java.util.Scanner;

public class TcpClient extends AbstractVerticle {
    @Override
    public void start() throws Exception {
        NetClient client = vertx.createNetClient();
        client.connect(8080, "localhost", ar -> {
            if (ar.succeeded()) {
                NetSocket socket = ar.result();

                socket.write("hello from client req:");
                socket.sendFile("/home/jenil/Documents/Vertx/src/main/resources/my_file.txt");
                socket.handler(buff -> {
                    System.out.println(buff.toString());
                });
            }
        });
    }
}
