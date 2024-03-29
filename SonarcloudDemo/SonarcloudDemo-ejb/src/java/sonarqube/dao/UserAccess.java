/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sonarqube.dao;

/**
 *
 * @author Eric Babcock <ebabcock@uni-koblenz.de>
 */
import sonarqube.entity.UserEntity;
import sonarqube.dao.AbstractAccess;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class UserAccess extends AbstractAccess<UserEntity> {

    @PersistenceContext(unitName = "SonarcloudDemo-ejbPU")
    private EntityManager entitymanager;   

    @Override
    protected EntityManager getEntityManager() {
        return entitymanager;
    }

    public UserAccess() {
        super(UserEntity.class);
    }

    public UserEntity getUser(String userName) {
        UserEntity userentity;
        try {
            userentity = entitymanager.createNamedQuery("getUserByUserName", UserEntity.class)
                    .setParameter("username", userName)
                    .getSingleResult();
        } catch (NoResultException e) {
            userentity = new UserEntity(true);
            userentity.setUsername(userName);
            userentity.setFirstName(userName);
            userentity.setLastName(userName);
            entitymanager.persist(userentity);
        }
        return userentity;
    }
    
    public UserEntity getByUuid(String uuid) {
        try {
            return entitymanager.createNamedQuery("getUserByUuid", UserEntity.class)
                    .setParameter("uuid", uuid)
                    .getSingleResult();
        } catch (NoResultException e) {
            // Entity with specified UUID doesn't exist
            return null;
        }
    }
    
    public UserEntity findUserByUsername(String username){
        try{
        return entitymanager.createNamedQuery("getUserByUserName", UserEntity.class)
                .setParameter("username", username)
                .getSingleResult();
        } catch (NoResultException e){
            return null;
        }
    }
    
    public List<UserEntity> findAllUsers(){
        return entitymanager.createNamedQuery("getUserList", UserEntity.class)
                .getResultList();
    }
    
    public void save(UserEntity userentity){
        create(userentity);
    }

    
}
