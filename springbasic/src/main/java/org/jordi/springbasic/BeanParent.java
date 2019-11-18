package org.jordi.springbasic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanParent {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BeanChild getBeanchild() {
        return beanchild;
    }


    @Autowired
    private BeanChild beanchild;
}
