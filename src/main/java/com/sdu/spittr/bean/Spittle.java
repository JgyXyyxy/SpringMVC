package com.sdu.spittr.bean;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.context.annotation.Bean;


import java.util.Date;

/**
 * Created by J on 2017/1/10.
 */
public class Spittle {

    private final Long id;
    private final String message;
    private final Date time;
    private final Spitter spitter;

    public Spittle(Long id, String message, Date time, Spitter spitter) {
        this.id = id;
        this.message = message;
        this.time = time;
        this.spitter = spitter;
    }

    public Spittle(String message, Date time) {
        this.id = null;
        this.message = message;
        this.time = time;
        this.spitter = null;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Date getTime() {
        return time;
    }

    public Spitter getSpitter() {
        return spitter;
    }

    @Override
    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this,that,"id","time");
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this,"id","time");
    }
}
