package com.api.apicrud.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.apicrud.Entities.CarEntity;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Integer> {
    
}
