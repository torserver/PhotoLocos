package com.photolocos.enterprise.dto;

import lombok.Data;
import java.io.Serializable;

/**
 * @author Max Graman (gramanma@mail.uc.edu)
 *
 * longitude: Stores Longitude of photo location
 * latitude: Stores Longitude of photo location
 * country: Stores Country name
 * state: Store name of the particular state
 * city: Stores name of the city
 * area: store area of the photo location
 * description: Stores description of the location/area
 * id: photo ID
 * locationId: Location ID
 */
public @Data
class LocationDTO implements Serializable {
    private String longitude;
    private String latitude;
    private String country;
    private String state;
    private String city;
    private String area;
    private String description;
    private int id;
    private int locationId;
}
