package senior.godev.sonora.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World";
    }
}
