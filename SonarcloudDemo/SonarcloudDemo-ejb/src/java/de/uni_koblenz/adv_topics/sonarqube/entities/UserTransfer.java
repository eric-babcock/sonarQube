/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.uni_koblenz.adv_topics.sonarqube.entities;

/**
 *
 * @author Eric Babcock <ebabcock@uni-koblenz.de>
 */
public class UserTransfer extends AbstractTransfer{
  
    private String username;
    private String firstName;
    private String lastName;

    public UserTransfer() {
    }
    
    
    public UserTransfer(String uuid, int jpaVersion, String username, String firstName, String lastName) {
        super(uuid, jpaVersion);
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserTransfer{" + "username=" + username + ", firstName=" + firstName + ", lastName=" + lastName + '}';
    }
    
}
