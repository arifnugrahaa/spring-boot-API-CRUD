package com.api.apicrud.Services;

import com.api.apicrud.Entities.CarEntity;
import org.springframework.stereotype.Component;
import java.util.List;
import com.api.apicrud.Entities.CarImage;
import com.api.apicrud.Wrappers.CarImageWrapper;

@Component
public interface CarService {

    CarEntity addCar(CarEntity param);

    List<CarEntity> getAllCar();

    CarEntity getCarById(int id);

    CarEntity updateCar(CarEntity param);

    void deleteCar(int id);

    CarImage upload(CarImageWrapper carImageWrapper);
}
