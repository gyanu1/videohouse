/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.videohouse.controller;

import cs544.videohouse.domain.User;
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

/**
 *
 * @author GMaharjan
 */
@Controller
public class UserController {

    @Autowired
    private VideoService videoService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView redirectlogin() {
        System.out.println("redirect to login page");
        return new ModelAndView("login", "command", new User());
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String checkUserLogin() {
        System.out.println("redirect to login page");
        return "redirect:/video";
    }

    @RequestMapping(value = "/video", params = {"id"}, method = RequestMethod.GET)
    public String showVideoPage(@RequestParam(value = "id") String id, Model model) {
        model.addAttribute("video", videoService.getVideo(Long.valueOf(id)));
        return "video";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView redirectRegistration() {
        return new ModelAndView("registration", "command", new User());
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String checkRegistration(@Valid User user, BindingResult result) {
        String view = "redirect:/login";

        if (result.hasErrors()) {
            view = "register";
        } else {
            // save user #bishal;
        }
        System.out.println("redirect to registration page");
        return view;
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
