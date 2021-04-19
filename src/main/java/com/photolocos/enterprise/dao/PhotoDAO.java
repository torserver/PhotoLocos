package com.photolocos.enterprise.dao;

import com.photolocos.enterprise.dto.LocationDTO;
import com.photolocos.enterprise.dto.PhotoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Repository()
public class PhotoDAO{

    Map<Integer, PhotoDTO> photos = new HashMap<>();

    public Set<PhotoDTO> fetchAll() {
        return new HashSet<>(photos.values());
    }


    public void save(PhotoDTO photo) {
        photoRepository.save(photo);
    }

    public void saveImage(MultipartFile file) throws IOException {
        String folder = "/uploadedPhotos/";
        byte[] bytes = file.getBytes();
        Path path = Paths.get(photo.getFilePath() + file.getOriginalFilename());
        Files.write(path, bytes);
    }


    public Set<PhotoDTO> fetchByTag(String[] tags) {
        List<PhotoDTO> photosCollection = new ArrayList<>(photos.values());
        Set<PhotoDTO> matchedPhotos = new HashSet<>();

        for (PhotoDTO photo : photosCollection) {
            Set<String> tagsSet = new HashSet<>(Arrays.asList(photo.getTags()));
            for (String tag: tags) {
                if (tagsSet.contains(tag)) {
                    matchedPhotos.add(photo);
                    break;
                }
            }
        }

        return matchedPhotos;
    }


    public Set<PhotoDTO> fetchByRating(int rating) {
        List<PhotoDTO> photosCollection = new ArrayList<>(photos.values());
        Set<PhotoDTO> matchedPhotos = new HashSet<>();

        for (PhotoDTO photo : photosCollection) {
            if (photo.getRating() == rating) {
                matchedPhotos.add(photo);
            }
        }

        return matchedPhotos;
    }

    public Set<PhotoDTO> fetchByType(String type) {
        List<PhotoDTO> photosCollection = new ArrayList<>(photos.values());
        Set<PhotoDTO> matchedPhotos = new HashSet<>();

        for (PhotoDTO photo : photosCollection) {
            if (photo.getType().equals(type)) {
                matchedPhotos.add(photo);
            }
        }

        return matchedPhotos;
    }

    public Set<PhotoDTO> fetchByLocation(LocationDTO location) throws Exception {
        return null;
    }

}