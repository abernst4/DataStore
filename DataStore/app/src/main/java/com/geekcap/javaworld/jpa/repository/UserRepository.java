package com.geekcap.javaworld.jpa.repository;
import com.geekcap.javaworld.jpa.model.User;
import javax.persistence.EntityManager;
import java.util.Set;
import java.util.Optional;

public class UserRepository {
    private EntityManager entityManager;
    public UserRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<User> findById(Integer id) {
        User user = entityManager.find(User.class, id);
        return user != null ? Optional.of(user) : Optional.empty();
    }

    public Set<User> findAll() {
        return (Set<User>) entityManager.createQuery("from User").getResultList();
    }

    public Optional<User> findByEmail(String email) {
        User user = entityManager.createQuery("SELECT b FROM User b WHERE b.email = :email", User.class)
                .setParameter("email", email)
                .getSingleResult();
        return email != null ? Optional.of(user) : Optional.empty();
    }

    public Optional<User> findByNameNamedQuery(String email) {
        User user = entityManager.createNamedQuery("User.findByEmail", User.class)
                                    .setParameter("email", email)
                                    .getSingleResult();
        return user != null ? Optional.of(user) : Optional.empty();
    }

    public Optional<User> save(User user) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
            return Optional.of(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public void deleteById(Integer id) {
        // Retrieve the movie with this ID
        User user = entityManager.find(User.class, id);
        if (user != null) {
            try {
                // Start a transaction because we're going to change the database
                entityManager.getTransaction().begin();

                // Remove all references to this superhero in its movies
                user.getGroups().forEach(movie -> {
                    movie.getUsers().remove(user);
                });

                // Now remove the superhero
                entityManager.remove(user);

                // Commit the transaction
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}