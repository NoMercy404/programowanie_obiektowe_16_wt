package com.company;

public class StrokeShapeDecorator extends ShapeDecorator{
    private String color;
    private String width;

    public StrokeShapeDecorator(Shape decoratedShape, String color, String width) {
        super(decoratedShape);
        this.color = color;
        this.width = width;
    }
    @Override
    public String toSvg(String parameters){
        return super.toSvg("stroke=\""+this.color+"\"stroke=\""+this.width+"\""+parameters);
    }
}
