package api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import api.usecase.Position;
import api.usecase.Rover;

@SpringBootApplication
public class ApiCheckrApplication {

	public static void main(String[] args) {

//		try {
//			Position position = new Position(1, 2, 'N');
//			Rover rover = new Rover(position);
//			rover.exec("LMLMLMLMM");
//			rover.getPosition().print();
//
//			Position position2 = new Position(3, 3, 'E');
//			Rover rover2 = new Rover(position2);
//			rover2.exec("MMRMMRMRRM");
//			rover2.getPosition().print();
//		}
//		catch (Exception e) {
//			System.out.println("Error creating rover");
//		}
		SpringApplication.run(ApiCheckrApplication.class, args);
	}

}
