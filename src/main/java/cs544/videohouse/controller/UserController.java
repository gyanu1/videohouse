/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.videohouse.controller;

import cs544.videohouse.BCrypt;
import cs544.videohouse.domain.Video;
import cs544.videohouse.service.VideoService;
import cs544.videohouse.util.Utility;
import java.util.List;
import javax.validation.Valid;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cs544.videohouse.domain.User;
import cs544.videohouse.service.IUserService;
import javax.annotation.Resource;

/**
 *
 * @author GMaharjan
 */
@Controller
public class UserController {
    
    @Resource
    private IUserService userService;
    
    @Resource
    private VideoService videoService;

    @RequestMapping("/")
    public String redirectRoot() {        
        return "redirect:/login";
    }
        
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String redirectlogin(Model model) {
        System.out.println("redirect to login page");
        model.addAttribute("user", new User());
        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String redirectRegistration(Model model) {
        System.out.println("GET method redirect to register");
        model.addAttribute("user", new User());
        return "registration";    
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String checkUserLogin(@Valid User user, BindingResult result, Model model) {
        String view="login";        
        if (result.hasErrors()) {             
            if(user.getEmail().equals("") || user.getPassword().equals("")){
                System.out.println("Result has error"); 
                return view;
            }
            User user_actual;            
            user_actual=userService.getUser(user.getEmail());
            if(user_actual==null){
                System.out.println("No such User!!");
                return view;
            }                        
            if(BCrypt.checkpw(user.getPassword(), user_actual.getPassword())){                
                System.out.println("redirect to video page");
                view = "redirect:/search";            
            }else{
                System.out.println("redirect to login page");            
            }   
            return view;
        }
        return view;
    }        
        
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String checkRegistration(@Valid User user, BindingResult result, Model model) {
        String view = "registration";
        if (result.hasErrors()) {                        
            System.out.println("redirect to registration page (meth:POST)");            
            return view;
        } else {            
            String password = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(5));
            user.setPassword(password);
            userService.createUser(user);
            System.out.println("redirect to login page");
            model.addAttribute("user",user);
            view = "redirect:/login"; 
            return view;
        }                
    }

    @RequestMapping(value = "/video", params = {"id"}, method = RequestMethod.GET)
    public String showVideoPage(@RequestParam(value = "id") String id, Model model) {
        Video v=videoService.getVideo(Long.valueOf(id));
        v.setViewCount(v.getViewCount()+1);        
        videoService.saveVideo(v);
        model.addAttribute("video", v);                
        return "video";
    }
    
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchVideo(Model model) {
        List<Video> videoList = videoService.getVideos();
        model.addAttribute("videoList", videoList);
        System.out.println("redirect to video page");
        return "search";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String watchVideo(Model model) {
        List<Video> videoList = videoService.getVideos();
        model.addAttribute("videoList", videoList);
        System.out.println("redirect to video page");
        return "search";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public ModelAndView uploadVideo() {
        return new ModelAndView("upload", "command", new Video());
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ModelAndView checkUloadVideo(@Valid Video video, BindingResult result, @RequestParam("file") MultipartFile file, @RequestParam("image") MultipartFile image) {
        String videoExt = FilenameUtils.getExtension(video.getFile().getOriginalFilename());
        System.out.println("extension : " + videoExt);
        video.setType(videoExt);
        String imageExt = FilenameUtils.getExtension(video.getImage().getOriginalFilename());
        System.out.println("extension : " + videoExt);
        video.setType(videoExt);
        video.setImageType(imageExt);
        video.setDate(Utility.getCurrentDate());
        if (result.hasErrors()) {
            return new ModelAndView("upload", "command", video);
        } else {
            videoService.uploadVideo(video);
            // save file;
            System.out.println("save");
            return new ModelAndView("upload", "command", new Video());
        }
    }

}
