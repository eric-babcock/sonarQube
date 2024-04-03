/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sonarqube.entity;

/**
 *
 * @author Eric Babcock <ebabcock@uni-koblenz.de>
 */
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

@Entity
@NamedQueries({
    @NamedQuery(name = "deleteUserById", query = "DELETE FROM User u WHERE u.id= :id"),
    @NamedQuery(name = "getUserCount", query = "SELECT COUNT(u) FROM User u"),
    @NamedQuery(name = "getUserList", query = "SELECT u FROM User u ORDER BY u.firstName, u.uuid"),
    @NamedQuery(name = "getUserByName", query = "SELECT u FROM User u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "getUserByUserName", query = "SELECT u FROM User u WHERE u.username = :username"),
    @NamedQuery(name = "getUserByUuid", query= "SELECT u from User u WHERE u.uuid = :uuid")     
  }
)
public class User extends AbstractEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "username", nullable = false, unique = true, updatable = false)
    private String username;
    
    //@Column(name = 
    private String password;

    public User() {
    }

    public User(boolean isNew) {
        super(isNew);
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
    
    public String getPassword() {
      return password;
    }
    
    public void setPassword(String password) {
      this.password = password;
    }
    
    @Override
    public String toString() {
        return "User{" + "firstName=" + firstName + ", lastName=" + lastName + ", username=" + username + '}';
    }

}
