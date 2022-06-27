package com.geekcap.javaworld.jpa.model;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "groups")
@NamedQueries({
        @NamedQuery(name = "Group.findById",
                query = "SELECT group FROM Group group WHERE group.id = :name"),
        @NamedQuery(name = "Group.findAll",
                query = "SELECT group FROM Group group")
})

public class Group extends PanacheEntity{
    
    public String name;
    //@Column(name="ISBN_NUMBER")
    //private String isbn;

    @OneToMany//, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<User> users = new HashSet<>();
}


