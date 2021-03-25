package com.photolocos.enterprise.dao;

import com.photolocos.enterprise.dto.PhotoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Set;

@Repository("photoDAO")
public class PhotoSQLDAO implements IPhotoDAO {

    @Autowired
    PhotoRepository photoRepository;

    @Override
    public boolean createEntry(PhotoDTO photoDTO) throws Exception {
        return false;
    }

    @Override
    public Set<PhotoDTO> fetchByTag(String[] tags) {
        return null;
    }

    @Override
    public Set<PhotoDTO> fetchByRating(int rating) {
        return null;
    }

    @Override
    public Set<PhotoDTO> fetchByType(String type) {
        return null;
    }

    @Override
    public Map<Integer, PhotoDTO> fetchAll() {
        return null;
    }

    @Override
    public void save(PhotoDTO photo) {

    }

    @Override
    public Set<PhotoDTO> fetchByLocation(String location) {
        return null;
    }
}
