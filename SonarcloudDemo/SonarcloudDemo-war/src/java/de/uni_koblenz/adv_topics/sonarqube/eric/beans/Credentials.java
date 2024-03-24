/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.uni_koblenz.adv_topics.sonarqube.eric.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Eric Babcock <ebabcock@uni-koblenz.de>
 */
@Named 
@RequestScoped
public class Credentials {
  private String username;
  private String password;
  
  @NotNull
  @Length(min=3, max=25)
  public String getUsername() { return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  
  @NotNull
  @Length(min=8, max=20)
  public String getPassword() { return password;}
  
  public void setPassword(String password) {
    this.password=password;
  }
}
