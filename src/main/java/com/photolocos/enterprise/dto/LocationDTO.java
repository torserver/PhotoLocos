package com.photolocos.enterprise.dto;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;



/**
 * @author Max Graman (gramanma@mail.uc.edu)
 * TODO: JavaDoc.
 */
@Entity
@Table(name="locations")
public @Data
class LocationDTO implements Serializable {
    /*
     *
     *  Fields, the attributes of the photos, if you will
     *
     */

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private double longitude;
    private double latitude;
    private String country;
    private String state;
    private String city;
    private String area;
    private String description;
    private int locationId;

    public boolean equals(LocationDTO location) {
        return (this.getState().equals(location.getState()) && this.getCity().equals(location.getCity()))
                || (this.getLatitude() == location.getLatitude() && this.getLongitude() == location.getLongitude())
                || (this.getArea().equals(location.getArea()));
    }
}
