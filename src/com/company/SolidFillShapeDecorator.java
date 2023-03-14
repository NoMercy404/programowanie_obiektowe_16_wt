package com.company;

public class SolidFillShapeDecorator extends ShapeDecorator{
    private String color;

    public SolidFillShapeDecorator(Shape decoratedShape, String color) {
        super(decoratedShape);
        this.color = color;
    }
    @Override
    public String toSvg(String parameters){
        return super.toSvg("fill=\""+this.color+"\""+parameters);
    }
}
