/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.videohouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author GMaharjan
 */
@Controller
public class UserController {

    @RequestMapping("/")
    public String redirectRoot() {
            return "redirect:/login";
    }
    
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

    @RequestMapping(value="/video",method = RequestMethod.GET)
    public String showVideoPage() {
        System.out.println("redirect to video page");
        return "video";
    }
    
	@RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView redirectRegistration() {
        return new ModelAndView("registration", "command",new User());
    }

	@RequestMapping(value = "/register", method = RequestMethod.POST)
    public String checkRegistration() {
        System.out.println("redirect to registration page");
        return "redirect:/login";
    }
	
	@RequestMapping(value="/search",method = RequestMethod.POST)
    public String searchVideo() {
        System.out.println("redirect to video page");
        return "search";
    }

}
