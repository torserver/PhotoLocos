package com.photolocos.enterprise.dao;

import com.photolocos.enterprise.dto.LocationDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Paramjyot Sandhu (sandhups@mail.uc.edu)
 *
 * LocationDAO class to handle Location related operations
 */
@Component
public class LocationDAO implements ILocationDAO {

    private Map<Integer, LocationDTO> locations = new HashMap<>();

    @Override
    public boolean createEntry(LocationDTO locationDTO) {
        locations.put(locationDTO.getLocationId(), locationDTO);
        if (locations.containsKey(locationDTO.getLocationId())) return true;

        return false;
    }

    @Override
    public LocationDTO fetchUserLocation() {
        LocationDTO userLocation = new LocationDTO();
        userLocation.setLongitude("84.51");
        userLocation.setLatitude("39.10");
        userLocation.setCountry("USA");
        userLocation.setState("OH");
        userLocation.setCity("Cincinnati");
        userLocation.setArea("Sharon Woods, Downtown, Alms Park, Eden Park");
        userLocation.setDescription("Urban Area, Hills, Parks, Riverfront");
        userLocation.setLocationId(1);
        userLocation.setId(1);

        return userLocation;
    }

    @Override
    public LocationDTO fetchByCoordinates(String longitude, String latitude) {
        List<LocationDTO> locationsCollection = new ArrayList<>(locations.values());
        LocationDTO neededLocation = new LocationDTO();

        for (LocationDTO loc : locationsCollection) {
            if (loc.getLatitude().equals(latitude) && loc.getLongitude().equals(longitude)) {
                neededLocation = loc;
            }
        }
        return neededLocation;
    }

    @Override
    public LocationDTO fetchByArea(String state, String city) {
        List<LocationDTO> locationsCollection = new ArrayList<>(locations.values());
        LocationDTO neededLocation = new LocationDTO();

        for (LocationDTO loc : locationsCollection) {
            if (loc.getState().equals(state) && loc.getCity().equals(city)) {
                neededLocation = loc;
            }
        }

        return neededLocation;
    }

    @Override
    public List<LocationDTO> fetchByDescription(String description) {
        List<LocationDTO> locationsCollection = new ArrayList<>(locations.values());
        List<LocationDTO> matchingLocations = new ArrayList<>();

        for (LocationDTO loc : locationsCollection) {
            if (loc.getDescription().contains(description) ) {
                matchingLocations.add(loc);
            }
        }

        return matchingLocations;
    }
}
