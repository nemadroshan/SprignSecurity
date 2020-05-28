package com.nt.initializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.nt.config.RootAppConfig;
import com.nt.config.WebMVCConfig;

public class MyWebAppIntializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	//this class is alternate to web.xml
	
	@Override
	public Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] { RootAppConfig.class };
	}

	@Override
	public Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] { WebMVCConfig.class };
	}

	@Override
	public String[] getServletMappings() {
		return new String[] { "*.htm" };
	}

}
