package com.photolocos.enterprise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PhotoLocosController {

    /**
     * Handle the "/" endpoint
     * @return start.html
     */
    @RequestMapping("/")
    public String index() {
        return "start";
    }

}
