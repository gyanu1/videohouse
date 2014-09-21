package cs544.videohouse.service;

import cs544.videohouse.dao.IVideoDAO;
import cs544.videohouse.domain.Category;
import cs544.videohouse.domain.User;
import cs544.videohouse.domain.Video;
import java.util.Collection;
import java.util.Date;
import javax.transaction.Transactional;
import org.hibernate.SessionFactory;

public class VideoService implements IVideoService {

    private IVideoDAO videoDAO;    
    private SessionFactory sf;

    public VideoService(IVideoDAO u,SessionFactory sf) {
        videoDAO = u;
        this.sf = sf;
    }

    @Override
    public Video createVideo(String title, String filename, String type, String path, Date date, Date duration, byte[] thumbnail, User user, Category category) {     
        Video video = new Video(title,  filename, type,  path,  date, duration, thumbnail,  user,  category);        
        videoDAO.saveVideo(video);        
        return video;
    }        

    @Override
    public Collection<Video> getVideos() {
        return videoDAO.getVideos();
    }
    
    @Override
    public Collection<Video> getVideo(String title) {
        return videoDAO.getVideos(title);
    }

    @Override
    @Transactional
    public void changeDetails(long id, Video video) {
        Video loadedVid=videoDAO.loadVideo(id);
        if(!video.getTitle().equals(loadedVid.getTitle()))
            loadedVid.setTitle(video.getTitle());
        if(!video.getFilename().equals(loadedVid.getFilename()))
            loadedVid.setFilename(video.getFilename());
        if(!video.getType().equals(loadedVid.getType()))
            loadedVid.setType(video.getType());
        if(!video.getPath().equals(loadedVid.getPath()))
            loadedVid.setPath(video.getPath());
        if(!video.getDate().equals(loadedVid.getDate()))
            loadedVid.setDate(video.getDate());
        if(!video.getDuration().equals(loadedVid.getDuration()))
            loadedVid.setDuration(video.getDuration());
        if(!video.getThumbnail().equals(loadedVid.getThumbnail()))
            loadedVid.setThumbnail(video.getThumbnail());
        if(!video.getUser().equals(loadedVid.getUser()))
            loadedVid.setUser(video.getUser());
        if(!video.getCategory().equals(loadedVid.getCategory()))
            loadedVid.setCategory(video.getCategory());
        
        if(video.getViewCount()!=loadedVid.getViewCount() && video.getViewCount()>0)
            loadedVid.setViewCount(video.getViewCount());
        if(video.getLikeCount()!=loadedVid.getLikeCount() && video.getLikeCount()>0)
            loadedVid.setLikeCount(video.getLikeCount());
        if(video.getDislikeCount()!=loadedVid.getDislikeCount() && video.getDislikeCount()>0)
            loadedVid.setDislikeCount(video.getDislikeCount());
        if(!video.getKeywords().equals(loadedVid.getKeywords()) && video.getKeywords()!=null)
            loadedVid.setKeywords(video.getKeywords());
        videoDAO.updateVideo(loadedVid);
    }    
}