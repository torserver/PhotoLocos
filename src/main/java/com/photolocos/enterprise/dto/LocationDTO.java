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

    private String longitude;
    private String latitude;
    private String country;
    private String state;
    private String city;
    private String area;
    private String description;


    private int locationId;

    /*
     *
     * Getters and Setters
     *
     */

    /**
     *
     * Gets the longitude of a location.
     * @return the longitude of the location.
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     *
     * @param longitude, set the longitude of a location.
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    /**
     *
     * Gets the latitude of a location.
     * @return the latitude of the location.
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     *
     * @param latitude, set the latitude of a location.
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

}
