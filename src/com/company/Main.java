package com.company;

import java.util.ArrayList;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Shape poly = new Polygon(new Vec2[]{new Vec2(120,60), new Vec2(270,280), new Vec2(240,320), new Vec2(110,80)});
        Shape elipse = new Ellipse(new Vec2(3.14 ,14.3),100 ,100);
        poly = new SolidFillShapeDecorator(poly, "green");
        poly = new StrokeShapeDecorator(poly, "blue", "10");
        elipse = new SolidFillShapeDecorator(elipse , "red");

        Shape translatedPoly =
                new TransformationDecorator.Builder()
                        .setTranslateVector(new Vec2(3.14 ,14.3))
                        .setTranslateVector(new Vec2(4.14 ,14.3))
                        .build(poly);


        SvgScene scene=new SvgScene();
        scene.addShape(poly);
        scene.addShape(elipse);
        scene.addShape(translatedPoly);

        scene.saveHtml("scene.html");
    }

}
