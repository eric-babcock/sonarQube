/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sonarqube.service;

import javax.annotation.security.RolesAllowed;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author Eric Babcock <ebabcock@uni-koblenz.de>
 */

@WebService @Stateless @LocalBean
public class TestService {
  
  @WebMethod @RolesAllowed("ADMIN")
  public String sayHello(){
    return "Hello admin";
  }
  
  @WebMethod @RolesAllowed("USER")
  public String sayHi(){
    return "Hi User";
  }
  
}
