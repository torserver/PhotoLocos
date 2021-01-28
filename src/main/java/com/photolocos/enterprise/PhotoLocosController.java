package com.photolocos.enterprise;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PhotoLocosController {

    @RequestMapping
    public String index() {
        return "start";
    }

}
