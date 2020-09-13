package com.xift.training.database.StationsDatabase.dto;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class StationDTO {
    private UUID stationId;
    private String name;
    private String city;
    private String status;

    public StationDTO(){}

    public StationDTO(UUID stationId, String name, String city, String status) {
        this.stationId = stationId;
        this.name = name;
        this.city = city;
        this.status = status;
    }

    public UUID getStationId() {
        return stationId;
    }

    public void setStationId(UUID stationId) {
        this.stationId = stationId;
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
