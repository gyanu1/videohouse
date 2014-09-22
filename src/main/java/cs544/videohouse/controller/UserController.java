/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.videohouse.controller;

import cs544.videohouse.domain.User;
import cs544.videohouse.domain.Video;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLClassLoader;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
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

    @RequestMapping(value = "/video", method = RequestMethod.GET)
    public String showVideoPage() {
        System.out.println("redirect to video page");
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
    public String searchVideo() {
        System.out.println("redirect to video page");
        return "search";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public ModelAndView uploadVideo() {
        return new ModelAndView("upload", "command", new Video());
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ModelAndView checkUloadVideo(@Valid Video video, BindingResult result, @RequestParam("file") MultipartFile file, @RequestParam("image") MultipartFile image) {
        if (!file.isEmpty()) {
            try {
                 byte[] bytes = file.getBytes();
                //creating the directory to store file
               // String rootPath = System.getProperty("catalina.home");
                ClassLoader c = getClass().getClassLoader();
                URLClassLoader u = (URLClassLoader) c;
                URL[] urls = u.getURLs();
                String path = "";
                for (URL i : urls) {
                    if (i.toString().contains("WEB-INF")) {
                        path = i.toString();
                        System.out.println("url: " + i);
                        break;
                    }

                }
                String tokens[] = path.split("WEB-INF");
                path = tokens[0];
                path = path.replaceFirst("file:", "");
                File dir = new File(path + File.separator + "resources"+File.separator+"video");
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                //create the file on server
                File serverFile = new File(dir.getAbsolutePath() + File.separator + video.getTitle());

                BufferedOutputStream stream
                        = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();
                System.out.println("You successfully uploaded " + video.getTitle() + " into " + video.getTitle() + "-uploaded !");
            } catch (Exception e) {
                System.out.println("You failed to upload " + video.getTitle() + " => " + e.getMessage());
            }
        } else {
            System.out.println("You failed to upload " + video.getTitle() + " because the file was empty.");
        }
        if (result.hasErrors()) {
            return new ModelAndView("upload", "command", video);
        } else {
            // save file;
            System.out.println("save");
            return new ModelAndView("upload", "command", new Video());
        }
    }

}
