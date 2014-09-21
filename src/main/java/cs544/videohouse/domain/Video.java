/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.videohouse.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author BTimilsina
 */
@Entity
public class Video {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String filename;
    private String type;
    private String path;
    @Temporal(TemporalType.DATE)
    private Date date;
    private int viewCount;
    private int likeCount;
    private int dislikeCount;            
    @Temporal(TemporalType.TIME)
    private Date duration;
    private String keywords;
    @Column(name="thumbnail",columnDefinition="longblob")
    private byte[] thumbnail;
    
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    @OneToMany(mappedBy="video")
    private List<Comment> comments=new ArrayList<Comment>();
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    public Video() {
        
    }

    public Video(String title, String filename, String type, String path, Date date, Date duration, byte[] thumbnail, User user, Category category) {
        this.title = title;
        this.filename = filename;
        this.type = type;
        this.path = path;
        this.date = date;
        this.duration = duration;
        this.thumbnail = thumbnail;
        this.user = user;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getDislikeCount() {
        return dislikeCount;
    }

    public void setDislikeCount(int dislikeCount) {
        this.dislikeCount = dislikeCount;
    }

    public Date getDuration() {
        return duration;
    }

    public void setDuration(Date duration) {
        this.duration = duration;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public byte[] getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(byte[] thumbnail) {
        this.thumbnail = thumbnail;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
        
}