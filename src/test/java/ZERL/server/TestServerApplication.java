package ZERL.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestServerApplication {

	public static void main(String[] args) {
		SpringApplication.from(ServerApplication::main).with(TestServerApplication.class).run(args);
	}

}
