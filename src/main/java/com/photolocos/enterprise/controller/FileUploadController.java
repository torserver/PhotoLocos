package com.photolocos.enterprise.controller;

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
    public void upload(@RequestParam("file") MultipartFile file) {
        log.info("uploaded file " + file.getOriginalFilename());
    }
}
