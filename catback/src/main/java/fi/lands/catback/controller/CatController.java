package fi.lands.catback.controller;

import java.util.Map;
import fi.lands.catback.configuration.LocalProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class CatController {

    private final Map<String, String> cats;

    private final LocalProperties localProperties;

    public CatController(LocalProperties localProperties) {
        this.localProperties = localProperties;
        this.cats = Map.of("1", "Kotikissa", "2", "Egyptinmau",
            "3", "Siperiankissa", "4", "Pyhä Birma");
    }


    @GetMapping("/cat")
    public String catPage() {
        return "cat.html";
    }

    @GetMapping("/cats/{id}")
    public ResponseEntity<String> getWhale(@PathVariable String id) {

        if (id == null || !cats.containsKey(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(cats.get(id), HttpStatus.OK);
    }

    // http://whaleback.test.local/cats/lowercase/2%0d%0aSet-Cookie%3Asessiontoken%3D123ABC
    // Tomcat saves us from HTTP Response Splitting
    // It is not a good practice to use user input directly in constructing the redirection path
    @GetMapping("/cats/lowercase/{id}")
    public String getWhaleRedirect(@PathVariable String id) {
        String path = "/cats/" + id;
        String redirectUrl = "http://" + localProperties.getDomain();
        return "redirect:" + redirectUrl + path;
    }


}
