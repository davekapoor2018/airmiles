package com.example.airmiles.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class City {

    private String cityName;
    private String latitude;
    private String longitude;
    private String temp;

    public City(String cityName, String latitude, String longitude, String temp) {
        this.cityName = cityName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.temp = temp;
    }
}
