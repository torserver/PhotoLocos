package com.photolocos.enterprise.dao;

import com.photolocos.enterprise.dto.PhotoDTO;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * @author Paramjyot Sandhu (sandhups@mail.uc.edu)
 *
 * PhotoDAO class to handle Photo related operations
 */
@Component
public class PhotoDAO implements IPhotoDAO {
    Map<Integer, PhotoDTO> photos = new HashMap<>();
    private Set<PhotoDTO> matchedPhotos = new HashSet<>();
    private List<PhotoDTO> photosCollection = new ArrayList<>(photos.values());

    @Override
    public boolean createEntry(PhotoDTO photoDTO) {
        photos.put(photoDTO.getPhotoId(), photoDTO);
        if (photos.containsKey(photoDTO.getPhotoId())) return true;
        return false;
    }

    @Override
    public Set<PhotoDTO> fetchByTag(List<String> tags) {
        for (PhotoDTO photo : photosCollection) {
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
    public Set<PhotoDTO> fetchByRating(int rating) {
        for (PhotoDTO photo : photosCollection) {
                if (photo.getRating() == rating) {
                    matchedPhotos.add(photo);
                }
        }

        return matchedPhotos;
    }

    @Override
    public Set<PhotoDTO> fetchByType(String type) {
        for (PhotoDTO photo : photosCollection) {
            if (photo.getType().equals(type)) {
                matchedPhotos.add(photo);
            }
        }

        return matchedPhotos;
    }

    @Override
    public Map<Integer, PhotoDTO> fetchAll() {
        return photos;
    }
}
