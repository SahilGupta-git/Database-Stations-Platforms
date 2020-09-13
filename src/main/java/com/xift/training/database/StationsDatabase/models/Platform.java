package com.xift.training.database.StationsDatabase.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "platforms")
public class Platform {
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "platform_no")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int platformNo;

    @Column(name = "statusUpdate")
    private String statusUpdate;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "station_id",referencedColumnName = "id")
    private Station station;

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public Platform(){
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public void setPlatformNo(int platformNo) {
        this.platformNo = platformNo;
    }

    public int getPlatformNo() {
        return platformNo;
    }

    public String getStatusUpdate() {
        return statusUpdate;
    }

    public void setStatusUpdate(String Status) {
        this.statusUpdate = Status;
    }

}
