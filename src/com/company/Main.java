package com.company;

import java.util.ArrayList;
import java.util.Locale;


public class Main {
    public static final Point test = new Point(2,3);

    public static void main(String[] args) {
        Shape poly = new Polygon(new Vec2[]{new Vec2(120,60), new Vec2(270,280), new Vec2(240,320), new Vec2(110,80)});
   
        SvgScene scene=new SvgScene();
        scene.add(poly);
        scene.saveHtml("scene.html");
    }
}
