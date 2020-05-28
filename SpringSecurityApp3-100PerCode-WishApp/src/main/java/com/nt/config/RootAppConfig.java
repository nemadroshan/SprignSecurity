package com.nt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {PersistanceConfig.class , SecurityConfig.class})
public class RootAppConfig {
	//this class is alternate to applicationContext.xml
}
