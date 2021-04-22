package api.infrastructure.web.handlers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@CrossOrigin(origins="*")
public class DeployRoverController {

    @GetMapping("/deploy")
    public HashMap<String, String> deploy() {
        HashMap<String, String> map = new HashMap<>();






        return map;
    }
}
