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
@Table(name="photos")
public @Data
class PhotoDTO implements Serializable {

    /*
     *
     *  Fields, the attributes of the photos, if you will
     *
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int photoId;

    private String type;
    private String fileType;
    private String fileName;
    private String filePath;
    private String tips;
    private String uri;
    private String contributor;
    private String tags;
    private Date dateTaken;
    private int rating;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="location_id")
    private LocationDTO location;

}
