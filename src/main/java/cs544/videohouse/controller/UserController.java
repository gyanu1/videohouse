/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.videohouse.controller;

import cs544.videohouse.domain.User;
import cs544.videohouse.domain.Video;
import cs544.videohouse.service.VideoService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String redirectlogin(Model model) {
        System.out.println("redirect to login page");
        model.addAttribute("user", new User());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String checkUserLogin(@ModelAttribute("user") @Valid User user, BindingResult result, Model model) {
        System.out.println(result.toString());
        if (result.hasErrors()) {

            // model.addAttribute("user", user);
            return "login";
        } else {
            //check credentials
            System.out.println("redirect to login page");
            return "redirect:/video";
        }

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
}
