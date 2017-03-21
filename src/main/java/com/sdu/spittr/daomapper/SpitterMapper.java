package com.sdu.spittr.daomapper;

import com.sdu.spittr.bean.Spitter;
import org.springframework.stereotype.Repository;

/**
 * Created by J on 2017/3/12.
 */

@Repository
public interface SpitterMapper {

    Spitter getUserByUsername(String username);

    Spitter getUserById(int id);

}
