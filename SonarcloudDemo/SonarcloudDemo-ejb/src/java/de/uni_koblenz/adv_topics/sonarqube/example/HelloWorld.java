/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package de.uni_koblenz.adv_topics.sonarqube.example;

import javax.ejb.Remote;

/**
 *
 * @author Eric Babcock <ebabcock@uni-koblenz.de>
 */
@Remote
public interface HelloWorld {
  String getHelloWorld();
}
