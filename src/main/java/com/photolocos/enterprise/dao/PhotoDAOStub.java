package com.photolocos.enterprise.dao;

import com.photolocos.enterprise.dto.Photo;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author Paramjyot Sandhu (sandhups@mail.uc.edu)
 *
 * PhotoDAO class to handle Photo related operations
 */
@Component
public class PhotoDAOStub implements IPhotoDAO {

    Map<Integer, Photo> photos = new HashMap<>();

    @Override
    public boolean createEntry(Photo photo) throws Exception {
        photos.put(photo.getPhotoId(), photo);
        if (photos.containsKey(photo.getPhotoId())) return true;
        return false;
    }

    @Override
    public Set<Photo> fetchByTag(String[] tags) {
        List<Photo> photosCollection = new ArrayList<>(photos.values());
        Set<Photo> matchedPhotos = new HashSet<>();

        for (Photo photo : photosCollection) {
            Set<String> tagsSet = new HashSet<>(Arrays.asList(photo.getTags()));
            for (String tag: tags) {
                if (tagsSet.contains(tag)) {
                    matchedPhotos.add(photo);
                    continue;
                }
            }
        }

        return matchedPhotos;
    }

    @Override
    public Set<Photo> fetchByRating(int rating) {
        List<Photo> photosCollection = new ArrayList<>(photos.values());
        Set<Photo> matchedPhotos = new HashSet<>();

        for (Photo photo : photosCollection) {
                if (photo.getRating() == rating) {
                    matchedPhotos.add(photo);
                }
        }

        return matchedPhotos;
    }

    @Override
    public Set<Photo> fetchByType(String type) {
        List<Photo> photosCollection = new ArrayList<>(photos.values());
        Set<Photo> matchedPhotos = new HashSet<>();

        for (Photo photo : photosCollection) {
            if (photo.getType().equals(type)) {
                matchedPhotos.add(photo);
            }
        }

        return matchedPhotos;
    }

    @Override
    public Map<Integer, Photo> fetchAll() {
        return photos;
    }

    @Override
    public Set<Photo> fetchByLocation(String location) {
        List<Photo> photosCollection = new ArrayList<>(photos.values());
        Set<Photo> matchedPhotos = new HashSet<>();

        for (Photo photo : photosCollection) {
            if (photo.getLocation().equals(location)) {
                matchedPhotos.add(photo);
            }
        }

        return matchedPhotos;
    }
}
