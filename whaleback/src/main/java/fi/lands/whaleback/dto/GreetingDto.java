package fi.lands.whaleback.dto;

public class GreetingDto {

    private String greeting;

    public GreetingDto() {
    }

    public GreetingDto(String greeting) {
        this.greeting = greeting;
    }

    public String getGreeting() {
        return greeting;
    }
}
