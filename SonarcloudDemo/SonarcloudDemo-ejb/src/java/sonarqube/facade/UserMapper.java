/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sonarqube.facade;

/**
 *
 * @author Eric Babcock <ebabcock@uni-koblenz.de>
 */

import sonarqube.entity.UserEntity;
import sonarqube.dto.UserTransfer;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;


@Stateless
@LocalBean
public class UserMapper extends AbstractMapper<UserEntity, UserTransfer> {
  @Override
  public UserTransfer toDto(UserEntity entity) {
    if(entity == null)
      return null;
    
    super.setDto(new UserTransfer());
    UserTransfer dto = super.toDto(entity);
    dto.setFirstName(entity.getFirstName());
    dto.setLastName(entity.getLastName());
    dto.setUsername(entity.getUsername());
    return dto;
  }
  
  @Override
  public UserEntity toEntity(UserTransfer domain) {
    if(domain == null)
      return null;
    
    super.setEntity(new UserEntity());
    UserEntity entity = super.toEntity(domain);
    entity.setFirstName(domain.getFirstName());
    entity.setLastName(domain.getLastName());
    entity.setUsername(domain.getUsername());
    return entity;
  }
  
  public List<UserTransfer> toDtoList(List<UserEntity> entities) {
    return entities.stream().map(entity -> toDto(entity)).collect(Collectors.toList());
  }
  
}
