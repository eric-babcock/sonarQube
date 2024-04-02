/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sonarqube.facade;

/**
 *
 * @author Eric Babcock <ebabcock@uni-koblenz.de>
 */

import sonarqube.entity.User;
import sonarqube.dto.UserTransfer;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;


@Stateless
@LocalBean
public class UserMapper extends AbstractMapper<User, UserTransfer> {
  @Override
  public UserTransfer toDto(User entity) {
    if(entity == null)
      return null;
    
    super.setDto(new UserTransfer());
    UserTransfer dto = super.toDto(entity);
    dto.setFirstName(entity.getFirstName());
    dto.setLastName(entity.getLastName());
    dto.setUsername(entity.getUsername());
    dto.setPassword(entity.getPassword());
    return dto;
  }
  
  @Override
  public User toEntity(UserTransfer domain) {
    if(domain == null)
      return null;
    
    super.setEntity(new User());
    User entity = super.toEntity(domain);
    entity.setFirstName(domain.getFirstName());
    entity.setLastName(domain.getLastName());
    entity.setUsername(domain.getUsername());
    entity.setPassword(domain.getPassword());
    return entity;
  }
  
  public List<UserTransfer> toDtoList(List<User> entities) {
    return entities.stream().map(entity -> toDto(entity)).collect(Collectors.toList());
  }
  
}
