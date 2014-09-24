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
class ImageConstraintValidator implements ConstraintValidator<Image, MultipartFile> {

    @Override
    public void initialize(Image constraintAnnotation) {
    }

    @Override
    public boolean isValid(MultipartFile image, ConstraintValidatorContext context) {
        boolean valid=true;
        if(image.isEmpty()){
            valid=false;
        }else{
            String imageExt = FilenameUtils.getExtension(image.getOriginalFilename());
            if (!"png".equals(imageExt) && !"jpg".equals(imageExt) && !"jpeg".equals(imageExt) && !"bmp".equals(imageExt)) {
                valid = false;
            }
        }
        return valid;
    }

}
