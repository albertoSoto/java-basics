package com.learningjava.rest.spring.front.configuration;

import com.learningjava.rest.spring.front.SecureApplication;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
/**
 * com.learningjava.rest.spring.front.configuration
 * Class
 * By berto. 12/02/2018
 */
public class RestSpringSecureInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
 
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { SecureApplication.class };
    }
  
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }
  
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
    
    @Override
    protected Filter[] getServletFilters() {
    	Filter [] singleton = { new CORSFilter()};
    	return singleton;
    }
 
}