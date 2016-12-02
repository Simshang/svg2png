package me.ele.batik;

/**
 * Created by Shang on 2016/8/22.
 */

import java.io.File;

public class svg2png {

    private static final int DPI = 64;
    private static final String newline = "\n";
    private float baseDensity = Density.StdDPI.getMultiplier();


    public static void main(String[] args) {

        System.out.println("开始转换......");

        String svgFolder = "./relabel/labels";
        File svg = new File(svgFolder);
        File[] files = svg.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println(svgFolder+'/'+file.getName());
                String newSvgFolder = svgFolder+'/'+file.getName();
                svg2png SvgToPng = new svg2png();
                SvgToPng.startConvert(newSvgFolder,file.getName());
            }
        }

    }

    private void startConvert(String svgFolder, String ttfName){
        Converter converter = new Converter();
        File folder = new File(svgFolder);
        if (!folder.isDirectory()) {
            convertOneSvgFile(converter, folder,svgFolder, ttfName);
            return;
        }

        File[] files = folder.listFiles();
        if (files == null || files.length == 0) {
            String string = " does not have a svg file";
            System.out.print(folder.getAbsolutePath() + string + newline);
            return;
        }

        for (File file : files) {

            if (!file.getName().endsWith(".svg")) {
                System.out.print(file.getAbsolutePath() + " is not a svg file" + newline);
                continue;
            }

            convertOneSvgFile(converter, file, svgFolder, ttfName);
        }
    }

    private void convertOneSvgFile(Converter converter, File file, String svgFolder, String ttfName) {
        SVGResource svgResource = new SVGResource(file, DPI);
        for (Density density : Density.values()) {
            File destination = new File(getResourceDir(svgFolder,ttfName,density),
                    getDestinationFile(density,file.getName()));
            converter.transcode(svgResource, density, destination, baseDensity);
            System.out.print(file.getName() + " convert to " + density.name() + " finish"
                    + newline);
        }
        System.out.print(file.getName() + " convert all finished" + newline);
    }

    private File getResourceDir(String svgFolder,String ttfName, Density density) {
        File folder = new File(svgFolder);
        if (!folder.isDirectory()) {
            svgFolder = folder.getParent();
        }

        //先按照字符然后按照大小分类
        //File file = new File(svgFolder, "../../../pngs/"+ttfName+'/'+ density.name().toLowerCase());

        // 按照字符分类, 不同大小在一起
        //File file = new File(svgFolder, "../../../png2jpg/pngs/"+ttfName);

        //先按照大小分类然后按照字符分类
        //File file = new File(svgFolder, "../../../pngs/"+density.name().toLowerCase()+'/'+ttfName );

        //按照大小分类, 不同字符在一起
        File file = new File(svgFolder, "../../../png2jpg/pngs/"+density.name().toLowerCase());


        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private String getDestinationFile(Density density,String name) {
        int suffixStart = name.lastIndexOf('.');
        return suffixStart == -1 ? name : name.substring(0, suffixStart)
                + "_" +density.name().toLowerCase() +".png";
    }
}

