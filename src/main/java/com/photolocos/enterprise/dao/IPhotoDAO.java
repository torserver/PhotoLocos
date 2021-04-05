package com.photolocos.enterprise.dao;

import com.photolocos.enterprise.dto.LocationDTO;
import com.photolocos.enterprise.dto.PhotoDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

public interface IPhotoDAO {

    /**
     * This method returns a Map of all photos objects {@link PhotoDTO} in the database with photoID's as keys and photos as value,
     * to easily get reference to photos with their ID's
     *
     * @return A Map consisting of all photos in the database
     *
     * TODO: Discuss with team, whether to change this to fetch all by Specific User/Contributor (if accounts are integrated in future)
     */
    Set<PhotoDTO> fetchAll() throws Exception;

    void save(PhotoDTO photo);

    void saveImage(MultipartFile image) throws IOException;

    /**
     * This method will return a Set of photo objects {@link PhotoDTO}, that have similar tag(s)
     *
     * @param tags A array of list of keywords, used to return specific photos
     * @return A Set of photo objects if photos with similar tags are found, otherwise null
     */
    Set<PhotoDTO> fetchByTag(String[] tags) throws Exception;

    /**
     * This method will return a Set of photo objects {@link PhotoDTO}, that have particular ratings
     *
     * @param rating The rating to match while returning specific photos
     * @return A Set of photo objects if photos with similar rating are found, otherwise null
     */
    Set<PhotoDTO> fetchByRating(int rating) throws Exception;

    /**
     * This method will return a Set of photo objects {@link PhotoDTO}, that have particular Photography Type.
     * Unlike tags, only one photography type can be attached to photos. e.g. Nature, Wildlife, Downtown, etc.
     *
     * @param type The photography type to match while returning specific photos
     * @return A Set of photo objects if photos with specified type are found, otherwise null
     */
    Set<PhotoDTO> fetchByType(String type) throws Exception;

    /**
     * This method returns all photos whose location matches the given location String
     *
     * @param location LocationDTO object representing a given location
     * @return A set of photo objects with location matching the given location String
     */
    Set<PhotoDTO> fetchByLocation(LocationDTO location) throws Exception;
}
