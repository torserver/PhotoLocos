package com.photolocos.enterprise.dto;

import lombok.Data;
import java.io.Serializable;

/**
 * @author Max Graman (gramanma@mail.uc.edu)
 * TODO: JavaDoc.
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
