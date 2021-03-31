package com.photolocos.enterprise.dao;

import com.photolocos.enterprise.dto.PhotoDTO;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Profile("!test")
public interface PhotoRepository extends CrudRepository<PhotoDTO, Integer> {

    List<PhotoDTO> findByTagsContaining(String tags);

    List<PhotoDTO> findByRating(int rating);

    List<PhotoDTO> findByType(String type);

    List<PhotoDTO> findByLocation(int location);

}
