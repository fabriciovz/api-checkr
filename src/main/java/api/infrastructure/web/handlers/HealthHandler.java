package api.infrastructure.web.handlers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


//import org.springframework.web.bind.annotation.PostMapping;


//@Controller
@RestController
//@RequestMapping(path="/api",produces="application/json")
@CrossOrigin(origins="*")
public class HealthHandler {
	
	@GetMapping("/health")
    public String getMessage() {
        return "A brand new product";
    }
//	@PostMapping(value = "/move")
//	public void create(@RequestBody RoberPosition item) {  //ResponseEntity<?>
//
//		//return service.create(item).getResponse();
//	}

}


