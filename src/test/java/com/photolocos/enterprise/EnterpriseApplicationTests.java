package com.photolocos.enterprise;

import com.photolocos.enterprise.dao.ILocationDAO;
import com.photolocos.enterprise.dao.IPhotoDAO;
import com.photolocos.enterprise.dao.PhotoDAO;
import com.photolocos.enterprise.dto.PhotoDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.photolocos.enterprise.dao.PhotoDAO.*;

@SpringBootTest
class EnterpriseApplicationTests {

    private PhotoDTO photo = new PhotoDTO();

    @MockBean
    private ILocationDAO locationDAO;
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
        Mockito.when(photoDAO.fetchByTag(tags)).thenReturn((Set<PhotoDTO>) photo);
    }

    private void givenPhotoDataAreAvailable() {
        //Mockito.when(PhotoDAO.save(photo)).thenReturn(photo);
        /**
         * Save method not yet created in PhotoDAO
         * */
        photoDAO.save(photo);
    }

    private void whenSearchPhotoWithTagRiver() {
        String[] tag = {"river"};
        photo = (PhotoDTO) photoDAO.fetchByTag(tag);
    }

    private PhotoDTO thenReturnPhotosWithTagRiver() {
        return photo;
    }


}
