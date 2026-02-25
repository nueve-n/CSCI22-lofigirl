/**
    The Quadrilateral class is one of the authors' basic shapes.
    It uses the Path2D class to serve as a template for drawing quadrilateral objects.

    @author Fiona Nadine Macalalag (253550)
    @author John Carlo Ranario (254815)
    @version February 26, 2026

    We have not discussed the Java language code in my program
    with anyone other than our instructor or the teaching assistants
    assigned to this course.

    We have not used Java language code obtained from another student,
    or any other unauthorized source, either modified or unmodified.
    
    If any Java language code or documentation used in our program
    was obtained from another source, such as a textbook or website,
    that has been clearly noted with a proper citation in the comments
    of my program.
*/

import java.awt.*;
import java.awt.geom.*;

public class Quadrilateral implements DrawingObject{
    double x1, y1, x2, y2, x3, y3, x4, y4;
    Color color;

    /**
        Constructs a Quadrilateral with four specific vertices and a fill color.
        @param x1 The x-coordinate of the first point.
        @param y1 The y-coordinate of the first point.
        @param x2 The x-coordinate of the second point.
        @param y2 The y-coordinate of the second point.
        @param x3 The x-coordinate of the third point.
        @param y3 The y-coordinate of the third point.
        @param x4 The x-coordinate of the fourth point.
        @param y4 The y-coordinate of the fourth point.
        @param color The color used to fill the shape.
    */
    public Quadrilateral(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.x4 = x4;
        this.y4 = y4;
        this.color = color;
    } 

    /**
        Renders the quadrilateral by defining a path through the four points.
        @param g2d The Graphics2D object used for drawing.
    */
    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(color);
        Path2D.Double quadrilateral = new Path2D.Double();
        quadrilateral.moveTo(x1, y1);
        quadrilateral.lineTo(x2, y2);
        quadrilateral.lineTo(x3, y3);
        quadrilateral.lineTo(x4, y4);
        quadrilateral.closePath();
        g2d.fill(quadrilateral);
    }
}
