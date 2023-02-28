package com.company;

public class Main {
    public static void main(String[] args) {
        Point point = new Point(1,1);
        Segment segment = new Segment(point, new Point(2,2));
        System.out.println(segment.getSvg());
    }
}
