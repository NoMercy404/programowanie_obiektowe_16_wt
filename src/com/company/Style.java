package com.company;

public class Style {
    public final String fillColor;
    public final String strokeColor;
    public final Double strokeWidth;

    public Style(String fillColor, String strokeColor, Double strokeWidth) {
        this.fillColor = fillColor;
        this.strokeColor = strokeColor;
        this.strokeWidth = strokeWidth;
    }


    public String toSvg(){
        String fill = this.fillColor == null ? "transparent" : this.fillColor;
        String stroke = this.strokeColor == null ? "#000" : this.strokeColor;
        String strokeWidth = this.strokeWidth == null ? "1px" : this.strokeWidth.toString();
        String svg = String.format("style=\"fill=\"%s\" stroke=\"%s\" stroke-width=\"%s\"", fill , stroke, strokeWidth);
        return svg;
    }
}
