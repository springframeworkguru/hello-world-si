package guru.springframework.hello.world.si.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public void sayHello(String name) {
        System.out.println("Hello " + name + "!!");
    }

    public String getHelloMessage(String name){
        return ("Hello " + name + "!!");
    }
}
