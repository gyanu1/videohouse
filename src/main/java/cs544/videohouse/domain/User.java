/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.videohouse.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author BTimilsina
 */

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    @NotEmpty
    private String email;  
    @NotEmpty
    private String password;    
    private String facebookId;
    
    @OneToMany(mappedBy="user")
    private List<Video> videos=new ArrayList<Video>();
    @OneToMany(mappedBy="user")
    private List<Comment> comments=new ArrayList<Comment>();
    @OneToMany(mappedBy="user")
    private List<Subscription> subscriptions=new ArrayList<Subscription>();
    @ManyToOne
    @JoinColumn(name="role_id")
    private Role role;

    public User() {
    }

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public User(String firstName, String lastName, String email, String facebookId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.facebookId = facebookId;
    }
        
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }    

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }   

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }
            
    public void addVideo(Video video) {
        videos.add(video);
    }

    public void removeVideo(Video video) {
        Iterator<Video> i = videos.iterator();
        while (i.hasNext()) {
           Video v = i.next();
           if(v==video){
              i.remove();
              break;
           }
        }
    }   
    
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void removeComment(Comment comment) {
        Iterator<Comment> i = comments.iterator();
        while (i.hasNext()) {
           Comment c = i.next();
           if(c==comment){
              i.remove();
              break;
           }
        }
    }
    
    public void addSubscription(Subscription subscription) {
        subscriptions.add(subscription);
    }

    public void removeSubscription(Subscription subscription) {
        Iterator<Subscription> i = subscriptions.iterator();
        while (i.hasNext()) {
           Subscription s = i.next();
           if(s==subscription){
              i.remove();
              break;
           }
        }
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
            
}