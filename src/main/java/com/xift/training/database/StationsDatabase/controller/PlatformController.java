package com.xift.training.database.StationsDatabase.controller;

import com.xift.training.database.StationsDatabase.dto.PlatformDTO;
import com.xift.training.database.StationsDatabase.models.Platform;
import com.xift.training.database.StationsDatabase.service.PlatformService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class PlatformController {
    /**
     * GET -> /platforms
     * GET -> /platforms/{platformId}
     * POST -> /platform/{stationId}  //add platform
     * {
     *     status:""
     * }
     * DELETE -> /platforms/{platformId}
     *
     */

        private final PlatformService platformService;

        public PlatformController(PlatformService platformService) {
            this.platformService = platformService;
        }

        @GetMapping("/platforms")
        public List<Platform> getAllPlatform(){
            return platformService.getAllPlatforms();
        }

        @GetMapping("/platforms/{platformId}")
        public Platform getPlatformById(@PathVariable(name = "platformId") UUID id){
            return platformService.getPlatformById(id);
        }

        @PostMapping("/platformPost")
        public Platform savePlatform(Platform platform){
            return platformService.savePlatform(platform);
        }

        @PostMapping("/platform/{stationId}")
        public Platform addPlatform(@RequestBody PlatformDTO platform,
                                    @PathVariable(name = "stationId") UUID stationId){
            return platformService.addPlatform(platform,stationId);
        }

        @DeleteMapping("/platformsDel/{platformId}")
        public void deletePlatform(@PathVariable(name = "platformId") UUID id){
            platformService.deletePlatform(id);
        }
 }


