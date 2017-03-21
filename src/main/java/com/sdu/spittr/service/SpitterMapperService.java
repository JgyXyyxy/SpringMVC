package com.sdu.spittr.service;

import com.sdu.spittr.bean.Spitter;

/**
 * Created by J on 2017/3/12.
 */
public interface SpitterMapperService {

    Spitter getUserByUsername(String username);
    Spitter getUserById(int id);
}
