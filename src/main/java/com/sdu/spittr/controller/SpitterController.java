package com.sdu.spittr.controller;

import com.sdu.spittr.bean.Spitter;
import com.sdu.spittr.service.SpitterMapperService;
import com.sdu.spittr.service.SpitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by J on 2016/11/28.
 */


@RequestMapping("/spitter")
@Controller
public class SpitterController {

    @Autowired
    @Qualifier("spitterService")
    private SpitterService spitterService;

    @Autowired
    SpitterMapperService spitterMapperService;

    public SpitterController(SpitterService spitterService){
        this.spitterService = spitterService;
    }

    @RequestMapping(value = "/register",method = GET)
    public String showRegisterationFrom(Model model){
       model.addAttribute("spitter",new Spitter());
        return "registerForm";
    }

    @RequestMapping(value = "/register",method = POST)
    public String processRegistration (@Valid Spitter spitter, Errors errors){
        if(errors.hasErrors())
            return "registerForm";
        spitterService.save(spitter);
        return "redirect:/spitter/"+spitter.getUsername();
    }

    @RequestMapping(value = "/{username}",method = GET)
    public String showSpitterProfile(@PathVariable(value = "username") String username, Model model){
//        Spitter spitter = spitterService.findByUsername(username);
        Spitter spitter = spitterMapperService.getUserByUsername(username);
        model.addAttribute(spitter);
        return "profile";
    }
}
