package com.darkmode.cars.service;

import com.darkmode.cars.dto.CarDTO;
import com.darkmode.cars.dto.CarsDTO;
import com.darkmode.cars.dto.DarkModeDTO;
import com.darkmode.cars.model.Car;
import com.darkmode.cars.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    public CarsDTO showDarkModeCars(Boolean darkMode){
        List<Car> cars = carRepository.findAll();
        List<CarDTO> carDTOs = new ArrayList<>();

        for (Car car : cars) {
            CarDTO carDTO = new CarDTO();
            carDTO.setName(car.getName());
            carDTO.setModel(car.getModel());
            carDTOs.add(carDTO);
        }
        CarsDTO carsDTO = new CarsDTO(darkMode, carDTOs);

        return carsDTO;
    }


}
