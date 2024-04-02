/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sonarqube.dao;

/**
 *
 * @author Eric Babcock <ebabcock@uni-koblenz.de>
 */
import sonarqube.entity.User;
import sonarqube.dao.AbstractAccess;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class UserAccess extends AbstractAccess<User> {

    @PersistenceContext(unitName = "SonarcloudDemo-ejbPU")
    private EntityManager entityManager;   

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public UserAccess() {
        super(User.class);
    }

    public User getUser(String username) {
        User user;
        try {
            user = entityManager.createNamedQuery("getUserByUserName", User.class)
                    .setParameter("username", username)
                    .getSingleResult();
        } catch (NoResultException e) {
            user = new User(true);
            user.setUsername(username);
            user.setFirstName(username);
            user.setLastName(username);
            entityManager.persist(user);
        }
        return user;
    }
    
    
    
    public User getByUuid(String uuid) {
        try {
            return entityManager.createNamedQuery("getUserByUuid", User.class)
                    .setParameter("uuid", uuid)
                    .getSingleResult();
        } catch (NoResultException e) {
            // Entity with specified UUID doesn't exist
            return null;
        }
    }
    
    public User findUserByUsername(String username){
        try{
        return entityManager.createNamedQuery("getUserByUserName", User.class)
                .setParameter("username", username)
                .getSingleResult();
        } catch (NoResultException e){
            return null;
        }
    }
    
    public List<User> findAllUsers(){
        return entityManager.createNamedQuery("getUserList", User.class)
                .getResultList();
    }
    
    public void save(User userentity){
        create(userentity);
    }
    
    
}
