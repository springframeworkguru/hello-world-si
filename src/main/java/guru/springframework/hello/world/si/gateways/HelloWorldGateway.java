package guru.springframework.hello.world.si.gateways;

import org.springframework.integration.annotation.Gateway;

import java.util.concurrent.Future;

public interface HelloWorldGateway {
    @Gateway(requestChannel = "say.hello.channel")
    void sayHello(String name);

    @Gateway(requestChannel = "get.hello.channel")
    String getHelloMessage(String name);

    @Gateway(requestChannel = "get.hello.channel")
    Future<String> getHelloMessageAsync(String name);
}
