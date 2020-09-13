package com.xift.training.database.StationsDatabase.dto;

import org.springframework.stereotype.Component;

import java.util.UUID;


public class PlatformDTO {
    private String statusUpdate;

    public PlatformDTO(){}

    public PlatformDTO(String statusUpdate) {
        this.statusUpdate = statusUpdate;
    }

    public String getStatusUpdate() {
        return statusUpdate;
    }

    public void setStatusUpdate(String statusUpdate) {
        this.statusUpdate = statusUpdate;
    }
}
