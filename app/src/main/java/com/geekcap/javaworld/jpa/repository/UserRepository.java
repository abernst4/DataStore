package com.geekcap.javaworld.jpa.repository;

import com.geekcap.javaworld.jpa.resource.UserResource;
import com.geekcap.javaworld.jpa.model.User;
import javax.persistence.EntityManager;
import java.util.Set;
import java.util.HashSet;
import java.util.List; 
import javax.enterprise.context.ApplicationScoped;
//import edu.yu.cs.artAPI.Art;
//import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;


@ApplicationScoped
public class UserRepository implements PanacheRepository<User>{
    public User findById(String id) {
        return find("id", id).firstResult();
    }

    public User findByGallery(String email){
       return find("email", email).firstResult();
   }   
}

    /*
    private EntityManager entityManager;
    public UserRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public User findById(Integer id) {
        User user = entityManager.find(User.class, id);
        //return user != null ? User.of(user) : null;
        return user;
    }

    /*
    public Set<User> findAll() {
        return (Set<User>) entityManager.createQuery("from User").getResultList();
    }
    
     */

    /*
    public User findByEmail(String email) {
        User user = entityManager.createQuery("SELECT b FROM User b WHERE b.email = :email", User.class)
                .setParameter("email", email)
                .getSingleResult();
        return email != null ? User.of(user) : "";
    }
     */

    /**
     * This is not currently mentioned in UserResource
     * @param email
     * @return
     */
    /*
    public User findByNameNamedQuery(String email) {
        User user = entityManager.createNamedQuery("User.findByEmail", User.class)
                                    .setParameter("email", email)
                                    .getSingleResult();
        return user != null ? User.of(user) : User.empty();
    }
     */

    /**
     * This is not currently mentioned in UserResource
     * @param user
     * @return
     */
    /*
    public User save(User user) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
            return User.of(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
     
        return User.empty();
    }
     */

    /**
     *
     * @param id
     */
    /*
    public Set<Groups> getGroupsById(Integer id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            try {
                user.getGroups();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
     */

    /*
    public boolean deleteById(Integer id) {
        // Retrieve the movie with this ID
        User user = entityManager.find(User.class, id);
        if (user != null) {
            try {
                // Start a transaction because we're going to change the database
                entityManager.getTransaction().begin();

                // Remove all references to this superhero in its movies
                user.getGroups().forEach(group -> {
                    group.getUsers().remove(user);
                });

                // Now remove the superhero
                entityManager.remove(user);

                // Commit the transaction
                entityManager.getTransaction().commit();
                return true;
            } catch (Exception e) {
                return false;
                e.printStackTrace();
            }
        }
    }
     */

//}