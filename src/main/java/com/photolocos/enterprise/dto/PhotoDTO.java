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
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String type;
    private String fileType;
    private String filePath;
    private String tips;
    private String uri;
    private String contributor;
    private String tags;
    private Date dateTaken;
    private int rating;
    @OneToOne
    @JoinColumn(name="id")
    private LocationDTO location;
    private int photoId;

    /**
     * Sets the rating for a given photo.
     * Also contains some back end logic needed.
     *
     * @param rating 1-5.
     */
    public void setRating(int rating) {
        if (rating < 5) {
            //TODO Logic for ratings higher than 5, an invalid input.
            System.out.println("Rating of " + rating + ", is too high");
        } else if (rating >= 0) {
            this.rating = rating;
        } else if (rating < 0) {
            //TODO Logic for ratings lower than 0, an invalid input.
            System.out.println("Rating of " + rating + ", is too low");
        }
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return uri;
    }
}
