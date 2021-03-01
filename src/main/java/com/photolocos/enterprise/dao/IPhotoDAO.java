package com.photolocos.enterprise.dao;

import com.photolocos.enterprise.dto.PhotoDTO;

import java.util.*;

/**
 * @author Paramjyot Sandhu (sandhups@mail.uc.edu)
 *
 * PhotoDAO interface declaring required operations
 */
public interface IPhotoDAO {

    /**
     * This method is used to create an entry in Database, if there isn't one already
     *
     * @param photoDTO The photo object to be saved
     * @return True if entry was successfully created, false in any other scenario
     * @throws Exception Any exception that could occur as a result of failure to create a entry
     * in database or other preferred storage
     */
    boolean createEntry(PhotoDTO photoDTO) throws Exception;

    /**
     * This method will return a Set of photo objects {@link PhotoDTO}, that have similar tag(s)
     *
     * @param tags A array of list of keywords, used to return specific photos
     * @return A Set of photo objects if photos with similar tags are found, otherwise null
     */
    Set<PhotoDTO> fetchByTag(String[] tags);

    /**
     * This method will return a Set of photo objects {@link PhotoDTO}, that have particular ratings
     *
     * @param rating The rating to match while returning specific photos
     * @return A Set of photo objects if photos with similar rating are found, otherwise null
     */
    Set<PhotoDTO> fetchByRating(int rating);

    /**
     * This method will return a Set of photo objects {@link PhotoDTO}, that have particular Photography Type.
     * Unlike tags, only one photography type can be attached to photos. e.g. Nature, Wildlife, Downtown, etc.
     *
     * @param type The photography type to match while returning specific photos
     * @return A Set of photo objects if photos with specified type are found, otherwise null
     */
    Set<PhotoDTO> fetchByType(String type);

    /**
     * This method returns a Map of all photos objects {@link PhotoDTO} in the database with photoID's as keys and photos as value,
     * to easily get reference to photos with their ID's
     *
     * @return A Map consisting of all photos in the database
     *
     * TODO: Discuss with team, whether to change this to fetch all by Specific User/Contributor (if accounts are integrated in future)
     */
    Map<Integer, PhotoDTO> fetchAll();
}
