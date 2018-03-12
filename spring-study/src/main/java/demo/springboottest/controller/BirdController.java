package demo.springboottest.controller;

import demo.springboottest.Bird;
import demo.springboottest.service.Ibird;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/bird")
public class BirdController {

    @Autowired
    private Ibird ibird;

    @GetMapping(value = "/run")
    public String run() {
        return ibird.run();
    }

    @PostMapping(value = "/hello")
    public String sayHello() {
        return ibird.sayhello();
    }

    @GetMapping(value = "/runparam")
    public String runwithparam(@RequestParam(value = "param") String param) {
        System.out.println("param is :" + param);
        return ibird.run();
    }

    @PostMapping(value = "/helloparam")
    public String sayHellowithparam(@RequestBody Bird bird) {

        System.out.println("param is : " + bird);
        return ibird.sayhello();
    }
}
