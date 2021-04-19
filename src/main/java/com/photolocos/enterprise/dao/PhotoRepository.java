package com.photolocos.enterprise.dao;

import com.photolocos.enterprise.dto.LocationDTO;
import com.photolocos.enterprise.dto.PhotoDTO;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Profile("!test")
public interface PhotoRepository extends CrudRepository<PhotoDTO, Integer> {

    List<PhotoDTO> findByTagsContaining(String tags) throws Exception;

    List<PhotoDTO> findByRating(int rating) throws Exception;

    List<PhotoDTO> findByType(String type) throws Exception;

    List<PhotoDTO> findByLocation(LocationDTO location) throws Exception;


}
