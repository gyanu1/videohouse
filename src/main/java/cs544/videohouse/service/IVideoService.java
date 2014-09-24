package cs544.videohouse.service;

import cs544.videohouse.domain.Category;
import cs544.videohouse.domain.User;
import cs544.videohouse.domain.Video;
import java.util.Collection;
import java.util.Date;

public interface IVideoService {
    public Video createVideo(String title, String filename, String type, String path, Date date, Date duration, byte[] thumbnail, User user, Category category);
    public void saveVideo(Video video);
    public Collection<Video> getVideo(String title);
    public Collection<Video> getVideos();
    public void changeDetails (long id,Video video);
    public void uploadVideo(Video video);
     public Video getVideo(long id);
}