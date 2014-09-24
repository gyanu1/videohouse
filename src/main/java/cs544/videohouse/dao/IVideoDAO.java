/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.videohouse.dao;

import cs544.videohouse.domain.Video;
import java.util.List;

/**
 *
 * @author Bishal Timilsina
 */
public interface IVideoDAO {
   public void saveVideo(Video usr);
   public void updateVideo(Video usr);
   public Video loadVideo(long id);
   public void removeVideo(Video usr);
   public List<Video> getVideos();
   public List<Video> getVideos(String title);
    public Video getVideo(long id);

    public List<Video> getVideosForSearch(String query);
}
