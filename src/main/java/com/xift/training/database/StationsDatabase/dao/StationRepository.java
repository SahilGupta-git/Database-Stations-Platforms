package com.xift.training.database.StationsDatabase.dao;

import com.xift.training.database.StationsDatabase.models.Station;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface StationRepository extends CrudRepository<Station, UUID> {
    public Optional<Station> findByName(String name);
    public Optional<Station> findByCity(String city);

}
