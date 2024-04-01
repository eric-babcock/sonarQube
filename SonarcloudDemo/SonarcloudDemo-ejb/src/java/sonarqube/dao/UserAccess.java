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
    private EntityManager entitymanager;   

    @Override
    protected EntityManager getEntityManager() {
        return entitymanager;
    }

    public UserAccess() {
        super(User.class);
    }

    public User getUser(String username) {
        User userentity;
        try {
            userentity = entitymanager.createNamedQuery("getUserByUserName", User.class)
                    .setParameter("username", username)
                    .setParameter("firstName",username)
                    .setParameter("lastName",username)
                    .getSingleResult();
        } catch (NoResultException e) {
            userentity = new User(true);
            userentity.setUsername(username);
            userentity.setFirstName(username);
            userentity.setLastName(username);
            entitymanager.persist(userentity);
        }
        return userentity;
    }
    
    
    
    public User getByUuid(String uuid) {
        try {
            return entitymanager.createNamedQuery("getUserByUuid", User.class)
                    .setParameter("uuid", uuid)
                    .getSingleResult();
        } catch (NoResultException e) {
            // Entity with specified UUID doesn't exist
            return null;
        }
    }
    
    public User findUserByUsername(String username){
        try{
        return entitymanager.createNamedQuery("getUserByUserName", User.class)
                .setParameter("username", username)
                .getSingleResult();
        } catch (NoResultException e){
            return null;
        }
    }
    
    public List<User> findAllUsers(){
        return entitymanager.createNamedQuery("getUserList", User.class)
                .getResultList();
    }
    
    public void save(User userentity){
        create(userentity);
    }
    
    
}
