package api.infrastructure.web.handlers;

import org.springframework.web.bind.annotation.*;
import api.usecase.DeployRover;

@RestController
@CrossOrigin(origins="*")
public class DeployRoverController {
    @PostMapping("/deploy")
    public String deploy(@RequestBody String text) {
        DeployRover deployRover = new DeployRover();
        return deployRover.deploy(text);
    }
}
