package com.demo.ilionx.demo.donttrythisathome;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class SessionManagerService {
    public void whoAmI() {
        System.out.println(hashCode());
    }
}
