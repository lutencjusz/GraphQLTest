package com.example.GrahgQLTest.controllers;

import com.example.GrahgQLTest.models.Car;
import com.example.GrahgQLTest.repositorys.CarRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CarController {

    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @SchemaMapping(typeName = "Query", field = "cars")
    List<Car> getCars() {
        return carRepository.findAll();
    }

    @QueryMapping
    Car carById(@Argument Long id) {
        return carRepository.findById(id).orElse(null);
    }

    @MutationMapping
    Car createCar(@Argument String model, @Argument String mark) {
        return carRepository.save(new Car(null, model, mark));
    }
}
