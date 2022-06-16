package com.geekcap.javaworld.jpa.model;

import java.util.Set;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
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
    @ManyToMany(mappedBy = "group")
    private Set<User> users = new HashSet<>();
}