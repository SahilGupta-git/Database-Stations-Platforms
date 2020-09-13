package com.xift.training.database.StationsDatabase.controller;

import com.xift.training.database.StationsDatabase.dto.PlatformDTO;
import com.xift.training.database.StationsDatabase.models.Platform;
import com.xift.training.database.StationsDatabase.service.PlatformService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class PlatformControllerTest {

    @Mock
    private PlatformService mockPlatformService;
    private PlatformController platformControllerUnderTest;

    @Before
    public void setUp() {
        initMocks(this);
        platformControllerUnderTest = new PlatformController(mockPlatformService);
    }

    @Test
    public void testGetAllPlatform() {
        when(mockPlatformService.getAllPlatforms()).thenReturn(List.of(new Platform()));
        final List<Platform> platforms = platformControllerUnderTest.getAllPlatform();
        assertThat(platforms).isNotEmpty();
    }

    @Test
    public void testGetPlatformById() {
        when(mockPlatformService.getPlatformById(UUID.fromString("a0713a29-bebb-4aaf-9661-1cbdd1a03d8e"))).thenReturn(new Platform());
        platformControllerUnderTest.getPlatformById(UUID.fromString("314ea4ae-c8be-4351-b849-1590748d71d4"));
        verify(mockPlatformService).getPlatformById(UUID.fromString("314ea4ae-c8be-4351-b849-1590748d71d4"));
    }

    @Test
    public void testAddPlatform() {
        final PlatformDTO platform = new PlatformDTO("statusUpdate");
        when(mockPlatformService.addPlatform(any(PlatformDTO.class), eq(UUID.fromString("4131d4a6-1768-4af0-bce4-21fc8a544c45")))).thenReturn(new Platform());
        final Platform result = platformControllerUnderTest.addPlatform(platform, UUID.fromString("ee073c42-8e79-4f24-ae0e-b5f2be5b8e8a"));
        verify(mockPlatformService).addPlatform(platform,UUID.fromString("ee073c42-8e79-4f24-ae0e-b5f2be5b8e8a"));

    }

    @Test
    public void testDeletePlatform() {
        platformControllerUnderTest.deletePlatform(UUID.fromString("7b4b4d70-9834-4613-b0fc-c2753d0fbe94"));
        verify(mockPlatformService).deletePlatform(UUID.fromString("7b4b4d70-9834-4613-b0fc-c2753d0fbe94"));
    }
}
