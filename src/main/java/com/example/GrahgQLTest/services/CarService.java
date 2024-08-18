package com.example.GrahgQLTest.services;

import com.example.GrahgQLTest.models.Car;
import com.example.GrahgQLTest.repositorys.CarRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @PostConstruct
    public void LoadData(){
        carRepository.save(new Car(1L, "Audi", "A4"));
        carRepository.save(new Car(2L, "BMW", "X5"));
        carRepository.save(new Car(3L, "Mercedes", "E220"));
    }
}
