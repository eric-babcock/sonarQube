/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.uni_koblenz.adv_topics.sonarqube.examples;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.crypto.spec.PBEParameterSpec;

/**
 *
 * @author Eric Babcock <ebabcock@uni-koblenz.de>
 */

/*
private static final String MY_SECRET = "47828a8dd77ee1eb9dde2d5e93cb221ce8c32b37";

public static void main(String[] args) {
  .callMyService(MY_SECRET);
}
*/


 public String login() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		try {
      
      //Login via Servlet 3.0
      request.login(username, password);
      
      // The principal corresponds to the user name
			Principal principal = request.getUserPrincipal();
      
      // We can only query here whether the user has a role (isUserInRole('whatever')),
			// but we can NOT actively query the role (e.g. with getUserRole(...))
			if (request.isUserInRole("ADMIN")) {
        String msg = "User: " + principal.getName() + ", Role: admin";
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null));
        
      } else if (request.isUserInRole("USER")) {
				String msg = "User: " + principal.getName() + ", Role: user";
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null));
				return "user";
    }
      return "you_have_to_define_the_roles";
    } catch (ServletException e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "An Error Occured: Login failed", null));
			e.printStackTrace();
    }
    return "loginFailed";
  }