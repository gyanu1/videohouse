/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.videohouse.domain;

import java.util.ArrayList;
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
public class Category {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    
    @OneToMany(mappedBy = "category")
    private List<Subscription> subscriptions=new ArrayList<Subscription>();
    @OneToMany(mappedBy = "category")
    private List<Video> videos=new ArrayList<Video>();

    public Category() {
    }

    public Category(String name) {
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

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }
           
}
