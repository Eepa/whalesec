package fi.lands.whaleback.controller;

import fi.lands.whaleback.dto.GreetingDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class WhaleController {

    @GetMapping("/")
    public String helloWhales() {
        return "Hello whales!";
    }

    @PostMapping("/greeting")
    public String postGreeting(@RequestBody GreetingDto greeting) {
        return greeting.getGreeting();
    }
}
