package com.photolocos.enterprise.dao;

import com.photolocos.enterprise.dto.PhotoDTO;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface PhotoRepository extends CrudRepository<PhotoDTO, Integer> {

    List<PhotoDTO> findByTagsContaining(String tags);

    List<PhotoDTO> findByRating(int rating);

    List<PhotoDTO> findByType(String type);

    PhotoDTO findByLocation(int location);

}
