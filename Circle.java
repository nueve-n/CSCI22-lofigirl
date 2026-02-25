/**
    The Circle class is a required class. 
    It serves as a template for drawing circular objects

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

public class Circle implements DrawingObject{
    private double x, y, size;
    private Color color;

    /**
        Constructs a Circle with a specific position, size, and color.
        @param x The x-coordinate of the circle's bounding box.
        @param y The y-coordinate of the circle's bounding box.
        @param size The diameter of the circle.
        @param color The color used to fill the circle.
    */
    public Circle(double x, double y, double size, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }

    /**
        Defines the shape so it can be rendered onto the canvas.
        It sets the current Graphics2D color and fills an Ellipse2D shape.
        @param g2d The Graphics2D object used for drawing.
    */
    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.fill(new Ellipse2D.Double(x, y, size, size));
    }
}
