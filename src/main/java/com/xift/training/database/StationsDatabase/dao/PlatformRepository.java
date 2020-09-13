package com.xift.training.database.StationsDatabase.dao;

import com.xift.training.database.StationsDatabase.models.Platform;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface PlatformRepository extends CrudRepository<Platform,UUID> {

}