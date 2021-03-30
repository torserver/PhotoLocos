package com.photolocos.enterprise;

import com.photolocos.enterprise.dao.ILocationDAO;
import com.photolocos.enterprise.dao.IPhotoDAO;
import com.photolocos.enterprise.dto.LocationDTO;
import com.photolocos.enterprise.dto.PhotoDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
class EnterpriseApplicationTests {
    private PhotoDTO photo = new PhotoDTO();

    @MockBean
    @Autowired
    private ILocationDAO locationDAO;
    @Autowired
    private IPhotoDAO photoDAO;


    @Test
    void contextLoads() {
    }

    @Test
    void userSearchesLocation_returnsPhotoResults() throws Exception {
        givenPhotoWithStateLocationExists();
        returnsPhotoResults(userSearchesLocation());
    }

    private void givenPhotoWithStateLocationExists() throws Exception {
        PhotoDTO photo = new PhotoDTO();
        LocationDTO location = new LocationDTO();
        location.setState("Ohio");
        location.setId(1);

        photo.setLocation(location);
        photoDAO.save(photo);
    }

    private Set<PhotoDTO> userSearchesLocation() {
        Set<PhotoDTO> photoDTOSet = new HashSet<>();
        photoDTOSet.add(photoDAO.fetchByLocation(1));
        return photoDTOSet;
    }

    private void returnsPhotoResults(Set<PhotoDTO> results) {
        Assert.notNull(results, "Photo search results returned null");
        Assert.notEmpty(results, "Photo search results returned empty set.");

        boolean locationMatches = true;
        for(PhotoDTO photo: results){
            if(!photo.getLocation().getState().equals("Ohio")){
                locationMatches = false;
                break;
            }
        }

        Assert.isTrue(locationMatches, "Photo search returned an incorrect result set.");
    }



    @Test
    void fetchPhotoByTag_returnsRiverForTagRiver() throws Exception {
        whenPhotoAddedWithTagRiver();
        thenReturnPhotosWithTagRiver(whenSearchPhotoWithTagRiver());
    }

    private void whenPhotoAddedWithTagRiver() throws Exception {
        PhotoDTO photo = new PhotoDTO();
        photo.setTags("river");
        photoDAO.save(photo);
    }

    private Set<PhotoDTO> whenSearchPhotoWithTagRiver() {
        return photoDAO.fetchByTag(new String[]{"river"});
    }

    private void thenReturnPhotosWithTagRiver(Set<PhotoDTO> results) {
        Assert.notNull(results, "Photo search results returned null");
        Assert.notEmpty(results, "Photo search results returned empty set.");

        boolean photosMatch = true;
        for (PhotoDTO photo : results) {
            if (!Arrays.asList(photo.getTags()).contains("river")) {
                photosMatch = false;
            }
        }

        Assert.isTrue(photosMatch, "Photo search returned an incorrect result set.");
    }
}
