package com.sdu.spittr.service;

import com.sdu.spittr.bean.Spitter;
import com.sdu.spittr.daomapper.SpitterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by J on 2017/3/12.
 */
@Service
public class SpitterMapperServiceImp implements SpitterMapperService {

    @Autowired
    SpitterMapper spitterMapper;

    @Override
    public Spitter getUserByUsername(String username) {
        return spitterMapper.getUserByUsername(username);
    }

    @Override
    public Spitter getUserById(int id) {
        return spitterMapper.getUserById(id);
    }
}
