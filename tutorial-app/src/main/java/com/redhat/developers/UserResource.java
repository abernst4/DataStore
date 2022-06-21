package com.redhat.developers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.Set;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.JoinTable;


@Entity
@Table(name = "User")
@NamedQueries({
        @NamedQuery(name = "User.findByEmail", //findByName
                query = "SELECT user FROM User user WHERE user.email = :email"),
        @NamedQuery(name = "User.findAll",
                query = "SELECT b FROM Group b")
})

@Path("/user")
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    /*
    @OneToOne(mappedBy="user")
    private UserProfile profile;
     */

    public User() {

    }

    public User(Integer id, String email) {
        this.id = id;
        this.email = email;
    }

    public User(String email) {
        this.email = email;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String name) {
        this.email = name;
    }

    @ManyToMany
    @JoinTable(name="GROUP_USERS",
            joinColumns=@JoinColumn(name="USER_ID"),
            inverseJoinColumns=@JoinColumn(name="GROUP_ID"))
    private Set<Group> groups = new HashSet<>();

    public void addGroup(Group group) {
        this.groups.add(group);
    }

    public Set<Group> getGroups(){
        return this.groups;
    }
}

/*
EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Users");
EntityManager entityManager = entityManagerFactory.createEntityManager();
 */

