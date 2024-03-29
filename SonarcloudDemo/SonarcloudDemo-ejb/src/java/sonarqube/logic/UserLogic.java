/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sonarqube.logic;

import sonarqube.dto.UserTransfer;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Eric Babcock <ebabcock@uni-koblenz.de>
 */
@Remote
public interface UserLogic {
  
  public UserTransfer getCurrentUser();
  
  public String getCurrentUsername();
  
  public UserTransfer getUserByUsername(String username);
  
  public List<UserTransfer> getAllUsers();
  
  public void addUser(UserTransfer userTransfer);
  
  public UserTransfer getUserById(int id);
  
  public void deleteById(UserTransfer userTransfer);
}





