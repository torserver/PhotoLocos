package com.photolocos.enterprise;

import com.photolocos.enterprise.dao.ILocationDAO;
import com.photolocos.enterprise.dao.IPhotoDAO;
import com.photolocos.enterprise.dto.Photo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.Set;

@SpringBootTest
class EnterpriseApplicationTests {

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
        Photo photo = new Photo();
        photo.setLocation("Ohio");
        photoDAO.createEntry(photo);
    }

    private Set<Photo> userSearchesLocation() {
        return photoDAO.fetchByLocation("Ohio");
    }

    private void returnsPhotoResults(Set<Photo> results) {
        Assert.notNull(results, "Photo search results returned null");
        Assert.notEmpty(results, "Photo search results returned empty set.");

        boolean locationMatches = true;
        for(Photo photo: results){
            if(!photo.getLocation().equals("Ohio")){
                locationMatches = false;
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
        Photo photo = new Photo();
        photo.setTags(new String[]{"river"});

        photoDAO.createEntry(photo);
    }

    private Set<Photo> whenSearchPhotoWithTagRiver() {
        return photoDAO.fetchByTag(new String[]{"river"});
    }

    private void thenReturnPhotosWithTagRiver(Set<Photo> results) {
        Assert.notNull(results, "Photo search results returned null");
        Assert.notEmpty(results, "Photo search results returned empty set.");

        boolean photosMatch = true;
        for(Photo photo: results){
            if(!Arrays.asList(photo.getTags()).contains("river")){
                photosMatch = false;
            }
        }

        Assert.isTrue(photosMatch, "Photo search returned an incorrect result set.");
    }


}
