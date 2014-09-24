/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.videohouse.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.commons.io.FilenameUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author GMaharjan
 */
@Component
@Scope("prototype")
class VideoConstraintValidator implements ConstraintValidator<ValidVideo, MultipartFile> {

    @Override
    public void initialize(ValidVideo constraintAnnotation) {
    }

    @Override
    public boolean isValid(MultipartFile video, ConstraintValidatorContext context) {
        System.out.println("inside video validation method");
        boolean valid = true;
        if (video.isEmpty()) {
            valid = false;
        } else {
            String videoExt = FilenameUtils.getExtension(video.getOriginalFilename());
            if (!"mp4".equals(videoExt) && !"ogg".equals(videoExt) && !"ogv".equals(videoExt) && !"webM".equals(videoExt)) {
                valid = false;
            }
            long bytes = video.getSize();
            if(bytes> 20000000){
                valid=false;
            }
            System.out.println("size : " + bytes);
        }
        return valid;
    }

}
