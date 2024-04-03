/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sonarqube.beans;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Eric Babcock <ebabcock@uni-koblenz.de>
 */

@DeclareRoles({"USER", "ADMIN"})
@Stateless
@LocalBean
public class WorkBean {
  @RolesAllowed("USER")
  public void doWork(String user) {
    System.out.print("work");
  }
  
  @RolesAllowed("ADMIN")
  public void administrate(){
    System.out.println("admin");
  }
}
