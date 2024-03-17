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

@Named
@SessionScoped

public class LoginBean implements Serializable {
    public void HashPasswords() {
    byte[] salt = "salty".getBytes();
    PBEParameterSpec cipherSpec = new PBEParameterSpec(salt,10000); // Noncompliant
}
}

