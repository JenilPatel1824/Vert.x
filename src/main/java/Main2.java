import io.netty.channel.socket.ChannelInputShutdownEvent;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;


class v extends AbstractVerticle
{
    @Override
    public void start()
    {
        System.out.println("Hello World");
    }
}
public class Main2
{
    public static Vertx vertx = Vertx.vertx();



    public static void main(String[] args)
    {

        EventBus eb = vertx.eventBus();
        HashSet set = new HashSet();
        set.add("hello");
        set.add("world");
        set.add(1);

        ArrayList list = new ArrayList(set);


//        eb.consumer("test",result->{
//            System.out.println(result.body());
//        });
//        System.out.println(set);
        //eb.send("test","set");

        JsonObject config = new JsonObject();
       // config.put("host", "localhost");
        config.put("set",list);

       // System.out.println(config.getValue("set"));
        System.out.println(config);


        //eb.send("test", new JsonObject().put("set",set));


        //vertx.deployVerticle(new v(),new DeploymentOptions().setInstances(3));

//        try {
//            try {
//                int arr[] = new int[0];
//                System.out.println(arr[0]);
//            } catch (Exception e) {
//                throw new IOException();
//            }
//        }
//        catch (Exception e) {
//            System.out.println("error");
//        }



    }
}
