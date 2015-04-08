package guru.springframework.hello.world.si;

import guru.springframework.hello.world.si.gateways.HelloWorldGateway;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HelloWorldSiApplication.class)
public class HelloWorldSiApplicationTests {

	@Autowired
	HelloWorldGateway helloWorldGateway;

	@Test
	public void sayHelloTest() {
		helloWorldGateway.sayHello("John");
	}

	@Test
	public void getHelloMessageTest(){
		String message = helloWorldGateway.getHelloMessage("John (get message)");
		System.out.println(message);
	}

	@Test
	public void getHelloAsycTest() throws ExecutionException, InterruptedException {
		Future<String> helloFuture = helloWorldGateway.getHelloMessageAsync("John (Woot, Asyc)");
		String message = helloFuture.get();
		System.out.println(message);
	}

}
