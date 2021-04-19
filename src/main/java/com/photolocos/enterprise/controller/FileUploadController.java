package com.photolocos.enterprise.controller;

import com.photolocos.enterprise.dao.ILocationDAO;
import com.photolocos.enterprise.dao.IPhotoDAO;
import com.photolocos.enterprise.dao.PhotoDAO;
import com.photolocos.enterprise.dto.LocationDTO;
import com.photolocos.enterprise.dto.PhotoDTO;
import com.photolocos.enterprise.service.IPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Slf4j
@RestController
public class FileUploadController {

    @Autowired
    private IPhotoService photoService;

    @Autowired
    private ILocationDAO locationDAO;


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
    @RequestMapping("/upload")
    public ModelAndView upload(LocationDTO location, @RequestParam("file") MultipartFile file, Model model) {
        log.info("tried to uploaded file " + file.getOriginalFilename());
        String returnValue = "start";
        ModelAndView modelAndView = new ModelAndView();
        try {
            locationDAO.createEntry(location);
        } catch (Exception e) {
            e.printStackTrace();
            modelAndView.setViewName("error");
            return modelAndView;
        }

        PhotoDTO photo = new PhotoDTO();
        try {
            photo.setFileName(file.getOriginalFilename());
            photo.setFilePath("/photo/");
            photo.setLocation(location);
            model.addAttribute("photo", photo);
            photoService.saveImage(file, photo);
            model.addAttribute("location", location);
            modelAndView.setViewName("success");
        } catch (IOException e) {
            e.printStackTrace();
            modelAndView.setViewName("error");
            return modelAndView;
        }
        modelAndView.addObject("photo", photo);
        modelAndView.addObject("location", location);

        return modelAndView;
    }
}