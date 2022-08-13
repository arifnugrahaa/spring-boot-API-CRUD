package com.api.apicrud.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( value = "/car")
public class CarController {
    
    @GetMapping(value = "checkAPI")
    public String checkAPI(){
        return "Hello World";
    }
}
