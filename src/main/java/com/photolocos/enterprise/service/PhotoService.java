package com.photolocos.enterprise.service;

import com.photolocos.enterprise.dao.IPhotoDAO;
import com.photolocos.enterprise.dto.LocationDTO;
import com.photolocos.enterprise.dto.PhotoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Component
public class PhotoService implements IPhotoService{
    private IPhotoDAO photoDAO;
    PhotoDTO photo = new PhotoDTO();
    Set<PhotoDTO> photos = new HashSet<PhotoDTO>();

    public PhotoService(IPhotoDAO photoDAO) {
        this.photoDAO = photoDAO;
    }

    @Override
    public PhotoDTO savePhoto(PhotoDTO photo, MultipartFile image) {
        try {
            photoDAO.save(photo);
            photoDAO.saveImage(image);

            return photo;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public PhotoDTO fetchByLocation(String locationId) {
        photo = photoDAO.fetchByLocation(Integer.parseInt(locationId));
        return photo;
    }

    @Override
    public Set<PhotoDTO> fetchByTag(String tag) {
        photos = photoDAO.fetchByTag(new String[]{tag});
        return photos;
    }

    @Override
    public Set<PhotoDTO> fetchAll() {
        return photoDAO.fetchAll();
    }

    @Override
    public Set<PhotoDTO> fetchPhotoByCity(String city) {
        return photos;
    }

    @Override
    public Set<LocationDTO> fetchLocationByCity(String city) {
        HashSet<LocationDTO> locations = new HashSet<LocationDTO>();
        return locations;
    }
}
