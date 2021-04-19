package com.photolocos.enterprise.controller;

import com.photolocos.enterprise.dto.LocationDTO;
import com.photolocos.enterprise.dto.PhotoDTO;
import com.photolocos.enterprise.service.IPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class FileUploadController {

    @Autowired
    private IPhotoService photoService;

    /**
     * What do we want to do when the file is uploaded?
     * Currently, just prints the original file name and does nothing.
     * A PHP script and be used to upload this to a server, though.
     * If someone has a better idea, please use it.
     *
     * Logic to decide what happens on file upload.
     *
     * @param file
     */
    @PostMapping
    public String upload(PhotoDTO photo, LocationDTO locationDTO, @RequestParam("file") MultipartFile file, Model model) {
        log.info("tried to uploaded file " + file.getOriginalFilename());
        String returnValue = "start";

        try {
            photo.setLocation(locationDTO);
            photoService.savePhoto(photo, file);
            model.addAttribute("photo", photo);
            returnValue = "success";
        } catch (Exception e) {
            returnValue = "error";
        }

        return returnValue;
    }
}