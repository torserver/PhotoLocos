package com.photolocos.enterprise.dao;

import com.photolocos.enterprise.dto.LocationDTO;
import com.photolocos.enterprise.dto.PhotoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Repository
@Profile("dev")
public class PhotoSQLDAO implements IPhotoDAO {

    @Autowired
    PhotoRepository photoRepository;

    @Override
    public Set<PhotoDTO> fetchAll() throws Exception {
        Iterable<PhotoDTO> allPhotos = photoRepository.findAll();
        Set<PhotoDTO> photos = new HashSet<>();
        for (PhotoDTO photo: allPhotos) {
            photos.add(photo);
        }
        return photos;
    }

    @Override
    public void save(PhotoDTO photo) {
        photoRepository.save(photo);
    }

    @Override
    public void saveImage(MultipartFile image, PhotoDTO photoDTO) throws IOException {

    }

    @Override
    public Set<PhotoDTO> fetchByTag(String[] tags) throws Exception {
        Set<PhotoDTO> matchedPhotos = new HashSet<>();
        for (String tag: tags) {
            List<PhotoDTO> containsTag = photoRepository.findByTagsContaining(tag);
            matchedPhotos.addAll(containsTag);
        }

        return matchedPhotos;
    }

    @Override
    public Set<PhotoDTO> fetchByRating(int rating) throws Exception {
        List<PhotoDTO> byRating = photoRepository.findByRating(rating);

        return new HashSet<>(byRating);
    }

    @Override
    public Set<PhotoDTO> fetchByType(String type) throws Exception {
        List<PhotoDTO> byType = photoRepository.findByType(type);

        return new HashSet<>(byType);
    }

    @Override
    public Set<PhotoDTO> fetchByLocation(LocationDTO location) throws Exception {
        List<PhotoDTO> byLocation = photoRepository.findByLocation(location);

        return new HashSet<>(byLocation);
    }
}
