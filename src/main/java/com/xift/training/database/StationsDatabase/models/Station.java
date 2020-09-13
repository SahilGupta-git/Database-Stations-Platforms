package com.xift.training.database.StationsDatabase.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Component
@Entity
@Table(name = "stations")//,uniqueConstraints = @UniqueConstraint(columnNames = {"name","city"},name = "uniqueKeys"))
public class Station {
    @Id
    @Column(name = "id")
    private UUID stationId;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "city", unique = true, nullable = false)
    private String city;

    @Column(name = "status")
    private String status;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "station",cascade = CascadeType.ALL)//,orphanRemoval = true)
    @JsonIgnore
    private Set<Platform> platform;

    public Station(Set<Platform> platform) {
        this.platform = platform;
    }

    public Set<Platform> getPlatform() {
        return platform;
    }

    public void setPlatform(Set<Platform> platform) {
        this.platform = platform;
    }

    public UUID getStationId() {

        return stationId;
    }

    //public Station station;

    public Station(){
        this.stationId = UUID.randomUUID();
            this.platform = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
