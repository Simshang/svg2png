package me.ele.batik;

/**
 * Created by Shang on 2016/8/22.
 */

import java.io.File;

public class svg2png {

    private static final int DPI = 72;
    private static final String newline = "\n";
    private float baseDensity = Density.MDPI.getMultiplier();


    public static void main(String[] args) {

        System.out.println("开始转换......");

        String svgFolder = "./svgs";
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
            File destination = new File(getResourceDir(density,svgFolder,ttfName),
                    getDestinationFile(file.getName()));
            converter.transcode(svgResource, density, destination, baseDensity);
            System.out.print(file.getName() + " convert to " + density.name() + " finish"
                    + newline);
        }
        System.out.print(file.getName() + " convert all finished" + newline);
    }

    private File getResourceDir(Density density,String svgFolder,String ttfName) {
        File folder = new File(svgFolder);
        if (!folder.isDirectory()) {
            svgFolder = folder.getParent();
        }
        File file = new File(svgFolder, "../../pngs/"+ttfName+'/'
                + density.name().toLowerCase());
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private String getDestinationFile(String name) {
        int suffixStart = name.lastIndexOf('.');
        return suffixStart == -1 ? name : name.substring(0, suffixStart)
                + ".png";
    }
}

