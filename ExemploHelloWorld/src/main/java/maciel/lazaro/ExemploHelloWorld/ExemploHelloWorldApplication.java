package maciel.lazaro.ExemploHelloWorld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExemploHelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExemploHelloWorldApplication.class, args);
		System.out.println("Hello World!");
	}

}
