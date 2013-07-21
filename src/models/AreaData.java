package models;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: labuser
 * Date: 7/19/13
 * Time: 3:13 AM
 * To change this template use File | Settings | File Templates.
 */
public class AreaData {
    private int id;
    private String areaName;


    private double volumn;
    private double thickness;
    private double surface;
    private String brainLR; // left or right
    //private double zscore;

    private int status;



    public AreaData(String areaName, double volumn, double thickness, double surface) {
        this.areaName = areaName;
        this.volumn = volumn;
        this.thickness = thickness;
        this.surface = surface;
       // this.zscore = zscore;


    }

    public double getVolumn() {
        return volumn;
    }

    public String getAreaName() {
        return areaName;
    }

    public double getThickness() {
        return thickness;
    }

    public double getSurface() {
        return surface;
    }

    public String getBrainLR() {
        return brainLR;
    }

//    public double getZscore() {
//        return zscore;
//    }




}
