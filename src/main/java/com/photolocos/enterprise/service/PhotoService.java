package com.photolocos.enterprise.service;

import com.photolocos.enterprise.dao.IPhotoDAO;
import com.photolocos.enterprise.dto.LocationDTO;
import com.photolocos.enterprise.dto.PhotoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

@Component
public class PhotoService implements IPhotoService{

    @Autowired
    IPhotoDAO photoDAO;


    @Override
    @Cacheable(value = "photosByArea", key = "#area")
    public Set<PhotoDTO> fetchByArea(String area) {
        return null;
    }

    @Override
    @Cacheable(value = "photosByTag", key = "#tag")
    public Set<PhotoDTO> fetchByTag(String tag) {
        return photoDAO.fetchByTag(new String[]{tag});
    }

    @Override
    @CacheEvict(value = {"photosByArea", "photosByTag", "photosByCity", "allPhotos"}, allEntries = true)
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
    @Cacheable("allPhotos")
    public Set<PhotoDTO> fetchAll() {
        return null;
    }

    @Override
    @Cacheable(value = "photosByCity", key = "#city")
    public Set<PhotoDTO> fetchPhotoByCity(String city) {
        return null;
    }

    @Override
    @Cacheable(value = "locationByCity", key = "#city")
    public Set<LocationDTO> fetchLocationByCity(String city) {
        return null;
    }
}
