package com.company;

import java.io.FileWriter;
import java.util.ArrayList;

public class SvgScene {
    int width = 0, height = 0;
    ArrayList<Polygon> polygons = new ArrayList<>();
    private void addPolygon(Polygon polygon){
        polygons.add(polygon);
        Point point = polygon.getMaxCords();
        height = (int)Math.max(point.y, height);
        width = (int)Math.max(point.x, width);
    }

    public void save(String fileName){
        try {
            FileWriter fw
                    = new FileWriter(fileName);
            String html = " <html>\n" +
        "<body>\n" +
        "<svg width=\" "+ width +" \" height=\""+ height +"\">\n";

        for(Polygon polygon : polygons){
            html += polygon.toSvg();
        }

        html+= "</svg>\n" +
        "\n" +
        "</body>\n" +
        "</html> ";

            fw.close();
        }
        catch (Exception e) {
            e.getStackTrace();
        }

    }
}

