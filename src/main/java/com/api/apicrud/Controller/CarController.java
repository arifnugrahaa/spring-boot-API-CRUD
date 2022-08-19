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
import com.api.apicrud.Services.CarService;

@RestController
@RequestMapping( value = "/car")
public class CarController {
    

    @Autowired
    CarRepository carRepository;


    @Autowired
    CommonResponseGenerator commonResponseGenerator;

    @Autowired
    CarService carService;

    @GetMapping(value = "checkAPI")
    public CommonResponse <String> checkAPI(){
        return commonResponseGenerator.successResponse("Hello World", "Success check API");
    }

    @PostMapping(value = "addNewCar")
    public CommonResponse <CarEntity> addNewCar(@RequestBody CarEntity param){
         
        try {
            CarEntity car = carService.addCar(param);
            return commonResponseGenerator.successResponse(car, "Success Add New Car");
        } catch (Exception e) {
            //TODO: handle exception
            return commonResponseGenerator.failedResponse(e.getMessage());
        }

    }

    @GetMapping(value = "getAllCar")
    public CommonResponse <List<CarEntity>> getAllCar(){

        try {
            List<CarEntity> carList = carService.getAllCar();
            return commonResponseGenerator.successResponse(carList, "Success get all data");
        } catch (Exception e) {
            //TODO: handle exception
            return commonResponseGenerator.failedResponse(e.getMessage());
        }
        
    }

    @GetMapping(value = "getById")
    public CommonResponse <CarEntity> getById(@RequestParam int id){
        try {
            CarEntity car = carService.getCarById(id);
            return commonResponseGenerator.successResponse(car, "Success get by id: "+id);
        } catch (Exception e) {
            //TODO: handle exception
            return commonResponseGenerator.failedResponse(e.getMessage());
        }
    }

    @PostMapping(value = "updateCar")
    public CommonResponse <CarEntity> updateCar(@RequestBody CarEntity param){
        try {
            CarEntity car = carService.updateCar(param);
            return commonResponseGenerator.successResponse(car, "Success update data id: "+param.getId());
        } catch (Exception e) {
            //TODO: handle exception
            return commonResponseGenerator.failedResponse(e.getMessage()+" for id: "+param.getId());
        }
    }

    @GetMapping(value = "deleteCar")
    public CommonResponse <List <CarEntity>> deleteCar(@RequestParam int id){
        try {
            carService.deleteCar(id);
            List<CarEntity> carList = carService.getAllCar();
            return commonResponseGenerator.successResponse(carList, "Success delete car by id: "+id);
        } catch (Exception e) {
            //TODO: handle exception
            return commonResponseGenerator.failedResponse(e.getMessage());
        }
    }
}
