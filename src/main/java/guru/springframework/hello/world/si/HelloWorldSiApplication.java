package guru.springframework.hello.world.si;

import guru.springframework.hello.world.si.gateways.HelloWorldGateway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@SpringBootApplication
@ImportResource("classpath*:/spring/si-config.xml")
public class HelloWorldSiApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(HelloWorldSiApplication.class, args);
        HelloWorldGateway gateway = (HelloWorldGateway) ctx.getBean("helloWorldGateway");
        gateway.sayHello("John");

        String message = gateway.getHelloMessage("John (get message)");
        System.out.println(message);

        Future<String> helloFuture = gateway.getHelloMessageAsync("John (Async!)");

        try {
            String helloFutureMsg = helloFuture.get();
            System.out.println(helloFutureMsg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
