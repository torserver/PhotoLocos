package com.photolocos.enterprise.dao;

import com.photolocos.enterprise.dto.LocationDTO;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface LocationRepository extends CrudRepository<LocationDTO, Integer> {

    List<LocationDTO> findByCity(String city);

    List<LocationDTO> findByLongitude(String longitude);

    List<LocationDTO> findByLatitude(String latitude);

    LocationDTO findByLatitudeAndLongitude(String latitude, String longitude);

    LocationDTO findByid(int id);

    LocationDTO findByStateAndCity(String state, String city);

}
