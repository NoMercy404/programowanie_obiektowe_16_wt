package com.company;

import java.util.Locale;

public class Elipse extends Shape{
    private Point center;
    private double rx,ry;
    public Elipse(Point point1,double x,double y,Style styl){
        super(styl);
        this.center=point1;
        this.rx=x;
        this.ry=y;
    }
    public String toSvg(){
        return String.format(Locale.ENGLISH,"<ellipse cx=\"%f\" cy=\"%f\" rx=\"%f\" ry=\"%f\"\n" +
                "  style=\"%s\" />",center.x,center.y,rx,ry, this.style.toSvg());
    }
}
