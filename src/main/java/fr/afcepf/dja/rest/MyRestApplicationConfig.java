package fr.afcepf.dja.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/services/rest")//milieu des URLs
public class MyRestApplicationConfig extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		final Set<Class<?>> classes = new HashSet<Class<?>>();
		// register root resource(s): 
		//classes.add(XyServiceRest.class);
		classes.add(MySimpleRestService.class);
		return classes;
	}
}
