package com.xift.training.database.StationsDatabase.controller;

import com.xift.training.database.StationsDatabase.dto.StationByCityDTO;
import com.xift.training.database.StationsDatabase.dto.StationByNameDTO;
import com.xift.training.database.StationsDatabase.dto.StationDTO;
import com.xift.training.database.StationsDatabase.models.Station;
import com.xift.training.database.StationsDatabase.service.StationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class StationController {

    private final StationService stationService;

    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    @GetMapping("/stations")
    public List<Station> getAllStations() {
        return stationService.getAllStations();
    }

    @GetMapping("/stations/{id}")
    public Station getStationById(@PathVariable(name = "id") UUID stationId){
        return stationService.getStationById(stationId);
    }

    @GetMapping("/stationsName/{name}")
    public Station getStationByNameDTO(@PathVariable(name = "name") String name){
        return stationService.getStationByNameDTO(name);
    }

    @GetMapping("/stationsCity/{city}")
    public Station getStationByCityDTO(@PathVariable(name = "city") String city){
        return stationService.getStationByCityDTO(city);
    }

    @PostMapping("/station")
    public Station addStation(@RequestBody Station station){
        return stationService.addStation(station);
    }

    @PutMapping("/stationsUp/{id}")
    public Station updateStation(@RequestBody StationDTO stationDTO, @PathVariable(name = "id") UUID stationId){
        return stationService.updateStation(stationId, stationDTO);
    }

    @DeleteMapping("/stationsDel/{id}")
    public void deleteStation(@PathVariable(name = "id") UUID stationId){
        stationService.deleteStation(stationId);
    }

}
