package xyz.llluper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("xyz.llluper")
public class NotetakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotetakerApplication.class, args);
	}
}
