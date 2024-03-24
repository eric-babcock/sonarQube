/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.uni_koblenz.adv_topics.sonarqube.example;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

/**
 *
 * @author Eric Babcock <ebabcock@uni-koblenz.de>
 */
@Stateless(name="HelloWorld")
public class HelloWorldBean implements HelloWorld {
  @Resource
  private SessionContext context;
  
  @Override
  public String getHelloWorld() {
    return "Welcome to EJB Tutorial:";
  }
}
