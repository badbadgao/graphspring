package application;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting1")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting("Hi", "wei");
    }
}
