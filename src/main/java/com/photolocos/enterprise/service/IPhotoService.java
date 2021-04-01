package com.photolocos.enterprise.service;

import com.photolocos.enterprise.dto.LocationDTO;
import com.photolocos.enterprise.dto.PhotoDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

public interface IPhotoService {

    Set<PhotoDTO> fetchByArea(String area);

    Set<PhotoDTO> fetchByTag(String tag);

    PhotoDTO savePhoto(PhotoDTO photo, MultipartFile image);

    Set<PhotoDTO> fetchAll();

    Set<PhotoDTO> fetchPhotoByCity(String city);

    Set<LocationDTO> fetchLocationByCity(String city);
}
