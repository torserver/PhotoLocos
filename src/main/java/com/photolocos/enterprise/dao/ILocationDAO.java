package com.photolocos.enterprise.dao;

import com.photolocos.enterprise.dto.Location;

import java.util.List;

/**
 * @author Paramjyot Sandhu (sandhups@mail.uc.edu)
 *
 * LocationDAO interface declaring required operations
 */
public interface ILocationDAO {

    /**
     * This method is used to create an entry in Database, if there isn't one already
     *
     * @param location The Location {@link Location} object to be saved
     * @return True if entry was successfully created, false in any other scenario
     * @throws Exception Any exception that could occur as a result of failure to create a entry
     * in database or other preferred storage
     */
    boolean createEntry(Location location);

    /**
     * This method tries to get user's current approximate geographical location
     * and create an object from it
     *
     * @return Location object for the current user location
     */
    Location fetchUserLocation();

    /**
     * This method will return Location Object {@link Location} based on Co-ordinates
     *
     * @param longitude the longitude of the location that the user wants to get more info about photography locations
     * @param latitude  the latitude of the location that the user wants to get more info about photography locations
     * @return the location object matching the co-ordinates, if not found return null
     */
    Location fetchByCoordinates(String longitude, String latitude);

    /**
     * This method will return Location Object {@link Location} based on a State and a City
     *
     * @param state the State that the user wants to get more info about photography locations
     * @param city  the City that the user wants to get more info about photography locations
     * @return the location object found in specific state and city
     */
    Location fetchByArea(String state, String city);

    /**
     * This method will return Location Objects {@link Location} based on a description
     * that users describes of what they are looking for
     * @param description A string or array of string that explains most components of location e.g. Snow Mountains, Salt Lakes, etc.
     * @return a list of location objects matching the description of a location
     */
    List<Location> fetchByDescription(String description);
}
