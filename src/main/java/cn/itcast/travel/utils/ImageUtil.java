package cn.itcast.travel.utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class ImageUtil {
    /**
     * 随机生成验证码图片
     * @param width 图片宽度 80
     * @param height 图片高度 35
     * @param imageType 图片格式 BGR
     * @param imageContent  图片验证码
     * @return
     */
    //创建一个图片
    public static BufferedImage createImage(int width, int height, int imageType, String imageContent) {
        BufferedImage image = new BufferedImage(width, height, imageType);

        //获取画笔
        Graphics g = image.getGraphics();
        //设置画笔颜色为灰色
        g.setColor(Color.pink);
        //填充图片
        g.fillRect(0, 0, width, height);


        //设置画笔颜色为黄色
        g.setColor(Color.YELLOW);
        //设置字体的小大
        g.setFont(new Font("黑体", Font.BOLD, 24));
        //向图片上写入验证码  画
        g.drawString(imageContent, 15, 25);

        return image;
    }

    /**
     * 产生4位随机字符串
     */
    public static String getCheckCode() {
        String base = "0123456789ABCDEFGabcdefg";
        int size = base.length();  //20
        Random r = new Random();
        StringBuffer sb = new StringBuffer();  //String
        for (int i = 1; i <= 4; i++) {
            //产生0到size-1的随机值
            int index = r.nextInt(size); //10
            //在base字符串中获取下标为index的字符
            char c = base.charAt(index);  //10
            //将c放入到StringBuffer中去
            sb.append(c);   //1A5f
        }
        return sb.toString();
    }

}
