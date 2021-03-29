package com.photolocos.enterprise.service;

import com.photolocos.enterprise.dao.IPhotoDAO;
import com.photolocos.enterprise.dto.LocationDTO;
import com.photolocos.enterprise.dto.PhotoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

@Component
public class PhotoService implements IPhotoService{

    @Autowired
    IPhotoDAO photoDAO;


    @Override
    public PhotoDTO fetchByLocation(String location) {

        return null;
    }

    @Override
    public Set<PhotoDTO> fetchByTag(String tag) {
        return null;
    }

    @Override
    public PhotoDTO savePhoto(PhotoDTO photo, MultipartFile image) {
        PhotoDTO savedPhoto;
        try {
            photoDAO.save(photo);
            photoDAO.saveImage(image);
            savedPhoto = photo;
        } catch (Exception e) {
            e.printStackTrace();
            savedPhoto = new PhotoDTO();
        }

        return savedPhoto;
    }

    @Override
    public Set<PhotoDTO> fetchAll() {
        return null;
    }

    @Override
    public Set<PhotoDTO> fetchPhotoByCity(String city) {
        return null;
    }

    @Override
    public Set<LocationDTO> fetchLocationByCity(String city) {
        return null;
    }
}
