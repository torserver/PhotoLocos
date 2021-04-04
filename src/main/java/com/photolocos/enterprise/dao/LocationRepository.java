package com.photolocos.enterprise.dao;

import com.photolocos.enterprise.dto.LocationDTO;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Profile("!test")
public interface LocationRepository extends CrudRepository<LocationDTO, Integer> {

    List<LocationDTO> findByCity(String city) throws Exception;

    List<LocationDTO> findByLongitude(double longitude) throws Exception;

    List<LocationDTO> findByLatitude(double latitude) throws Exception;

    LocationDTO findByLatitudeAndLongitude(double latitude, double longitude) throws Exception;

    LocationDTO findByid(int id) throws Exception;

    LocationDTO findByStateAndCity(String state, String city) throws Exception;

}
