package com.sdu.spittr.service;

import com.sdu.spittr.bean.Spittle;

import java.util.List;

/**
 * Created by J on 2017/1/10.
 */
public interface SpittleService{


    List<Spittle> findRecent();

    List<Spittle> findRecent(int count);

    Spittle findOne(long id);

    Spittle save(Spittle spittle);

    List<Spittle> findBySpitterId(long spitterId);

    void delete(long id);
}