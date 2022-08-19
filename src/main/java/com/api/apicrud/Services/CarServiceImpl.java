package com.api.apicrud.Services;

import com.api.apicrud.Entities.CarEntity;
import org.springframework.beans.factory.annotation.Autowired;
import com.api.apicrud.Repositories.CarRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    
    @Autowired
    CarRepository carRepository;

    @Override
    public CarEntity addCar(CarEntity param){
        
        return carRepository.save(param);
    }

    @Override
    public List<CarEntity> getAllCar(){
        return carRepository.findAll();
    }

    @Override
    public CarEntity getCarById(int id){
        return carRepository.findById(id).get();
    }

    @Override
    public CarEntity updateCar(CarEntity param){
        return carRepository.save(param);
    }

    @Override
    public void deleteCar(int id){

    }
}
