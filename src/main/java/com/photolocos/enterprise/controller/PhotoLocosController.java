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
        ModelAndView modelAndView = new ModelAndView();

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
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        Set<PhotoDTO> photos = photoService.fetchByTag(tag);
        modelAndView.addObject("photos", photos);
        return  modelAndView;
    }

    @GetMapping("/photosByCity/{city}/")
    public ModelAndView photosByCity(@PathVariable("city") String city) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        Set<PhotoDTO> photos = photoService.fetchPhotoByCity(city);
        modelAndView.addObject("photos", photos);
        return  modelAndView;
    }

    @GetMapping("/photoByCity/{area}/")
    public ModelAndView photoByArea(@PathVariable("area") String area) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        Set<PhotoDTO> photos = photoService.fetchByArea(area);
        modelAndView.addObject("photos", photos);
        return  modelAndView;
    }


}
