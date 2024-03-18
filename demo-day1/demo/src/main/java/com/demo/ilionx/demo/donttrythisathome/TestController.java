package com.demo.ilionx.demo.donttrythisathome;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    ApplicationContext ac;
    public TestController(ApplicationContext ac) {
        this.ac = ac;
    }

    @GetMapping("request")
    public void doRequest() {
        ac.getBean(RequestManagerService.class).whoAmI();
    }

    @GetMapping("session")
    public void doSession() {
        ac.getBean(SessionManagerService.class).whoAmI();
    }
}
