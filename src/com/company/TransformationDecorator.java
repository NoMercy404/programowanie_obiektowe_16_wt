package com.company;

public class TransformationDecorator extends ShapeDecorator {
    boolean translate;
    Vec2 translateVector;

    public TransformationDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public String toSvg(String parameters) {
        String result = "";

        if(this.translate) {
            result += "transform=";
        }

        return result;
    }

    public static class Builder {
        boolean translate = false;
        Vec2 translateVector;

        public Builder setTranslateVector(Vec2 translateVector) {
            this.translate = true;
            this.translateVector = translateVector;
            return this;
        }

        public TransformationDecorator build(Shape shape) {
            TransformationDecorator result = new TransformationDecorator(shape);
            if(this.translate) {
                result.translateVector = this.translateVector;
                result.translate = this.translate;
            }

            return result;
        }
    }
}
