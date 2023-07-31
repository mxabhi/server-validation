package com.example.servervalidationbackend;

import com.example.model.Server;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.POST})
public class ServerController {
    private final ServerValidationService validationService;

    public ServerController(ServerValidationService validationService) {
        this.validationService = validationService;
    }

    @PostMapping("/validate-servers")
    public List<Server> validateServers(@RequestBody List<Server> servers) {
        validationService.validateServers(servers);
        return servers;
    }

    @PostMapping("/validate-servers-parallel")
    public List<Server> validateServersInParallel(@RequestBody List<Server> servers) throws InterruptedException {
        validationService.validateServersInParallel(servers);
        return servers;
    }
}
