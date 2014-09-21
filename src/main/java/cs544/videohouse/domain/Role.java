/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.videohouse.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author BTimilsina
 */
@Entity
public class Role {
    @Id
    @GeneratedValue
    private Long id;    
    private String name;
    
    @OneToMany(mappedBy="role")
    private List<User> users=new ArrayList<User>();

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }
        
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
       
    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        Iterator<User> i = users.iterator();
        while (i.hasNext()) {
           User u = i.next();
           if(u==user){
              i.remove();
              break;
           }
        }
    }
    
}
