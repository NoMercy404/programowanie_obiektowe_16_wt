package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class SvgScene {
    private Shape shapes[] = new Shape[0];

    public void addShape(Shape poly) {
        shapes = Arrays.copyOf(shapes, shapes.length + 1);
        shapes[shapes.length - 1] = poly;
    }

    public void saveHtml(String path) {
        try {
            FileWriter file = new FileWriter(path);
            file.write("<html>\n<body>\n");
            file.write(String.format("<svg width=1000 height=1000>\n"));
            for(Shape shape : shapes)
                file.write("\t"+ shape.toSvg("")+"\n");
            file.write("</svg>\n</body>\n</html>\n");
            file.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
