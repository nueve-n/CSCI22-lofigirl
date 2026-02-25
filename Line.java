/**
    The Line class is a required class.
    It serves as a template for drawing linear objects.

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

import java.awt.geom.*;
import java.awt.*;

public class Line implements DrawingObject{
    double xi, yi, xf, yf; // x initial/final, y initial/final
    float th; //thickness
    Color c;

    /**
        Constructs a Line with specific starting and ending coordinates, thickness, and color.
        @param xi The initial x-coordinate.
        @param yi The initial y-coordinate.
        @param xf The final x-coordinate.
        @param yf The final y-coordinate.
        @param th The thickness of the line (stroke width).
        @param c  The color of the line.
    */
    public Line(double xi, double yi, double xf, double yf, float th, Color c){
        this.xi = xi;
        this.yi = yi;
        this.xf = xf;
        this.yf = yf;

        this.th = th;
        this.c = c;
    }

    /**
        Defines the line so it can be rendered.
        It sets the color and stroke thickness before drawing the Line2D shape.
        @param g2d The Graphics2D object used for rendering.
    */
    @Override
    public void draw(Graphics2D g2d){
        Line2D.Double line = new Line2D.Double(xi, yi, xf, yf);
        g2d.setColor(c);
        g2d.setStroke(new BasicStroke(th));
        g2d.draw(line);
    }
}