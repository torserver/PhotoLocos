package com.photolocos.enterprise.service;

import com.photolocos.enterprise.dao.ILocationDAO;
import com.photolocos.enterprise.dao.IPhotoDAO;
import com.photolocos.enterprise.dto.LocationDTO;
import com.photolocos.enterprise.dto.PhotoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

@Component
public class PhotoService implements IPhotoService {

    @Autowired
    IPhotoDAO photoDAO;
    @Autowired
    ILocationDAO locationDAO;


    @Override
    @Cacheable(value = "fetchByArea", key = "#area")
    public Set<PhotoDTO> fetchByArea(String area) throws Exception {
        LocationDTO location = locationDAO.fetchByArea(area);
        Set<PhotoDTO> photoByArea = photoDAO.fetchByLocation(location);

        return photoByArea;
    }

    @Override
    @Cacheable(value = "photosByTag", key = "#tag")
    public Set<PhotoDTO> fetchByTag(String tag) throws Exception {
        return photoDAO.fetchByTag(new String[]{tag});
    }

    @Override
    @CacheEvict(value = {"fetchByArea", "photosByTag", "photosByStateAndCity", "allPhotos"}, allEntries = true)
    public PhotoDTO savePhoto(PhotoDTO photo, MultipartFile image) {
        PhotoDTO savedPhoto;
        try {
            Path currentPath = Paths.get(".");
            Path absolutePath = currentPath.toAbsolutePath();
            String str = absolutePath.toString();
            if (str != null && str.length() > 0) {
                str = str.substring(0, str.length() - 2);
            }
            Path path = Paths.get(str + "/src/main/resources/static/photos/" + image.getOriginalFilename());
            photo.setFilePath(path.toString());

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
    public Set<PhotoDTO> fetchAll() throws Exception {
        return photoDAO.fetchAll();
    }

    @Override
    @Cacheable(value = "photosByStateAndCity")
    public Set<PhotoDTO> fetchPhotoByStateAndCity(String state, String city) throws Exception {
        LocationDTO location = new LocationDTO();
        location.setState(state);
        location.setCity(city);
        return photoDAO.fetchByLocation(location);
    }

    @Override
    public LocationDTO fetchLocationByStateAndCity(String state, String city) throws Exception {
        return locationDAO.fetchByStateAndCity(state, city);
    }

}
