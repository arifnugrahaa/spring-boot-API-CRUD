package com.api.apicrud.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.apicrud.Entities.CarEntity;
import com.api.apicrud.Repositories.CarRepository;

@RestController
@RequestMapping( value = "/car")
public class CarController {
    

    @Autowired
    CarRepository carRepository;

    @GetMapping(value = "checkAPI")
    public String checkAPI(){
        return "Hello World";
    }

    @PostMapping(value = "addNewCar")
    public CarEntity addNewCar(@RequestBody CarEntity param){
        carRepository.save(param);
        return param;
    }
}
