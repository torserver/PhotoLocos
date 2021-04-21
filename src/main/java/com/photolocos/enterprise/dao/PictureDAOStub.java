package com.photolocos.enterprise.dao;

import com.photolocos.enterprise.dto.LocationDTO;
import com.photolocos.enterprise.dto.PhotoDTO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

/**
 * @author Paramjyot Sandhu
 *
 * PicDAO class to handle Photo related operations
 */

@Repository()
@Profile("test")
public class PictureDAOStub implements IPhotoDAO {

    Map<Integer, PhotoDTO> photos = new HashMap<>();

    @Override
    public Set<PhotoDTO> fetchAll() {
        return new HashSet<>(photos.values());
    }

    @Override
    public void save(PhotoDTO photo) {
        photo.setPhotoId(photos.size());
        photos.put(photo.getPhotoId(), photo);
    }

    @Override
    public void saveImage(MultipartFile image) throws IOException {

    }

    @Override
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

    @Override
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

    @Override
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

    @Override
    public Set<PhotoDTO> fetchByLocation(LocationDTO location) {
        List<PhotoDTO> photosCollection = new ArrayList<>(photos.values());
        Set<PhotoDTO> matchedPhotos = new HashSet<>();

        for (PhotoDTO photo : photosCollection) {
            LocationDTO photoLocation = photo.getLocation();
            if (photoLocation != null && photoLocation.equals(location)) {
                matchedPhotos.add(photo);
            }
        }
        return matchedPhotos;
    }


}
