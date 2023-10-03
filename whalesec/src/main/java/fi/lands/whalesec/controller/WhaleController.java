package fi.lands.whalesec.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import fi.lands.whalesec.configuration.LocalProperties;
import fi.lands.whalesec.dto.WhaleSoundDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class WhaleController {

    private final Map<String, String> whales;

    private final List<String> whaleSounds;
    private final LocalProperties localProperties;

    public WhaleController(LocalProperties localProperties) {
        this.localProperties = localProperties;
        this.whales = Map.of("1", "Miekkavalas", "2", "Sinivalas",
            "3", "Ryhävalas", "4", "Maitovalas");
        this.whaleSounds = new ArrayList<>();
    }

    @GetMapping("/whale")
    public String whalePage() {
        return "whale.html";
    }

    @GetMapping("/whalesounds")
    public String whaleSoundsPage() {
        return "whale_sounds.html";
    }

    @GetMapping("/whalecat")
    public String whaleCatPage() {
        return "whale_cat.html";
    }

    @GetMapping("/whales/{id}")
    public ResponseEntity<String> getWhale(@PathVariable String id) {

        if (id == null || !whales.containsKey(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(whales.get(id), HttpStatus.OK);
    }

    // http://whaleback.test.local/whales/lowercase/2%0d%0aSet-Cookie%3Asessiontoken%3D123ABC
    // Tomcat saves us from HTTP Response Splitting
    // It is not a good practice to use user input directly in constructing the redirection path
    @GetMapping("/whales/lowercase/{id}")
    public String getWhaleRedirect(@PathVariable String id) {
        String path = "/whales/" + id;
        String redirectUrl = "http://" + localProperties.getDomain();
        return "redirect:" + redirectUrl + path;
    }

    @PostMapping("/whales/sounds")
    public ResponseEntity<List<String>> addWhaleSound(@RequestBody WhaleSoundDto whaleSoundDto) {
        this.whaleSounds.add(whaleSoundDto.getSound());
        return new ResponseEntity<>(this.whaleSounds, HttpStatus.OK);
    }

    @GetMapping("/whales/sounds")
    public ResponseEntity<List<String>> getWhaleSounds() {
        return new ResponseEntity<>(this.whaleSounds, HttpStatus.OK);
    }


}
