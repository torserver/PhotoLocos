package com.photolocos.enterprise.controller;

import com.photolocos.enterprise.dto.PhotoDTO;
import com.photolocos.enterprise.service.IPhotoService;
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
    private ModelAndView modelAndView = new ModelAndView();

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
        try {
            photoService.savePhoto(photo, image);
            modelAndView.setViewName("success");
        } catch (Exception e) {
            e.printStackTrace();
            modelAndView.setViewName("error");
            return modelAndView;
        }

        modelAndView.addObject("photoDTO", photo);
        return modelAndView;
    }

    @GetMapping("/photos")
    @ResponseBody
    public Set<PhotoDTO> fetchAllSpecimens() {
        return photoService.fetchAll();
    }

    @GetMapping("/photosByTag/{tag}/")
    public ModelAndView photosByTag(@PathVariable("tag") String tag) {
        modelAndView.setViewName("index");
        Set<PhotoDTO> photos = photoService.fetchByTag(tag);
        modelAndView.addObject("photos", photos);
        return  modelAndView;
    }

    @GetMapping("/photosByCity/{city}/")
    public ModelAndView photosByCity(@PathVariable("city") String city) {
        modelAndView.setViewName("index");
        Set<PhotoDTO> photos = photoService.fetchPhotoByCity(city);
        modelAndView.addObject("photos", photos);
        return  modelAndView;
    }

    @GetMapping("/photoByCity/{area}/")
    public ModelAndView photoByArea(@PathVariable("area") String area) {
        modelAndView.setViewName("index");
        PhotoDTO photo = photoService.fetchByLocation(area);
        modelAndView.addObject("photo", photo);
        return  modelAndView;
    }
}
