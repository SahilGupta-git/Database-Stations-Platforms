package com.xift.training.database.StationsDatabase.service.implement;

import com.xift.training.database.StationsDatabase.dto.StationDTO;
import com.xift.training.database.StationsDatabase.models.Station;

import java.util.List;
import java.util.UUID;

public interface StationImpl {
    public List<Station> getAllStations();
    public Station getStationById(UUID stationId);
    public Station getStationByNameDTO(String name);
    public Station getStationByCityDTO(String city);
    public Station addStation(Station station);
    public Station updateStation(UUID stationId, StationDTO stationDTO);
    public void deleteStation(UUID stationId);

}
