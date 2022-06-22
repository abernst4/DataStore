package com.geekcap.javaworld.jpa.model;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;


@Entity
/*@Table(name = "Group")
@NamedQueries({
        @NamedQuery(name = "Group.findByName",
                query = "SELECT group FROM Group group WHERE group.name = :name"),
        @NamedQuery(name = "Group.findAll",
                query = "SELECT group FROM Group group")
})
*/
public class Group  extends panacheEntity{

    //@Id
    //@GeneratedValue
    private String id;
    private String name;
    //@Column(name="ISBN_NUMBER")
    //private String isbn;

    public Group(int id, String name){
            this.id = id; 
            this.name = name;
    }

    public Group(){}

    @ManyToMany //(mappedBy = "groups") //, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<User> users = new HashSet<>();

    public String getID(){
            return this.id; 
    }

    public String getName(){
            return this.name; 
    }

    public void setName(String name){
            this.name = name; 
    }

    public void setID(String i){
            this.id = i; 
    }

    public Set<User> getUsers(){
            return this.users;
    }

    public void addUser(User user){
        users.add(user);
        user.getGroups().add(this); 
    }

    public String getId() {
        return this.id;
    }
}