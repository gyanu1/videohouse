/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.videohouse.dao;

import cs544.videohouse.domain.Video;
import java.util.Collection;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

/**
 *
 * @author Bishal Timilsina
 */
@Transactional
public class VideoDAO implements IVideoDAO{
    
    private SessionFactory sf;

    public VideoDAO(SessionFactory sf) {
        this.sf = sf;
    }
        
    @Override
    public void saveVideo(Video vid) {
        System.out.println("VideoDAO: saving video with id =" + vid.getId());       
        sf.getCurrentSession().persist(vid);
    }

    @Override
    public void updateVideo(Video vid) {
        System.out.println("VideoDAO: updating video with id =" + vid.getId());       
        sf.getCurrentSession().update(vid);
    }

    @Override
    public Video loadVideo(long id) {
        System.out.println("VideoDAO: loading video with id =" + id);       
        return (Video)sf.getCurrentSession().get(Video.class, id);
    }

    @Override
    public void removeVideo(Video vid) {
        System.out.println("VideoDAO: removing video with id =" + vid.getId());       
        sf.getCurrentSession().delete(vid);
    }

    @Override
    public Collection<Video> getVideos() {
        System.out.println("VideoDAO: loading all videos...");       
        return sf.getCurrentSession().createQuery("from Video").list();
    }    

    @Override
    public Collection<Video> getVideos(String title) {
        System.out.println("VideoDAO: loading video with title = :title"); 
        Query q=sf.getCurrentSession().createQuery("from Video v where v.title= :email");
        q.setParameter("title", title);
        return q.list();
    }
}
