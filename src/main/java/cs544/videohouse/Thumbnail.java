/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.videohouse;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Bishal Timilsina
 */
public class Thumbnail {
    public static byte[] getThumbnail(String filePath){
    try {

        BufferedImage sourceImage = ImageIO.read(new File(filePath));
        int width = sourceImage.getWidth();
        int height = sourceImage.getHeight();

        if(width>height){
            float extraSize=    height-100;
            float percentHight = (extraSize/height)*100;
            float percentWidth = width - ((width/100)*percentHight);
            BufferedImage img = new BufferedImage((int)percentWidth, 100, BufferedImage.TYPE_INT_RGB);
            Image scaledImage = sourceImage.getScaledInstance((int)percentWidth, 100, Image.SCALE_SMOOTH);
            img.createGraphics().drawImage(scaledImage, 0, 0, null);
            BufferedImage img2 = new BufferedImage(100, 100 ,BufferedImage.TYPE_INT_RGB);
            img2 = img.getSubimage((int)((percentWidth-100)/2), 0, 100, 100);

            return extractBytes(img2);
        }else{
            float extraSize=    width-100;
            float percentWidth = (extraSize/width)*100;
            float  percentHight = height - ((height/100)*percentWidth);
            BufferedImage img = new BufferedImage(100, (int)percentHight, BufferedImage.TYPE_INT_RGB);
            Image scaledImage = sourceImage.getScaledInstance(100,(int)percentHight, Image.SCALE_SMOOTH);
            img.createGraphics().drawImage(scaledImage, 0, 0, null);
            BufferedImage img2 = new BufferedImage(100, 100 ,BufferedImage.TYPE_INT_RGB);
            img2 = img.getSubimage(0, (int)((percentHight-100)/2), 100, 100);

            return extractBytes(img2);
        }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    public static byte[] extractBytes (BufferedImage bufferedImage) throws IOException {
        // get DataBufferBytes from Raster        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	ImageIO.write( bufferedImage, "jpg", baos );
	baos.flush();
	byte[] imageInByte = baos.toByteArray();
	baos.close();

        return imageInByte;
   }
}
