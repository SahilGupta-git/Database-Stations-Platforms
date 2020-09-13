package com.xift.training.database.StationsDatabase.service.implement;

import com.xift.training.database.StationsDatabase.dto.PlatformDTO;
import com.xift.training.database.StationsDatabase.models.Platform;

import java.util.List;
import java.util.UUID;

public interface PlatformImpl {
    List<Platform> getAllPlatforms();
    Platform getPlatformById(UUID Id);
    Platform addPlatform(PlatformDTO platform,UUID stationId);
    void deletePlatform(UUID id);
}
