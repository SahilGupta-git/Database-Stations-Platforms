package com.xift.training.database.StationsDatabase.dto;

import org.springframework.stereotype.Component;
@Component
public class StationByNameDTO {
    private String name;
    private String city;
    private String status;

    public StationByNameDTO(){}

    public StationByNameDTO(String name, String city, String status) {
        this.name = name;
        this.city = city;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
