package com.xift.training.database.StationsDatabase.service;

import com.xift.training.database.StationsDatabase.dao.StationRepository;
import com.xift.training.database.StationsDatabase.dto.StationByCityDTO;
import com.xift.training.database.StationsDatabase.dto.StationByNameDTO;
import com.xift.training.database.StationsDatabase.dto.StationDTO;
import com.xift.training.database.StationsDatabase.models.Station;
import com.xift.training.database.StationsDatabase.service.implement.StationImpl;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

import static java.util.logging.Logger.GLOBAL_LOGGER_NAME;

@Service
public class StationService implements StationImpl {

    private final StationRepository stationRepository;
    public final StationByNameDTO stationByNameDTO;
    public final StationByCityDTO stationByCityDTO;

    public StationService(StationRepository stationRepository, StationByNameDTO stationByNameDTO, StationByCityDTO stationByCityDTO) {
        this.stationRepository = stationRepository;
        this.stationByNameDTO = stationByNameDTO;
        this.stationByCityDTO = stationByCityDTO;
    }

    public List<Station> getAllStations(){
        List<Station> stations = new ArrayList<>();
        return (List<Station>) stationRepository.findAll();
    }

    public Station getStationById(UUID stationId) throws ResourceNotFoundException{
        Optional<Station> optionalStation = stationRepository.findById(stationId);
        try {
            if(optionalStation.isPresent()){
                 optionalStation.get();
            }else { throw new ResourceNotFoundException("Station not present");}
        } catch (NullPointerException e){
            System.out.println("NullPointer Exception Caught");
        } return optionalStation.get();
    }


    public Station getStationByNameDTO(String name) throws ResourceNotFoundException{
        Optional<Station> stationByNameDTO = stationRepository.findByName(name);
        try{
            if(stationByNameDTO.isPresent()){
                 stationByNameDTO.get();
            }else {throw new ResourceNotFoundException("Station not present");}
        } catch (NullPointerException e){
            return null;
        } return stationByNameDTO.get();
    }

    public Station getStationByCityDTO(String city) throws ResourceNotFoundException{
        Optional<Station> stationByCityDTO = stationRepository.findByCity(city);
        try{
            if(stationByCityDTO.isPresent()){
                stationByCityDTO.get();
            }else {throw new ResourceNotFoundException("Station not present");}
        } catch (NullPointerException e){
            return null;
        } return stationByCityDTO.get();
    }

    public Station addStation(Station station) {
        return stationRepository.save(station);
    }

    public Station updateStation(UUID stationId, StationDTO stationDTO) {
        Optional<Station> stations = stationRepository.findById(stationId);
        try{
            if(stations.isPresent()){
                stations.get().setName(stationDTO.getName());
                stations.get().setCity(stationDTO.getCity());
                stations.get().setStatus(stationDTO.getStatus());
                stationRepository.save(stations.get());}
            else {throw new ResourceNotFoundException("Not Found");}
        } catch (NullPointerException e){
            return null;
        } return stationRepository.save(stations.get());

    }

    public void deleteStation(UUID stationId) {
        stationRepository.deleteById(stationId);
    }
}

