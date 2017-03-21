package com.sdu.spittr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

/**
 * Created by J on 2017/1/3.
 */
public class
SpitterWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getServletConfigClasses() { //定义DispatcherServlet应用上下文中的beans
        return new Class<?>[] {WebConfig.class};
    }

    @Override
    protected Class<?>[] getRootConfigClasses()
    { //定义ContextLoaderListener应用上下文中的beans
        return new Class<?>[] {
                RootConfig.class,DataConfig.class,MongoConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(new MultipartConfigElement("/tmp/spittr/uploads",
                2097152,4194304,0));
    }
}
