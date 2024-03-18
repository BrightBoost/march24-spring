package com.demo.ilionx.demo.donttrythisathome;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestTestController {

    private SessionManagerService sm;

    public TestTestController(SessionManagerService sm) {
        this.sm = sm;
    }

    @GetMapping("request2")
    public void doRequest() {
        getRequestManagerService().whoAmI();
    }

    @GetMapping("session2")
    public void doSession() {
        sm.whoAmI();
    }

    @Lookup
    public RequestManagerService getRequestManagerService() {
        return null;
    }
}
