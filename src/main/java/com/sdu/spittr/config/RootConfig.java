package com.sdu.spittr.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by J on 2017/1/3.
 * Spring-config.xml
 */

@Configuration
@ComponentScan(
        basePackages = {"com.sdu.spittr"},
        excludeFilters =
                {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = EnableWebMvc.class)}
)
public class RootConfig {
}


