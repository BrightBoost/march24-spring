package com.demo.ilionx.demo.sub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VoorbeeldController {

    private String heleRareDependency;

    @Autowired
    public VoorbeeldController(String heleRareDependency) {
        this.heleRareDependency = heleRareDependency;
    }
}
