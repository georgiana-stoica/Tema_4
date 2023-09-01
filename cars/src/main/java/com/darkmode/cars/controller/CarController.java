package com.darkmode.cars.controller;

import com.darkmode.cars.dto.CarsDTO;
import com.darkmode.cars.dto.DarkModeDTO;
import com.darkmode.cars.service.CarService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;
    @GetMapping("/cars")
    public CarsDTO showDarkModeCars(@CookieValue(name = "darkmode", defaultValue = "false") boolean darkMode){
        return carService.showDarkModeCars(darkMode);
    }

    @PutMapping("/dark-mode")
    public ResponseEntity<DarkModeDTO> setDarkMode(@RequestBody DarkModeDTO darkModeDTO){
        ResponseCookie cookie = ResponseCookie.from("darkmode", String.valueOf(darkModeDTO.isDarkMode()))
                .path("/")
                .build();

        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(darkModeDTO);
    }
}

