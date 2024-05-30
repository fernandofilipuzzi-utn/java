package com.ejemplos.seguridad2.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/sec")
public class TController {

    @PostMapping(value="/tcont")
    public String welcome(){
        return "welcome form secure endpoint";
    }

}