package com.sdu.spittr.bean;

/**
 * Created by J on 2017/2/20.
 */
public class DemoObj {
    private String name;
    private Long id;

    public DemoObj() {
        super();
    }

    public DemoObj(String name, Long id) {
        super();
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
