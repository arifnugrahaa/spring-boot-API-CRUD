package com.api.apicrud.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.apicrud.Entities.CarImage;

public interface CarImageRepository extends JpaRepository<CarImage, Integer> {
    
}
