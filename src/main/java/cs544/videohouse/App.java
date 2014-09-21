/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.videohouse;

import cs544.videohouse.domain.*;
import cs544.videohouse.service.*;
import java.util.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author BTimilsina
 */
public class App {
        
//    public static void main(String[] args) {
//        ApplicationContext context=new ClassPathXmlApplicationContext("videohouse-servlet.xml");
//        IUserService userService=context.getBean("userService", UserService.class);
//        IVideoService videoService=context.getBean("videoService", VideoService.class);        
//        Category cat1=context.getBean("categoryService", CategoryService.class).createCategory("music");
//                
//        userService.createUser("Gyanu", "Maharjan","gymaharjan@gmail.com");
//        User usr1=userService.getUser("gymaharjan@gmail.com");
//        videoService.createVideo("1 min Epic Music", "1 min Epic Music", "flv", "1 min Epic Music", 
//                                        new GregorianCalendar(2014, 9, 19).getTime(), new GregorianCalendar(1, 1, 1, 2, 3, 4).getTime(), 
//                                               Thumbnail.getThumbnail("t1.JPG"),usr1 , cat1);
//        videoService.createVideo("3MIN News April 4, 2013", "3MIN News April 4, 2013", "mp4", "3MIN News April 4, 2013", 
//                                        new GregorianCalendar(2014, 9, 19).getTime(), new GregorianCalendar(1, 1, 1, 4, 3, 2).getTime(), 
//                                               Thumbnail.getThumbnail("t1.JPG"), usr1, cat1);
//        
//        List<Video> videoList = (List<Video>) videoService.getVideos();
//        for (Video video : videoList) {
//            System.out.println("name= " + video.getFilename() + ", type= "
//                    + video.getType() + ", duration= " + video.getDuration());
//        }
//    }        
}