package com.photolocos.enterprise.controller;

import com.photolocos.enterprise.dto.PhotoDTO;
import com.photolocos.enterprise.service.IPhotoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

@Controller
public class PhotoLocosController {

    @Autowired
    private IPhotoService photoService;

    Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * Handle the "/" endpoint
     * @return index.html
     */
    @RequestMapping("/")
    public String main() {
        return "index";
    }

    @PostMapping(value="/upload")
    public ModelAndView savePhoto(@RequestParam("image") MultipartFile image, PhotoDTO photo) {
        log.debug("Request made to save a photo.");
        ModelAndView modelAndView = new ModelAndView();

        try {
            photoService.savePhoto(photo, image);
            modelAndView.setViewName("success");
            log.info("Saved a photo.");
        } catch (Exception e) {
            log.error("Error occurred while attempting to save a photo, message: " + e.getMessage(), e);
            modelAndView.setViewName("error");
            return modelAndView;
        }

        modelAndView.addObject("photoDTO", photo);
        return modelAndView;

    }

    @GetMapping("/photos")
    @ResponseBody
    public Set<PhotoDTO> fetchAllPhotos() {
        log.debug("Request made to retrieve all photos.");
        Set<PhotoDTO> photos = null;
        
        try {
            photos = photoService.fetchAll();
            log.info("Retrieved all photos.");
        } catch (Exception e) {
            log.error("Error occurred while attempting to retrieve all photos, message: " + e.getMessage(), e);
        }
        return photos;
    }

    @GetMapping("/photosByTag/{tag}/")
    public ModelAndView photosByTag(@PathVariable("tag") String tag) {
        log.debug("Request made to retrieve photos by tag.");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        Set<PhotoDTO> photos = null;
        try {
            photos = photoService.fetchByTag(tag);
            log.info("Fetched photos by tag.");
        } catch (Exception e) {
            log.error("Error occurred while attempting to retrieve photos by tag, message: " + e.getMessage(), e);
        }
        modelAndView.addObject("photos", photos);
        return  modelAndView;
    }

    @GetMapping("/photosByCity/{state}/{city}/")
    public ModelAndView photosByCity(@PathVariable("state") String state, @PathVariable("city") String city) {
        log.debug("Request made to retrieve photos by city.");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        Set<PhotoDTO> photos = null;
        try {
            photos = photoService.fetchPhotoByStateAndCity(state, city);
            log.info("Fetched photos by state and city.");
        } catch (Exception e) {
            log.error("Error occurred while attempting to retrieve photos by city, message: " + e.getMessage(), e);
        }
        modelAndView.addObject("photos", photos);
        return  modelAndView;
    }

    @GetMapping("/photoByCity/{area}/")
    public ModelAndView photoByArea(@PathVariable("area") String area) {
        log.debug("Request made to retrieve photos by area.");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        Set<PhotoDTO> photos = null;
        try {
            photos = photoService.fetchByArea(area);
            log.info("Fetched photos by area.");
        } catch (Exception e) {
            log.error("Error occurred while attempting to retrieve photos by area, message: " + e.getMessage(), e);
        }
        modelAndView.addObject("photos", photos);
        return  modelAndView;
    }
}
