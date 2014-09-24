/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.videohouse.controller;

import cs544.videohouse.domain.Video;
import cs544.videohouse.service.VideoService;
import cs544.videohouse.util.Utility;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author gyanu
 */
@Controller
public class VideoController {

    @Autowired
    @Qualifier("videoValidator")
    private Validator validator;

    @Autowired
    private VideoService videoService;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String uploadVideo(Model model) {
        model.addAttribute("video", new Video());
        return "upload";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String checkUploadVideo(@Validated Video video, BindingResult result,final RedirectAttributes redirectAttributes) {
        String videoExt = FilenameUtils.getExtension(video.getFile().getOriginalFilename());
        System.out.println("extension : " + videoExt);
        video.setType(videoExt);
        String imageExt = FilenameUtils.getExtension(video.getImage().getOriginalFilename());
        System.out.println("extension : " + videoExt);
        video.setType(videoExt);
        video.setImageType(imageExt);
        video.setDate(Utility.getCurrentDate());
        System.out.println(result.toString());
        if (result.hasErrors()) {
            return "upload";
        } else {
            videoService.uploadVideo(video);
            redirectAttributes.addFlashAttribute("successMessage", video.getTitle()+" video successfully uploaded.");
            // save file;
            System.out.println("save");
            return "redirect:/upload";
        }
    }

}
