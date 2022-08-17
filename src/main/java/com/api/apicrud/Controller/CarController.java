package com.api.apicrud.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.apicrud.Entities.CarEntity;
import com.api.apicrud.Repositories.CarRepository;
import com.api.apicrud.Response.CommonResponse;
import com.api.apicrud.Response.CommonResponseGenerator;

@RestController
@RequestMapping( value = "/car")
public class CarController {
    

    @Autowired
    CarRepository carRepository;


    @Autowired
    CommonResponseGenerator commonResponseGenerator;

    @GetMapping(value = "checkAPI")
    public CommonResponse <String> checkAPI(){
        return commonResponseGenerator.successResponse("Hello World", "Success check API");
    }

    @PostMapping(value = "addNewCar")
    public CommonResponse <CarEntity> addNewCar(@RequestBody CarEntity param){
        carRepository.save(param);
        return commonResponseGenerator.successResponse(param, "Success Add New Car");
    }

    @GetMapping(value = "getAllCar")
    public CommonResponse <List<CarEntity>> getAllCar(){
        return commonResponseGenerator.successResponse(carRepository.findAll(), "Success get all data");
    }

    @GetMapping(value = "getById")
    public CommonResponse <CarEntity> getById(@RequestParam int id){
        return commonResponseGenerator.successResponse(carRepository.findById(id).get(), "Success get by id: "+id);
    }

    @PostMapping(value = "updateCar")
    public CommonResponse <CarEntity> updateCar(@RequestBody CarEntity param){
        return commonResponseGenerator.successResponse(carRepository.save(param), "Success update data id: "+param.getId());
    }

    @GetMapping(value = "deleteCar")
    public CommonResponse <List <CarEntity>> deleteCar(@RequestParam int id){
        carRepository.deleteById(id);
        List<CarEntity> carList = carRepository.findAll();
        return commonResponseGenerator.successResponse(carList, "Success delete car by id: "+id);
    }
}
