/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.videohouse.validator;

import cs544.videohouse.domain.Video;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author gyanu
 */
@Component(value = "videoValidator")
public class VideoValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Video.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        System.out.println("inside method validate VideoValidator");
        Video video = (Video) target;
        if (!video.getImage().isEmpty()) {
            String imageExt = FilenameUtils.getExtension(video.getImage().getOriginalFilename());
            if (!"png".equalsIgnoreCase(imageExt) && !"jpg".equalsIgnoreCase(imageExt) && !"jpeg".equalsIgnoreCase(imageExt) && !"bmp".equalsIgnoreCase(imageExt)) {
                 errors.rejectValue("image", "image.required", "image should have proper format");
            }
        }else{
        	  errors.rejectValue("image", "image.required", "image is required");
        }

        if (!video.getFile().isEmpty()) {
            String videoExt = FilenameUtils.getExtension(video.getFile().getOriginalFilename());
            if (!"mp4".equalsIgnoreCase(videoExt) && !"ogg".equalsIgnoreCase(videoExt) && !"ogv".equalsIgnoreCase(videoExt) && !"webM".equalsIgnoreCase(videoExt)) {
                errors.rejectValue("file", "video.required", "video should be proper format");
            }
            long bytes = video.getFile().getSize();
            if (bytes > 20000000) {
                  errors.rejectValue("file", "video.required", "video size should be less than 20mb");
            }
        }else{
            errors.rejectValue("file", "video.required", "video is required");
        }
        
        System.out.println("errors : "+ errors.toString());
    }

}
