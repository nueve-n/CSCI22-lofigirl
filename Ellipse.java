/**
    The Ellipse class is one of the authors' basic shapes.
    It uses the Java2D Ellipse2D class to serve as a template for drawing elliptical objects.

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

public class Ellipse implements DrawingObject{

    private double x, y, w, h;
    private Color color;

    /**
        Constructs an Ellipse with a specific position, width, height, and color.
        @param x The x-coordinate of the upper-left corner of the framing rectangle.
        @param y The y-coordinate of the upper-left corner of the framing rectangle.
        @param w The overall width of the ellipse.
        @param h The overall height of the ellipse.
        @param color The color used to fill the ellipse.
    */
    public Ellipse(double x, double y, double w, double h, Color color){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.color = color;  
    }

    /**
        Defines the shape so it can be rendered onto the canvas.
        It sets the current Graphics2D color and fills an Ellipse2D shape.
        @param g2d The Graphics2D object used for drawing.
    */
    @Override
    public void draw(Graphics2D g2d) {
        Ellipse2D.Double c = new Ellipse2D.Double(x, y, w, h);
        g2d.setColor(color);
        g2d.fill(c);
    }

}