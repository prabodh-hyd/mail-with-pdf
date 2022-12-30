package in.prabodh.testMail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"in.prabodh"})
public class TestMailApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestMailApplication.class, args);
	}

}
