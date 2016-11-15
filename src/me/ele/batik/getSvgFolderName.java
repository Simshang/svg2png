package me.ele.batik;

import java.io.File;

/**
 * Created by Shang on 2016/8/23.
 */
public class getSvgFolderName {

    public static void main(String[] args) {
        String svgFolder = "./svgs";
        File svg = new File(svgFolder);
        File[] files = svg.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println(svgFolder+'/'+file.getName());

            }
        }


    }


}
