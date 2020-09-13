package com.xift.training.database.StationsDatabase.service;

import com.xift.training.database.StationsDatabase.dao.PlatformRepository;
import com.xift.training.database.StationsDatabase.dto.PlatformDTO;
import com.xift.training.database.StationsDatabase.models.Platform;
import com.xift.training.database.StationsDatabase.models.Station;
import com.xift.training.database.StationsDatabase.service.implement.PlatformImpl;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PlatformService implements PlatformImpl {

    private final PlatformRepository platformRepository;
    private final StationService stationService;

    public PlatformService(PlatformRepository platformRepository, StationService stationService) {
        this.platformRepository = platformRepository;
        this.stationService = stationService;
    }

    public List<Platform> getAllPlatforms() {

        return (List<Platform>) platformRepository.findAll();
    }

    public Platform savePlatform(Platform platform){
        return platformRepository.save(platform);
    }

    public Platform getPlatformById(UUID id) {
        Optional<Platform> optionalPlatform = platformRepository.findById(id);
        try {
            if (optionalPlatform.isPresent()) {
                return savePlatform(optionalPlatform.get());
            } else {
                throw new ResourceNotFoundException("No Platform Present");
            }
        } catch (NullPointerException e){
            return null;
        }
    }

    public Platform addPlatform(PlatformDTO platform,UUID stationId) {
        Station station = stationService.getStationById(stationId);
        Platform pt = new Platform();
        pt.setStatusUpdate(platform.getStatusUpdate());
        int size = station.getPlatform().size();
        pt.setPlatformNo(size+1);
        pt.setStation(station);
        station.getPlatform().add(pt);
        stationService.addStation(station);
        return pt;
    }

    public void deletePlatform(UUID id) {
        platformRepository.deleteById(id);
    }
}
