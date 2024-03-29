/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sonarqube.facade;

import sonarqube.entity.AbstractEntity;
import sonarqube.dto.AbstractTransfer;

/**
 *
 * @author Eric Babcock <ebabcock@uni-koblenz.de>
 */
public abstract class AbstractMapper<Entity extends AbstractEntity, Domain extends AbstractTransfer>  {
  
  private Entity entity;
  private Domain domain;
  
  public Entity toEntity(Domain domain) {
    entity.setId(domain.getId());
    entity.setJpaVersion(domain.getJpaVersion());
    entity.setCreatedAt(domain.getCreatedAt());
    entity.setUpdatedAt(domain.getUpdatedAt());
    entity.setUuid(domain.getUuid());
    return entity;
  }
  
  public Domain toDto(Entity entity) {
    domain.setId(entity.getId());
    domain.setJpaVersion(entity.getJpaVersion());
    domain.setCreatedAt(entity.getCreatedAt());
    domain.setUpdatedAt(entity.getUpdatedAt());
    domain.setUuid(entity.getUuid());
    return domain;
  }
  
  public void setEntity(Entity entity) {
    this.entity = entity;
  }
  
  public void setDto(Domain domain) {
    this.domain = domain;
  }
}
