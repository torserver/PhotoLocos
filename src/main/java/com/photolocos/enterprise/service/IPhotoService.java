package com.photolocos.enterprise.service;

import com.photolocos.enterprise.dto.LocationDTO;
import com.photolocos.enterprise.dto.PhotoDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Set;

public interface IPhotoService {

    Set<PhotoDTO> fetchByArea(String area) throws Exception;

    Set<PhotoDTO> fetchByTag(String tag) throws Exception;

    PhotoDTO savePhoto(PhotoDTO photo, MultipartFile file) throws IOException;

    Set<PhotoDTO> fetchAll() throws Exception;

    Set<PhotoDTO> fetchPhotoByStateAndCity(String state, String city) throws Exception;

    LocationDTO fetchLocationByStateAndCity(String state, String city) throws Exception;
}
