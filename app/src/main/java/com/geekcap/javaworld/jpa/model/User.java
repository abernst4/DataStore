package com.geekcap.javaworld.jpa.model;

import com.geekcap.javaworld.jpa.resource.UserResource;
import com.geekcap.javaworld.jpa.repository.UserRepository;

import com.geekcap.javaworld.jpa.model.Group;
import com.geekcap.javaworld.jpa.resource.GroupResource;
import com.geekcap.javaworld.jpa.repository.GroupRepository;

import java.util.Set;
import java.lang.annotation.Inherited;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.annotation.processing.Generated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.JoinTable;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

/*@NamedQueries({
        @NamedQuery(name = "User.findByEmail", //findByName
                query = "SELECT user FROM User user WHERE user.email = :email"),
        @NamedQuery(name = "User.findAll",
                query = "SELECT b FROM Group b")
})
*/
@Entity
@Table(name = "users")
public class User extends PanacheEntity{
    public String name;
    public String creator;
    //private Long id; 

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JoinColumn(name = "group_id")
    public Group group;
}

/*
EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Users");
EntityManager entityManager = entityManagerFactory.createEntityManager();

public class User extends PanacheEntityBase{
    //private String first_name;
   // private String last_name;
    public String email;
    //private String password;
    /*
    @OneToOne(mappedBy="user")
    private UserProfile profile;
     
   // @Id
   // @GeneratedValue
    //public Long id; 
    
    //@ManyToMany
    //@JoinTable(name="GROUP_USERS",
            //joinColumns=@JoinColumn(name="USER_ID"),
            //inverseJoinColumns=@JoinColumn(name="GROUP_ID"))
    //private Set<Group> groups = new HashSet<>();

    //@ManyToMany
    //private Set<Group> groups = new HashSet<>();

//}/
*/
