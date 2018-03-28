/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1_spritemap;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author MacBook
 */

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;
import sun.rmi.runtime.Log;
public class Bai1_SpriteMap {

    public Bai1_SpriteMap() {
    }
    //input thư mục chứa những sprite ban đầu, output là nơi chứa spritemap
    public static void join(String inputPath,String outputPath) throws IOException{
        //Mở thư mục, tham chiếu directory dữ thư mục
        File directory= new File(inputPath);
        //
        File[] files=directory.listFiles();
        System.out.println(files.length);
        //đọc thư mục đầu tiên
        BufferedImage sprite= ImageIO.read(files[0]);
        int with=sprite.getWidth()*files.length;
        int height=sprite.getHeight();
        System.out.println(with);
        System.out.println(height);
        //xây dựng spritemap(1 map gồm nhiều sprite) bằng buffered (mỗi tấm ảnh là 1 sprite)
        BufferedImage spritemap = new BufferedImage(with, height,BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d=spritemap.createGraphics();
       int x=0;//vị trí bắt đầu của sprite tiếp theo
       for(File file:files){
           //tải sprite lên
           sprite=ImageIO.read(file);
           //vẽ sprite lên spritemap
           g2d.drawImage(sprite, null, x,0);
           x+=sprite.getWidth();
       }
       //ghi spritemap ra ổ cứng
       ImageIO.write(spritemap, "png", new File(outputPath));
    }

public void sub(String inputPath,String outputPath) throws IOException{

        File directory= new File(inputPath);
        
        BufferedImage spritesheet = ImageIO.read(directory);
       
        int subWith=64;
        int subHeight=64;
        int num = spritesheet.getWidth()/subWith;
         System.out.println(spritesheet.getWidth()/subWith);
        int x =0;
        for(int i = 0; i < num; i++){
            BufferedImage subimage = spritesheet.getSubimage(x, 0, 64, 64);
            ImageIO.write(subimage, "png", new File(outputPath+i+"_pokemon.png"));
            x +=64;
        }
    }
    public static void main(String[] args) {
        try{
            Bai1_SpriteMap smm = new Bai1_SpriteMap();
            smm.sub("C:\\Users\\MacBook\\Desktop\\pokemon.png", "C:\\Users\\MacBook\\Desktop\\");
                    }catch(IOException ex){
            System.err.println(ex);}
        
    }
}
