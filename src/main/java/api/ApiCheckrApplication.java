package api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import api.usecase.Rover;

@SpringBootApplication
public class ApiCheckrApplication {

	public static void main(String[] args) {
		
		Rover rover = new Rover();
		rover.setPosition(1, 2, 'W');
		rover.getPosition().print();
		
		//SpringApplication.run(ApiCheckrApplication.class, args);
	}

}
