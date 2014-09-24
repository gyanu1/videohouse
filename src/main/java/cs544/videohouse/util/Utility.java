/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.videohouse.util;

import cs544.videohouse.domain.Video;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Date;

/**
 *
 * @author GMaharjan
 */
public class Utility {

    public static Date getCurrentDate() {
        return new Date();
    }

    public static boolean saveVideoAndImageFile(Video video) {
        boolean saved = false;

        if (!video.getFile().isEmpty()) {
            try {
                byte[] videoBytes = video.getFile().getBytes();

                //creating the directory to store file
                // String rootPath = System.getProperty("catalina.home");
                ClassLoader c = Utility.class.getClassLoader();
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
                File videodir = new File(path + File.separator + "resources" + File.separator + "video");

                if (!videodir.exists()) {
                    videodir.mkdirs();
                }
                //create the file on server
                File serverFile = new File(videodir.getAbsolutePath() + File.separator + video.getId() + "." + video.getType());

                if (!video.getImage().isEmpty()) {
                    byte[] imageBytes = video.getImage().getBytes();
                    File imagedir = new File(path + File.separator + "resources" + File.separator + "img");
                    if (!imagedir.exists()) {
                        videodir.mkdirs();
                    }
                    File imageFile = new File(imagedir.getAbsolutePath() + File.separator + video.getId() + "." + video.getImageType());
                    try (BufferedOutputStream imageStream = new BufferedOutputStream(new FileOutputStream(imageFile))) {
                        imageStream.write(imageBytes);
                    }
                }
                try (BufferedOutputStream videoStream = new BufferedOutputStream(new FileOutputStream(serverFile))) {
                    videoStream.write(videoBytes);
                }
                saved = true;
                System.out.println("You successfully uploaded " + video.getTitle() + " into " + video.getTitle() + "-uploaded !");
            } catch (Exception e) {
                System.out.println("You failed to upload " + video.getTitle() + " => " + e.getMessage());
            }
        } else {
            System.out.println("You failed to upload " + video.getTitle() + " because the file was empty.");
        }
        return saved;
    }

}
