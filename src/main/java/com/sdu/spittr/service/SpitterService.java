package com.sdu.spittr.service;

import com.sdu.spittr.bean.Spitter;

import java.util.List;

/**
 * Created by J on 2017/1/11.
 */


public interface SpitterService {

    long count();

    Spitter save(Spitter spitter);

    Spitter findOne(long id);

    Spitter findByUsername(String username);

    List<Spitter> findAll();
}
