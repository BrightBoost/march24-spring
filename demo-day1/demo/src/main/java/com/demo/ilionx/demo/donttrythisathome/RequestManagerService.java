package com.demo.ilionx.demo.donttrythisathome;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class RequestManagerService {

    @Lookup
    public void whoAmI() {
        System.out.println(hashCode());
    }
}
