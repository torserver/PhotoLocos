package com.photolocos.enterprise.dao;

import com.photolocos.enterprise.dto.LocationDTO;
import com.photolocos.enterprise.dto.PhotoDTO;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Profile("!test")
public interface LocationRepository extends CrudRepository<LocationDTO, Integer> {

    List<LocationDTO> findByCity(String city) throws Exception;

    List<LocationDTO> findByLongitude(String longitude) throws Exception;

    List<LocationDTO> findByLatitude(String latitude) throws Exception;

    LocationDTO findByLatitudeAndLongitude(String latitude, String longitude) throws Exception;

    LocationDTO findByLocationId(int locationId) throws Exception;

    LocationDTO findByStateAndCity(String state, String city) throws Exception;

    LocationDTO findByArea(String area) throws Exception;
}
