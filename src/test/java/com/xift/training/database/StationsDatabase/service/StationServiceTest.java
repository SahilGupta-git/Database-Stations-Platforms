package com.xift.training.database.StationsDatabase.service;

import com.xift.training.database.StationsDatabase.dao.StationRepository;
import com.xift.training.database.StationsDatabase.dto.StationByCityDTO;
import com.xift.training.database.StationsDatabase.dto.StationByNameDTO;
import com.xift.training.database.StationsDatabase.dto.StationDTO;
import com.xift.training.database.StationsDatabase.models.Platform;
import com.xift.training.database.StationsDatabase.models.Station;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class StationServiceTest {

    @Mock
    private StationRepository mockStationRepository;
    @Mock
    private StationByNameDTO mockStationByNameDTO;
    @Mock
    private StationByCityDTO mockStationByCityDTO;

    private StationService stationServiceUnderTest;

    @Before
    public void setUp() {
        initMocks(this);
        stationServiceUnderTest = new StationService(mockStationRepository, mockStationByNameDTO, mockStationByCityDTO);
    }

    @Test
    public void testGetAllStations() {
        final List<Station> stations = List.of(new Station(Set.of(new Platform())));
        when(mockStationRepository.findAll()).thenReturn(stations);
        final List<Station> result = stationServiceUnderTest.getAllStations();
        assertEquals(result,stations);
    }

    @Test
    public void testGetStationById() throws Exception {
        final Optional<Station> optionalStation = Optional.of(new Station(Set.of(new Platform())));
        when(mockStationRepository.findById(UUID.fromString("83e0fe3d-9ae3-4577-973d-ce990ffee022"))).thenReturn(optionalStation);
        assertThrows(ResourceNotFoundException.class,() -> {
        stationServiceUnderTest.getStationById(UUID.fromString("415831b3-0552-4eaf-b829-28fb86d4357b"));});
    }

    @Test
    public void testGetStationById_ThrowsResourceNotFoundException() throws Exception {
        final Optional<Station> optionalStation = Optional.of(new Station(Set.of(new Platform())));
        when(mockStationRepository.findById(UUID.fromString("83e0fe3d-9ae3-4577-973d-ce990ffee022"))).thenReturn(optionalStation);
        assertThrows(ResourceNotFoundException.class,() -> {
        stationServiceUnderTest.getStationById(UUID.fromString("415831b3-0552-4eaf-b829-28fb86d4357b"));});
    }

    @Test
    public void testGetStationByNameDTO() throws Exception {
        final Optional<Station> optionalStation = Optional.of(new Station(Set.of(new Platform())));
        when(mockStationRepository.findByName("name")).thenReturn(optionalStation);
        assertThrows(ResourceNotFoundException.class,() -> {
        stationServiceUnderTest.getStationByNameDTO("Resource Not Found");});
    }

    @Test
    public void testGetStationByNameDTO_ThrowsResourceNotFoundException() throws Exception {
        final Optional<Station> optionalStation = Optional.of(new Station(Set.of(new Platform())));
        assertThrows(ResourceNotFoundException.class,() -> {
        stationServiceUnderTest.getStationByNameDTO("name");});
    }

    @Test
    public void testGetStationByCityDTO() throws Exception {
        final Optional<Station> optionalStation = Optional.of(new Station(Set.of(new Platform())));
        when(mockStationRepository.findByCity("city")).thenReturn(optionalStation);
        assertThrows(ResourceNotFoundException.class,() -> {
        stationServiceUnderTest.getStationByCityDTO("city not found");});
    }

    @Test
    public void testGetStationByCityDTO_ThrowsResourceNotFoundException() {
        final Optional<Station> optionalStation = Optional.of(new Station(Set.of(new Platform())));
        assertThrows(ResourceNotFoundException.class,() -> {
        stationServiceUnderTest.getStationByCityDTO("city");});
    }

    @Test
    public void testAddStation() {
        final Station station = new Station(Set.of(new Platform()));
        when(mockStationRepository.save(any(Station.class))).thenReturn(new Station(Set.of(new Platform())));
        stationServiceUnderTest.addStation(station);
        verify(mockStationRepository).save(station);
    }

    @Test
    public void testUpdateStation() throws ResourceNotFoundException {
        final StationDTO stationDTO = new StationDTO(UUID.fromString("98280602-b6d6-453a-8c62-ff00c7dba665"), "name", "city", "status");
        final Optional<Station> optionalStation = Optional.of(new Station(Set.of(new Platform())));
        when(mockStationRepository.findById(UUID.fromString("9cc1ea2e-14d8-4676-8f0e-48bdfa88e372"))).thenReturn(optionalStation);
        when(mockStationRepository.save(any(Station.class))).thenReturn(new Station(Set.of(new Platform())));
        assertThrows(ResourceNotFoundException.class,() -> {
        stationServiceUnderTest.updateStation(UUID.fromString("e0081294-8779-4bc3-b8ca-875827953e6c"), stationDTO);});
    }

    @Test
    public void testDeleteStation() {
        stationServiceUnderTest.deleteStation(UUID.fromString("8a04036c-ae88-4dc3-90db-11a5fc6f03f5"));
        verify(mockStationRepository).deleteById(UUID.fromString("8a04036c-ae88-4dc3-90db-11a5fc6f03f5"));
    }
}
