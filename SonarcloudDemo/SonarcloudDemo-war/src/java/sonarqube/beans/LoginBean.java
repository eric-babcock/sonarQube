/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sonarqube.beans;

import java.io.IOException;
import java.io.Serializable;
import java.security.Principal;
import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import sonarqube.dto.UserTransfer;

/**
 *
 * @author Eric Babcock <ebabcock@uni-koblenz.de>
 */
//@ManagedBean
@SessionScoped @Named
public class LoginBean implements Serializable {
  
  private String username;
  private String password;
  private static final String MY_SECRET = "47828a8dd77ee1eb9dde2d5e93cb221ce8c32b37";

  /*
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
  
  public void logout() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
		if (session != null) {
			session.invalidate();
		}
		context.getApplication().getNavigationHandler().handleNavigation(context, null, "/pages/index.xhtml");
	}
  
  public String getUsername() {
    return username;
  }
  
  public void setUsername(String username) {
    this.username = username;
  }
  
  public String getPassword() {
    return password;
  }
  
  public void setPassword() {
    this.password = password;
  }
*/
  
  
	private static final long serialVersionUID = 1L;

	public void login() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		try {
			request.login(username, password);
			Principal principal = request.getUserPrincipal();
			if (null != principal) {
				FacesContext.getCurrentInstance().getExternalContext().dispatch("/user/home.html");
				System.err.println(principal.getName());
			}
		} catch (ServletException e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "An Error Occured: Login failed", null));
			e.printStackTrace();
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}