package de.uni_koblenz.adv_topics.sonarqube;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
        
@Named
@RequestScoped

public class HeyBean {
    public String getMessage() {
        return "Hello, Course!";
    }
    
}
