package api.infrastructure.web.handlers;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;


@RestController
@CrossOrigin(origins="*")
public class HealthHandler {
	
	@GetMapping("/health")
    public HashMap<String, String>  getMessage() {
        HashMap<String, String> map = new HashMap<>();
        map.put("status", "UP");
        return map;
    }
}


