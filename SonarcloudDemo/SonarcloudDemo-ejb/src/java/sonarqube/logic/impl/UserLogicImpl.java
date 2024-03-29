/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sonarqube.logic.impl;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import sonarqube.dao.UserAccess;
import sonarqube.dto.UserTransfer;
import sonarqube.entity.UserEntity;
import sonarqube.facade.UserMapper;
import sonarqube.logic.UserLogic;

/**
 *
 * @author Eric Babcock <ebabcock@uni-koblenz.de>
 */
@Stateless
public class UserLogicImpl implements UserLogic {
  @EJB
  private UserAccess userAccess;
  
  @EJB
  private UserMapper userMapper;
  
  @Resource
  private EJBContext ejbContext;
  
  private UserEntity caller;
  
  @AroundInvoke
  private Object getCaller(InvocationContext ctx) throws Exception {
    String username = getCurrentUsername();
    if (username != null){
      caller = userAccess.getUser(username);
    }
    return ctx.proceed();
  }
  
  @Override
  public String getCurrentUsername() {
    Principal principal = ejbContext.getCallerPrincipal();
    if (principal == null)
      return null;
    
    return principal.getName();
  }

  @Override
  public UserTransfer getCurrentUser() {
    return userMapper.toDto(caller);
  }

  @Override
  public UserTransfer getUserByUsername(String username) {
    UserEntity userEntity = userAccess.findUserByUsername(username);
    
    return userMapper.toDto(userEntity);
  }

  @Override
  public List<UserTransfer> getAllUsers() {
    List<UserEntity> entities = userAccess.findAllUsers();
    return entities.stream().map(userMapper::toDto).collect(Collectors.toList());
  }

  @Override
  public void addUser(UserTransfer userTransfer) {
    UserEntity userEntity = userMapper.toEntity(userTransfer);
    userAccess.save(userEntity);
  }

  @Override
  public UserTransfer getUserById(int id) {
    UserEntity userEntity = userAccess.find(id);
    return userMapper.toDto(userEntity);
  }

  @Override
  public void deleteById(UserTransfer userTransfer) {
    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  }
}


