/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.videohouse.util;

import cs544.videohouse.domain.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.ui.Model;

/**
 *
 * @author Bishal Timilsina
 */
@Aspect
public class Welcome {
    
    public static String recentUpload="";
    public static int rId=0;
    
    @Around("execution(* cs544.videohouse.controller.VideoController.checkUploadVideo(..))")
    public String greet(ProceedingJoinPoint call) throws Throwable{
        Object [] args= call.getArgs();
//        User u=(User) args[0];        
//        System.out.println("Before: Hi "+u.getFirstName()+"!");
        String view=(String) call.proceed(args);        
//        args= call.getArgs();
//        u=(User) args[0];                
        if(view.contains("#")){
            rId=Integer.valueOf(view.split("#")[2]);
            recentUpload="Latest: "+view.split("#")[1]+"!";
            view=view.split("#")[0];
        }
        System.out.println("Will go next to: "+view);
        System.out.println("Latest:"+recentUpload);
        return view;
    }
    
}