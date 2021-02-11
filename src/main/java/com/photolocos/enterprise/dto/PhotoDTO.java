package com.photolocos.enterprise.dto;

public class PhotoDTO {

    //Fields, the attributes of the photos, if you will

    private String fileType;
    private String[] tags;
    private String location;
    private String tips;
    private int rating;

    /*
     *
     * Getters and Setters
     *
     */

    /**
     * Returns a string, the file type of a photo uploaded to the server.
     * @return fileType in String format.
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * Sets the file type of a photo object.
     * @param fileType
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
    public String getLocation() {
        return location;
    }

    /**
     * Sets a location for a given photo.
     * @param location is NOT a location Object (EX: Cincinnati, OH).
     */
    public void setLocation(String location) {
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

}
