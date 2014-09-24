/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.videohouse.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author GMaharjan
 */
@Documented
@Constraint(validatedBy = VideoConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)

public @interface ValidVideo {

    String message() default "Video should be of .ogg or .mp4 or .webM and size less than 20MB";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
