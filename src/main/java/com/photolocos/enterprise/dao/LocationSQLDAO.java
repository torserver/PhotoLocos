package com.photolocos.enterprise.dao;

import com.photolocos.enterprise.dto.LocationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("locationDAO")
@Profile("dev")
public class LocationSQLDAO implements ILocationDAO {

    @Autowired
    LocationRepository locationRepository;

    @Override
    public void createEntry(LocationDTO locationDTO) {
        LocationDTO createdLocation = locationRepository.save(locationDTO);
    }

    @Override
    public LocationDTO fetchUserLocation() {
        LocationDTO byStateAndCity = new LocationDTO();
        byStateAndCity = locationRepository.findByStateAndCity("Ohio", "Cincinnati");

        return byStateAndCity;
    }

    @Override
    public LocationDTO fetchByCoordinates(String longitude, String latitude) {
        LocationDTO byLatitudeAndLongitude = new LocationDTO();
        byLatitudeAndLongitude = locationRepository.findByLatitudeAndLongitude(latitude, longitude);

        return byLatitudeAndLongitude;
    }

    @Override
    public LocationDTO fetchByArea(String state, String city) {
        LocationDTO byStateAndCity = new LocationDTO();
        byStateAndCity = locationRepository.findByStateAndCity(state, city);

        return byStateAndCity;
    }

    @Override
    public List<LocationDTO> fetchByDescription(String description) {
        return null;
    }
}
