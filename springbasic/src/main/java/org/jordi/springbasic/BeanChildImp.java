package org.jordi.springbasic;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component

//@Service
public class BeanChildImp implements BeanChild {
    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    private String id;
    @Override
    @Cacheable("message")
    public String getMessage(){
        return "MESSAGE";
    }

}
