package com.photolocos.enterprise.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Max Graman (gramanma@mail.uc.edu)
 * TODO: JavaDoc.
 */
public @Data
class PhotoDTO implements Serializable {

    /*
     *
     *  Fields, the attributes of the photos, if you will
     *
     */

    private String type;
    private String fileType;
    private LocationDTO location;
    private String tips;
    private String uri;
    private String contributor;
    private String[] tags;
    private Date dateTaken;
    private int rating;
    private int id;
    private int photoId;

    /*
     *
     * Getters and Setters
     *
     */

    /**
     * Returns a string, the file type of a photo uploaded to the server.
     * @return fileType in String format.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the file type of a photo object.
     * @param fileType, EX: png, jpg...
     */
    public void setType(String fileType) {
        this.type = fileType;
    }

    /**
     * Returns a string, the file type of a photo uploaded to the server.
     * @return fileType in String format.
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * Sets the file type of a photo object.
     * @param fileType, EX: png, jpg...
     */
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    /**
     * Returns an Array[] of tags for a given photo.
     * @return tags, EX: { funny, cool, nice, stocks, to, the, moon }
     */
    public String[] getTags() {
        return tags;
    }

    /**
     * Sets an Array[] of tags for a given photo.
     * @param tags, EX: { funny, cool, nice, stocks, to, the, moon, poggers }
     */
    public void setTags(String[] tags) {
        this.tags = tags;
    }

    /**
     * Returns a string for a given photo.
     * @return location, common name (EX: Cincinnati, OH)
     */
    public LocationDTO getLocation() {
        return location;
    }

    /**
     * Sets a location for a given photo.
     * @param location is NOT a location Object (EX: Cincinnati, OH).
     */
    public void setLocation(LocationDTO location) {
        this.location = location;
    }

    /**
     * Returns the tips for a given photo
     * @return tips
     */
    public String getTips() {
        return tips;
    }

    /**
     * Sets the tips for a given photo.
     * @param tips is NOT an array
     */
    public void setTips(String tips) {
        this.tips = tips;
    }

    /**
     * Gets the rating for a given photo.
     * @return rating.
     */
    public int getRating() {
        return rating;
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

    /**
     *
     * @return id, ID of the photo, linked to a location.
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id, ID of the photo, linked to a location.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return dateTaken, the date the photo was taken.
     */
    public Date getDateTaken() {
        return dateTaken;
    }

    /**
     *
     * @param dateTaken, the date the photo was taken.
     */
    public void setDateTaken(Date dateTaken) {
        this.dateTaken = dateTaken;
    }

    /**
     *
     * @return contributor, the user who took the photo.
     */
    public String getContributor() {
        return contributor;
    }

    /**
     *
     * @param contributor, the user who took the photo.
     */
    public void setContributor(String contributor) {
        this.contributor = contributor;
    }

    /**
     *
     * @return uri, the URI of the photo on the server.
     */
    public String getUri() {
        return uri;
    }

    /**
     *
     * @param uri, the URI of the photo on the server.
     */
    public void setUri(String uri) {
        this.uri = uri;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return uri;
    }

    /**
     *
     * @return, returns the Unique ID of the photo
     */
    public int getPhotoId() {
        return photoId;
    }

    /**
     *
     * @param photoId, the Unique ID of the photo
     */
    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }


}
