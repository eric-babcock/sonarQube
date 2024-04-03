/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sonarqube.beans;

import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

import sonarqube.dto.UserTransfer;
import sonarqube.logic.UserLogic;

/**
 *
 * @author Eric Babcock <ebabcock@uni-koblenz.de>
 */
@SessionScoped @Named
public class Login implements Serializable{
  
  private static final Logger LOG = Logger.getLogger(Login.class.getName());
  
  private UserTransfer currentUser;
  
  @EJB 
  private UserLogic userLogic;
  
  @PostConstruct
  public void newSession() {
    LOG.info("SONARQUBE: NEW SESSION");
  }
  
  public boolean isLoggedIn() {
    return getUser() != null;
  }
  
  private Principal oldPrincipal = null;

  public UserTransfer getUser() {
    Principal principal = FacesContext
            .getCurrentInstance()
            .getExternalContext()
            .getUserPrincipal();
    if (principal == null) {
      currentUser = null;
    } else {
       if (!principal.equals(oldPrincipal)) {
                LOG.log(Level.INFO, "EVS: LOGIN user {0}", principal.getName());
                currentUser = userLogic.getCurrentUser();
       }
    }
    
    oldPrincipal = principal;
    return currentUser;
  }
  
  public void login() {
    try{
      FacesContext context = FacesContext.getCurrentInstance();
      
      if(context.getExternalContext().isUserInRole("USER")){
        context.getExternalContext().redirect("pages/user/home.xhtml");
      }
    } catch(IOException e) {
      System.out.println("Error:" +e);
    }
  }
  
  public void invalidateSession() {
    LOG.log(Level.INFO, "invalidateSession()");
    Principal principal = FacesContext
            .getCurrentInstance()
            .getExternalContext()
            .getUserPrincipal();
    if (principal != null) {
      LOG.log(Level.INFO, "Contacts: LOGOUT user {0}", principal.getName());
    }
    currentUser = null;
    oldPrincipal = null;
    FacesContext
            .getCurrentInstance()
            .getExternalContext()
            .invalidateSession();
  }
  
public void logout() {
  
        try {
            invalidateSession();
            
            FacesContext.getCurrentInstance().getExternalContext()
                    .redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + "/pages/index.xhtml?faces-redirect=true");
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
}
