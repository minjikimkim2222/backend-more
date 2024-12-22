package demo.elasticsearch.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LionController {
    @GetMapping("/lions")
    public String lion(){
        return "lion edited !!";
    }
}
