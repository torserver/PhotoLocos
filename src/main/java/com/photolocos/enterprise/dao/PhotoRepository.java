package com.photolocos.enterprise.dao;

import com.photolocos.enterprise.dto.PhotoDTO;
import org.springframework.data.repository.CrudRepository;

public interface PhotoRepository extends CrudRepository<PhotoDTO, Integer> {
}
