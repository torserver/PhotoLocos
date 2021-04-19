package com.photolocos.enterprise.dto;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;




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
    private int locationId;

    private String longitude;
    private String latitude;
    private String country;
    private String state;
    private String city;
    private String area;
    private String description;


//    @ToString.Exclude
//    @OneToOne(cascade=CascadeType.ALL)
//    @JoinColumn(name="id")
//    private PhotoDTO photo;

    public boolean equals(LocationDTO location) {
        return (this.getState().equals(location.getState()) && this.getCity().equals(location.getCity()))
          
                || (this.getLatitude().equals(location.getLatitude()) && this.getLongitude().equals(location.getLongitude()))

                || (this.getArea().equals(location.getArea()));
    }
}
