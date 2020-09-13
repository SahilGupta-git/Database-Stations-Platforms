package com.xift.training.database.StationsDatabase.controller;

import com.xift.training.database.StationsDatabase.dto.StationByCityDTO;
import com.xift.training.database.StationsDatabase.dto.StationByNameDTO;
import com.xift.training.database.StationsDatabase.dto.StationDTO;
import com.xift.training.database.StationsDatabase.models.Platform;
import com.xift.training.database.StationsDatabase.models.Station;
import com.xift.training.database.StationsDatabase.service.StationService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.junit.Assert.*;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class StationControllerTest {

    @Mock
    private StationService mockStationService;
    private StationController stationControllerUnderTest;

    @Before
    public void setUp() {
        initMocks(this);
        stationControllerUnderTest = new StationController(mockStationService);
    }

    @Test
    public void testGetAllStations() {
        final List<Station> stations = List.of(new Station(Set.of(new Platform())));
        when(mockStationService.getAllStations()).thenReturn(stations);
        final List<Station> result = stationControllerUnderTest.getAllStations();
        assertEquals(result,stations);
     }

    @Test
    public void testGetStationById() {
        when(mockStationService.getStationById(UUID.fromString("3a50e0bf-e556-45e8-af78-1ff46bfe2d2c"))).thenReturn(new Station(Set.of(new Platform())));
        final Station result = stationControllerUnderTest.getStationById(UUID.fromString("2cc52a42-e577-4ad5-b7ce-2e9b8b59ba3c"));
        verify(mockStationService).getStationById(UUID.fromString("2cc52a42-e577-4ad5-b7ce-2e9b8b59ba3c"));
    }


    @Test
    public void testGetStationByNameDTO() {
        when(mockStationService.getStationByNameDTO("name")).thenReturn(new Station(Set.of(new Platform())));
        final Station result = stationControllerUnderTest.getStationByNameDTO("name");
        verify(mockStationService).getStationByNameDTO("name");
    }

    @Test
    public void testGetStationByCityDTO() {
        when(mockStationService.getStationByCityDTO("city")).thenReturn(new Station(Set.of(new Platform())));
        final Station result = stationControllerUnderTest.getStationByCityDTO("city");
        verify(mockStationService).getStationByCityDTO("city");
    }

    @Test
    public void testAddStation() {
        final Station station = new Station(Set.of(new Platform()));
        when(mockStationService.addStation(any(Station.class))).thenReturn(new Station(Set.of(new Platform())));
        final Station result = stationControllerUnderTest.addStation(station);
        verify(mockStationService).addStation(station);
    }

    @Test
    public void testUpdateStation() {
        final StationDTO stationDTO = new StationDTO(UUID.fromString("c76428a0-f840-4579-bec8-258d4fea069c"), "name", "city", "status");
        when(mockStationService.updateStation(eq(UUID.fromString("7ee90124-2214-461a-a056-2bc80d9b57bd")), any(StationDTO.class))).thenReturn(new Station(Set.of(new Platform())));
        final Station result = stationControllerUnderTest.updateStation(stationDTO, UUID.fromString("56749381-201b-444b-a972-dca019e0d8da"));
        verify(mockStationService).updateStation(UUID.fromString("56749381-201b-444b-a972-dca019e0d8da"),stationDTO);
    }

    @Test
    public void testDeleteStation() {
        stationControllerUnderTest.deleteStation(UUID.fromString("6758c126-20de-4d6d-99b2-021558941f12"));
        verify(mockStationService).deleteStation(UUID.fromString("6758c126-20de-4d6d-99b2-021558941f12"));
    }
}
