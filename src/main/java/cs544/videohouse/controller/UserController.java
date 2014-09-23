/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.videohouse.controller;

import cs544.videohouse.BCrypt;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cs544.videohouse.domain.User;
import cs544.videohouse.service.IUserService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author GMaharjan
 */
@Controller
public class UserController {
    
    @Resource
    private IUserService userService;

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
    public String checkUserLogin(@Valid User user, BindingResult result) {
        String view="redirect:/login";      
        /*if (result.hasErrors()) {                        
            System.out.println("Result has error");
        }
        if(user.getEmail()==null || user.getPassword()==null)  {
            System.out.println("Had reached here!");
            return view;
        }*/
        User user_actual;
        try{
          user_actual=userService.getUser(user.getEmail());
        }catch(Exception e){
            System.out.println("No such User!!");
            return view;
        }
        if(BCrypt.checkpw(user.getPassword(), user_actual.getPassword())){
            System.out.println("redirect to video page");
            view = "redirect:/video";            
        }else{
            System.out.println("redirect to login page");            
        }   
        return view;
    }

    @RequestMapping(value = "/video", method = RequestMethod.GET)
    public String showVideoPage() {
        System.out.println("redirect to video page");
        return "video";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView redirectRegistration(@ModelAttribute("user") User user) {
        return new ModelAndView("registration", "command", user);
    }
    
//    @RequestMapping(value = "/register", method = RequestMethod.GET)
//    public String redirectRegistration(Model model) {
//        model.addAttribute("user", new User());
//        return "registration";
//    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView checkRegistration(@Valid @ModelAttribute User user, BindingResult result) {
        ModelAndView model_view = new ModelAndView("login", "command", new User());
        if (result.hasErrors()) {            
            model_view = new ModelAndView("registration", "command", user);
            System.out.println("redirect to registration page");
//            m.addAttribute("user",user);
        } else {            
            String password = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(5));
            user.setPassword(password);
            userService.createUser(user);
            System.out.println("redirect to login page");
//            m.addAttribute("message","Successfully saved "+user.getFirstName()+"!");
        }        
        return model_view;
    }
    
//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    public String checkRegistration(@Valid User user, BindingResult result) {
//       
//        if (result.hasErrors()) {            
//            return "register";
//        } else {            
//             String password = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(5));
//            user.setPassword(password);
//            userService.createUser(user);
//            System.out.println("redirect to login page");
//            return "redirect:login";
//        }        
//    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchVideo() {
        System.out.println("redirect to video page");
        return "search";
    }

}
