package com.monolitica.crud.dto;

import java.io.Serializable;

public class RolDTO implements Serializable {
    private static final long serialVersionUID = 324234324123524121L;

    private Integer id;
    private String name;

    public RolDTO(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    } 

    @Override
    public String toString() {
        return "CourseDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
