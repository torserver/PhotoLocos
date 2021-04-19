package com.photolocos.enterprise.dao;

import com.photolocos.enterprise.dto.LocationDTO;
import com.photolocos.enterprise.dto.PhotoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile("dev")
public class LocationSQLDAO implements ILocationDAO {

    @Autowired
    LocationRepository locationRepository;

    @Override
    public void createEntry(LocationDTO locationDTO) {
        LocationDTO createdLocation = locationRepository.save(locationDTO);
    }

    @Override
    public LocationDTO fetchUserLocation() throws Exception {
        return locationRepository.findByStateAndCity("Ohio", "Cincinnati");
    }

    @Override
    public LocationDTO fetchByCoordinates(String longitude, String latitude) throws Exception {
        return locationRepository.findByLatitudeAndLongitude(latitude, longitude);
    }

    @Override
    public LocationDTO fetchByStateAndCity(String state, String city) throws Exception {
        return locationRepository.findByStateAndCity(state, city);
    }

    @Override
    public List<LocationDTO> fetchByDescription(String description) {
        return null;
    }

    @Override
    public LocationDTO fetchByArea(String area) throws Exception {
        LocationDTO byArea = locationRepository.findByArea(area);

        return byArea;
    }
}
