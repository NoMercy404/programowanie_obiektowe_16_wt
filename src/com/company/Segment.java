package com.company;

import java.util.Locale;

public class Segment {
    private Point p1;
    private Point p2;
//" <line x1="20" y1="20" x2="80" y2="80" style="stroke:black" />"
//    String test = String.format(Locale.ENGLISH, " %f ", 2);

    //http://maxima.cesga.es/
    //solve([y1=a*x1+b, ((x0-x1)^2 + (y0-y1)^2)=r*r],[x1,y1]);

    public Segment(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
//        points = new Point[] {
//                new Point(2,3),
//                new Point(2,4)
//        };
//        points[1] = new Point(2,3);
    }

    public Point getP1() {
        return p1;
    }

//    public void setP1(Point p1) {
//        this.p1 = p1;
//    }

    public Point getP2() {
        return p2;
    }

//    public void setP2(Point p2) {
//        this.p2 = p2;
//    }

    public String getSvg(){
        String result = String.format(Locale.ENGLISH,"<line x1=\"%.2f\" y1=\"%.2f\" x2=\"%.2f\" y2=\"%.2f\" style=\"stroke:black\" />",p1.x,p1.y,p2.x,p2.y);
        return result;
    }

    public double getDistance(){
        double result = Math.sqrt(Math.pow(p1.x-p2.x, 2))+Math.sqrt(Math.pow(p1.y-p2.y, 2));
        return result;
    }
}
