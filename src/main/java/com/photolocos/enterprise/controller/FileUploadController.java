package com.photolocos.enterprise.controller;

import com.photolocos.enterprise.dao.PhotoDAO;
import com.photolocos.enterprise.dto.PhotoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/upload")
public class FileUploadController {

    @Autowired
    private PhotoDAO photoDAO;

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
    public String upload(@RequestParam("file") MultipartFile file, Model model) {
        log.info("tried to uploaded file " + file.getOriginalFilename());
        String returnValue = "start";

        try {
            photoDAO.saveImage(file);
            PhotoDTO photo = new PhotoDTO();
            model.addAttribute("photo", photo);
            returnValue = "start";
        } catch (Exception e) {
            returnValue = "error";
        }
        return returnValue;
    }
}