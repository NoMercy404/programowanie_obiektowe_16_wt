package com.company;

public class SolidFilledPolygon extends Polygon{
    private String color;
    SolidFilledPolygon(String color,Vec2 Points[] ){
        super(Points);
        this.color=color;
    }
    public String toSvg(String parameters){
        return super.toSvg("fill=\""+this.color+"\"");
    }
}
