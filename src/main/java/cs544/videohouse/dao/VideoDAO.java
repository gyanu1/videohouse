/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.videohouse.dao;

import cs544.videohouse.domain.Video;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

/**
 *
 * @author Bishal Timilsina
 */
public class VideoDAO implements IVideoDAO {

    private SessionFactory sf;

    public VideoDAO(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public void saveVideo(Video vid) {
        System.out.println("before saving video with id =" + vid.getId());
        sf.getCurrentSession().persist(vid);
        System.out.println("after saving video with id =" + vid.getId());
    }

    @Override
    public void updateVideo(Video vid) {
        System.out.println("VideoDAO: updating video with id =" + vid.getId());
        sf.getCurrentSession().update(vid);
    }

    @Override
    public Video loadVideo(long id) {
        System.out.println("VideoDAO: loading video with id =" + id);
        return (Video) sf.getCurrentSession().get(Video.class, id);
    }

    @Override
    public void removeVideo(Video vid) {
        System.out.println("VideoDAO: removing video with id =" + vid.getId());
        sf.getCurrentSession().delete(vid);
    }

    @Override
    public List<Video> getVideos() {
        System.out.println("VideoDAO: loading all videos...");
        return sf.getCurrentSession().createQuery("from Video").list();
    }

    @Override
    public List<Video> getVideos(String title) {
        System.out.println("VideoDAO: loading video with title = :title");
        Query q = sf.getCurrentSession().createQuery("from Video v where v.title= :title");
        q.setParameter("title", title);
        return q.list();
    }

    @Override
    public Video getVideo(long id) {
        System.out.println("VideoDAO: loading video with id = :" + id);
        return (Video) sf.getCurrentSession().get(Video.class, id);
    }

    @Override
    public List<Video> getVideosForSearch(String query) {
        String sql = "From Video where title like :title or keywords like :keyword";
        Query query1 = sf.getCurrentSession().createQuery(sql);
        System.out.println("query1 : " + query1.toString());
        query1.setParameter("title", "%" + query + "%");
        query1.setParameter("keyword", "%" + query + "%");
        System.out.println("query1 : " + query1.toString());
        return query1.list();
    }
}
