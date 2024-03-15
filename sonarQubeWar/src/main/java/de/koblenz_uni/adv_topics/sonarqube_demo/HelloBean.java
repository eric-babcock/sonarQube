package de.koblenz_uni.adv_topics.sonarqube_demo;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named

public class HelloBean {

	public String getMessage() {
		return "Hello, Course!";
	}

}
