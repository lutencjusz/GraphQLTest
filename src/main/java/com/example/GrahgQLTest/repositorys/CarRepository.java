package com.example.GrahgQLTest.repositorys;

import com.example.GrahgQLTest.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
