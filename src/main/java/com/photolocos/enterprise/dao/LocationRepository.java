package com.photolocos.enterprise.dao;

import com.photolocos.enterprise.dto.LocationDTO;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<LocationDTO, Integer> {
}
