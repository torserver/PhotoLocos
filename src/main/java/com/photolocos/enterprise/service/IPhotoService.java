package com.photolocos.enterprise.service;

import com.photolocos.enterprise.dto.LocationDTO;
import com.photolocos.enterprise.dto.PhotoDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

public interface IPhotoService {
    /**
     * Fetches a photo using location name
     *
     * @param locationId
     */
    PhotoDTO fetchByLocation(String locationId);

    /**
     * Fetches photos using descriptive tag
     *
     * @param tag
     */
    Set<PhotoDTO> fetchByTag(String tag);

    /**
     * Saves a photo to the database
     *
     * @param photo
     * @param image
     */
    PhotoDTO savePhoto(PhotoDTO photo, MultipartFile image);

    Set<PhotoDTO> fetchAll();

    /**
     * Fetches photos using city name
     *
     * @param city
     */
    Set<PhotoDTO> fetchPhotoByCity(String city);

    /**
     * Fetches photos using city name
     *
     * @param city
     */
    Set<LocationDTO> fetchLocationByCity(String city);
}
