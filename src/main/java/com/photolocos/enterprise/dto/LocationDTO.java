package com.photolocos.enterprise.dto;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Max Graman (gramanma@mail.uc.edu)
 * TODO: JavaDoc.
 */
@SuppressWarnings("ALL")
@Entity
@Table(name="locations")
public @Data
class LocationDTO implements Serializable {
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
}
