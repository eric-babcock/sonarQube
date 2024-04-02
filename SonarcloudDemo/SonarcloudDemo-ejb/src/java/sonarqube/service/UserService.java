/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sonarqube.service;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import sonarqube.dao.UserAccess;
import sonarqube.entity.User;
import sonarqube.logic.UserLogic;

/**
 *
 * @author Eric Babcock <ebabcock@uni-koblenz.de>
 */
@Stateless
@LocalBean
public class UserService {
  
  private Map<String, User> userMap = new HashMap<>();
  
  @EJB
  private UserAccess userAccess;
  @EJB
  private UserLogic userLogic;
  
  public User findByUsername(String username) {
    if (!userMap.containsKey(username)) {
      User user = userAccess.getUser(username);
      if (user == null) {
        return null;
      }
      userMap.putIfAbsent(username,user);
    }
    return userMap.get(username);
  }
  
  public User getCurrentLoggedInUser() {
    return findByUsername(userLogic.getCurrentUsername());
  }
}
