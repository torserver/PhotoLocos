package com.photolocos.enterprise;

import com.photolocos.enterprise.dao.ILocationDAO;
import com.photolocos.enterprise.dao.IPhotoDAO;
import com.photolocos.enterprise.dto.Photo;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
class EnterpriseApplicationTests {

    private Photo photo = new Photo();
    private HashSet<Photo> photoSet = new HashSet<Photo>(Arrays.asList(new Photo[]{photo}));

    @MockBean
    private ILocationDAO locationDAO;
    @MockBean
    private IPhotoDAO photoDAO;


    @Test
    void contextLoads() {
    }

    @Test
    void fetchPhotoByTag_returnsRiverForTagRiver() throws Exception {
        givenPhotoDataAreAvailable();
        whenPhotoAddedWithTagRiver();
        whenSearchPhotoWithTagRiver();
        thenReturnPhotosWithTagRiver();
    }

    private void whenPhotoAddedWithTagRiver() {
        String[] tags = {"river"};
        photo.setTags(tags);

        Mockito.when(photoDAO.fetchByTag(tags)).thenReturn(photoSet);
    }

    private void givenPhotoDataAreAvailable() throws Exception {
        Mockito.when(photoDAO.createEntry(photo)).thenReturn(true);

        photoDAO.createEntry(photo);
    }

    private void whenSearchPhotoWithTagRiver() {
        String[] tag = {"river"};

        Mockito.when(photoDAO.fetchByTag(tag)).thenReturn(photoSet);

        Set<Photo> photos = photoDAO.fetchByTag(tag);
    }

    private Photo thenReturnPhotosWithTagRiver() {
        return photo;
    }


}
