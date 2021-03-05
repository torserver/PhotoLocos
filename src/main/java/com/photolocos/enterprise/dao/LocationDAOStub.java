package com.photolocos.enterprise.dao;

import com.photolocos.enterprise.dto.Location;
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
public class LocationDAOStub implements ILocationDAO {

    private Map<Integer, Location> locations = new HashMap<>();

    @Override
    public boolean createEntry(Location location) {
        locations.put(location.getLocationId(), location);
        if (locations.containsKey(location.getLocationId())) return true;

        return false;
    }

    @Override
    public Location fetchUserLocation() {
        Location userLocation = new Location();
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
    public Location fetchByCoordinates(String longitude, String latitude) {
        List<Location> locationsCollection = new ArrayList<>(locations.values());
        Location neededLocation = new Location();

        for (Location loc : locationsCollection) {
            if (loc.getLatitude().equals(latitude) && loc.getLongitude().equals(longitude)) {
                neededLocation = loc;
            }
        }
        return neededLocation;
    }

    @Override
    public Location fetchByArea(String state, String city) {
        List<Location> locationsCollection = new ArrayList<>(locations.values());
        Location neededLocation = new Location();

        for (Location loc : locationsCollection) {
            if (loc.getState().equals(state) && loc.getCity().equals(city)) {
                neededLocation = loc;
            }
        }

        return neededLocation;
    }

    @Override
    public List<Location> fetchByDescription(String description) {
        List<Location> locationsCollection = new ArrayList<>(locations.values());
        List<Location> matchingLocations = new ArrayList<>();

        for (Location loc : locationsCollection) {
            if (loc.getDescription().contains(description) ) {
                matchingLocations.add(loc);
            }
        }

        return matchingLocations;
    }
}
