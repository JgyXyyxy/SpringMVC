package com.sdu.spittr.controller;

import com.sdu.spittr.bean.Spittle;
import com.sdu.spittr.service.SpittleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by J on 2017/1/10.
 */
@Controller
@RequestMapping("/spittles")
public class SpittleController {

    @Autowired
    @Qualifier("spittleService")
    private SpittleService spittleService;
    private static final String MAX_LONG_AS_STRING = "9223372036854775807";
    //  Long.toString(Long.MAX_VALUE);

    public SpittleController(SpittleService spittleService){
        this.spittleService = spittleService;
    }


//    @RequestMapping(method = RequestMethod.GET)
//    public String spittles(Model model){
////      model(key,value)
//        model.addAttribute("spittleList",spittleService.findSpittles(Long.MAX_VALUE,20));
////      逻辑视图名
//        return "spittles";
//    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(
            @RequestParam(value="count",defaultValue = "20") int count) {
//      返回对象和集合时，根据类型判断，模型的key为"spittleList",逻辑视图名根据请求"/spittles"定为spittles

        List<Spittle> spittleList = spittleService.findRecent(count);
        return spittleList;

    }

    @RequestMapping(value ="/show",method = RequestMethod.GET)
    public String showSpittle(@RequestParam("spittle_id") long spittleId,Model model){
        model.addAttribute(spittleService.findOne(spittleId));
        return "spittle";
    }

    @RequestMapping(value = "/{spittleId}",method = RequestMethod.GET)
    public String spittle(@PathVariable("spittleId") long spittleId, Model model){
        model.addAttribute("spittle",spittleService.findOne(spittleId));
        return "spittle";
    }

}
