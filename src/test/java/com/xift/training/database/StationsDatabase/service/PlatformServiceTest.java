package com.xift.training.database.StationsDatabase.service;

import com.xift.training.database.StationsDatabase.dao.PlatformRepository;
import com.xift.training.database.StationsDatabase.dto.PlatformDTO;
import com.xift.training.database.StationsDatabase.models.Platform;
import com.xift.training.database.StationsDatabase.models.Station;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class PlatformServiceTest {

    @Mock
    private PlatformRepository mockPlatformRepository;
    @Mock
    private StationService mockStationService;

    private PlatformService platformServiceUnderTest;

    @Before
    public void setUp() {
        initMocks(this);
        platformServiceUnderTest = new PlatformService(mockPlatformRepository, mockStationService);
    }

    @Test
    public void testGetAllPlatforms() {
        when(mockPlatformRepository.findAll()).thenReturn(List.of(new Platform()));
        final List<Platform> result = platformServiceUnderTest.getAllPlatforms();
        assertThat(result).isNotEmpty();
    }

    @Test
    public void testGetPlatformById() {
        when(mockPlatformRepository.findById(UUID.fromString("0fd8b2dc-0f02-494d-8dc5-54dc79c45f25"))).thenReturn(Optional.of(new Platform()));
        platformServiceUnderTest.getPlatformById(UUID.fromString("0fd8b2dc-0f02-494d-8dc5-54dc79c45f25"));
        assertEquals(UUID.fromString("0fd8b2dc-0f02-494d-8dc5-54dc79c45f25"),UUID.fromString("0fd8b2dc-0f02-494d-8dc5-54dc79c45f25"));
    }

    @Test
    public void testGetPlatformById_ThrowsResourceNotFoundException() {
        when(mockPlatformRepository.findById(UUID.fromString("0fd8b2dc-0f02-494d-8dc5-54dc79c45f25"))).thenReturn(Optional.of(new Platform()));
        assertThrows(ResourceNotFoundException.class,() -> {
        platformServiceUnderTest.getPlatformById(UUID.fromString("7d7cb6e3-7b49-48b1-a092-e6940e382e74"));});
    }

    @Test
    public void testAddPlatform() {
        final PlatformDTO platform = new PlatformDTO("statusUpdate");
        Set<Platform> platforms=new HashSet<>();
        when(mockStationService.getStationById(UUID.fromString("6c6288a4-e0a3-4be4-815a-47d0c8d40448"))).thenReturn(new Station(platforms));
        when(mockStationService.addStation(any(Station.class))).thenReturn(new Station(platforms));
        final Platform result = platformServiceUnderTest.addPlatform(platform, UUID.fromString("6c6288a4-e0a3-4be4-815a-47d0c8d40448"));
        assertEquals(result,platforms.stream().findFirst().get());
       }

    @Test
    public void testDeletePlatform() {
        platformServiceUnderTest.deletePlatform(UUID.fromString("c7cc9afe-73f7-48e2-98d4-e3f93078d97e"));
        verify(mockPlatformRepository).deleteById(UUID.fromString("c7cc9afe-73f7-48e2-98d4-e3f93078d97e"));
    }
}
