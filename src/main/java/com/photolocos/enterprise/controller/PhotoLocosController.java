package com.photolocos.enterprise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PhotoLocosController {

    /**
     * Handle the "/" endpoint
     * @return index.html
     */
    public String main() {
        return "index";
    }

}
