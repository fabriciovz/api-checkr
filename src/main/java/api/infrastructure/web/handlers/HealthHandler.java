package api.infrastructure.web.handlers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping(path="/api",produces="application/json")
@CrossOrigin(origins="*")
public class HealthHandler {
	
	/*	@PostMapping(value = "/move")
	public void create(@RequestBody RoberPosition item) {  //ResponseEntity<?>

		//return service.create(item).getResponse();	
	}*/

}


