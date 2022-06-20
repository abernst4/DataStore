package com.geekcap.javaworld.jpa.model;

import java.util.Set;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.CascadeType;

import javax.persistence.ManyToMany;

@Entity
@Table(name = "Group")
@NamedQueries({
        @NamedQuery(name = "Group.findByName",
                query = "SELECT group FROM Group group WHERE group.name = :name"),
        @NamedQuery(name = "Group.findAll",
                query = "SELECT group FROM Group group")
})

public class Group {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    //@Column(name="ISBN_NUMBER")
    //private String isbn;

    public Group(int id, String name){
            this.id = id; 
            this.name = name; 
    }

    public Group(){}


    @ManyToMany(mappedBy = "groups", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<User> users = new HashSet<>();

    public int getID(){
            return this.id; 
    }

    public String getName(){
            return this.name; 
    }

    public void setName(String name){
            this.name = name; 
    }

    public void setID(Integer i){
            this.id = i; 
    }

    public Set<User> getUsers(){
            return this.users;
    }

    public void addUser(User user){
        users.add(user);
        User.getGroups().add(this); 
    }

    public String getId() {
        return this.id.toString();
    }
}