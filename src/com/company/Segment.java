package com.company;

import java.util.Locale;

public class Segment extends Shape {
    private Point p1;
    private Point p2;

    public Segment(Point p1, Point p2, Style style) {
        super(style);

        this.p1 = p1;
        this.p2 = p2;
    }

    public Segment(Point p1, Point p2) {
        super(new Style(null,null, null));

        this.p1 = p1;
        this.p2 = p2;
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

//    public void setP2(Point p2) {
//        this.p2 = p2;
//    }

    public String toSvg(){
        String result = String.format(Locale.ENGLISH,"<line x1=\"%.2f\" y1=\"%.2f\" x2=\"%.2f\" y2=\"%.2f\" style=\"stroke:black\" />",p1.x,p1.y,p2.x,p2.y);
        return result;
    }

    public double getDistance(){
        double result = Math.sqrt(Math.pow(p1.x-p2.x, 2))+Math.sqrt(Math.pow(p1.y-p2.y, 2));
        return result;
    }

    public static Segment[] perpendicular(Segment line, Point point, double r) {
        double a;
        a = (line.p1.y - line.p2.y) / (line.p1.x - line.p2.x);
        double b;
        a=-1/a;
        b=point.y-a*point.x;

        double x0 = point.x;
        double y0 = point.y;
        //double r = line.distance();

        double root = Math.sqrt(-y0*y0+(2*a*x0+2*b)*y0-a*a*x0*x0-2*a*b*x0+(a*a+1)*r*r-b*b);
        double x1 = -(root-a*y0-x0+a*b)/(a*a+1);
        double y1 = -(a*root-a*a*y0-a*x0-b)/(a*a+1);
        double x2 = (root+a*y0+x0-a*b)/(a*a+1);
        double y2 = (a*root+a*a*y0+a*x0+b)/(a*a+1);

        return new Segment[]{new Segment(point, new Point(x1,y1)), new Segment(point, new Point(x2,y2))};
    }
}
