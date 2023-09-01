package com.darkmode.cars.dto;

import com.darkmode.cars.model.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarsDTO {
    private boolean darkMode;
    private List<CarDTO> cars;

}
