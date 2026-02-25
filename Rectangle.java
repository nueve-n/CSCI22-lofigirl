/**
    The Rectangle class is one of the authors' basic shapes.
    It uses the Rectangle2D class to serve as a template for drawing rectangular objects.

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

public class Rectangle implements DrawingObject{
    double x, y, w, h;
    Color color;

    /**
        Constructs a Rectangle with a specific position, size, and color.
        @param x The x-coordinate of the rectangle.
        @param y The y-coordinate of the rectangle.
        @param w The width of the rectangle.
        @param h The height of the rectangle.
        @param color The color used to fill the rectangle.
    */
    public Rectangle(double x, double y, double w, double h, Color color) {
        this.x = x;
        this.y= y;
        this.w = w;
        this.h = h;
        this.color = color;
    }

    /**
        Renders the rectangle.
        @param g2d The Graphics2D object used for drawing.
    */
    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.fill(new Rectangle2D.Double(x, y, w, h));
    }

    /**
        Updates the current color of the rectangle.
        @param c The new Color to be applied.
    */
    public void changeColor(Color c){
        color = c;
    }

}
