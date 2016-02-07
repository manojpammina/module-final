package com.org.app;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/rrs")
public class AppConfig extends ResourceConfig {
	public AppConfig(){
		packages("com.org");
	}

}
