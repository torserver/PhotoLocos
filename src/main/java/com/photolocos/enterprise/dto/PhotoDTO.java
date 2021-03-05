package com.photolocos.enterprise.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Max Graman (gramanma@mail.uc.edu)
 * type: Type of photo
 * fileType: format of photo (eg. png, jpeg, etc.)
 * location: Location where photo was clicked
 * tips: General tips
 * uri: URI of a particular photo
 * contributor: Photgrapher name
 * tags: Tags describing the photo
 * dateTaken: Date on which the photo was clicked
 * rating: Rating between the range of 1-5
 * id: Location ID
 * photoId: Photo ID
 */
public @Data
class PhotoDTO implements Serializable {
    private String type;
    private String fileType;
    private String location;
    private String tips;
    private String uri;
    private String contributor;
    private String[] tags;
    private Date dateTaken;
    private int rating;
    private int id;
    private int photoId;

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return uri;
    }

    /**
    * Sets the rating for a given photo.
    * Also contains some back end logic needed.
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
}
