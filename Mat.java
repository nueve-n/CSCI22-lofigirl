/**
    The Mat class represents a mat in the scene. 
    It is built using two ellipse objects.
    It can be moved.

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

public class Mat implements DrawingObject{
    double x, y, w, h;
    Color co, ci;

    /**
        Constructs a Mat with specified positions, dimensions, and color palette.
        @param x The x-coordinate of the mat.
        @param y The y-coordinate of the mat.
        @param w The width of the mat.
        @param h The height of the mat.
        @param co The color of the outer ellipse.
        @param ci The color of the inner ellipse.
    */
    public Mat(double x,double y,double w, double h, Color co, Color ci){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.co = co;
        this.ci = ci;
    }

    /**
        Defines the shapes of the mat so it can be rendered.
        @param g2d The Graphics2D object used for rendering.
    */
    @Override
    public void draw(Graphics2D g2d){
        Ellipse outer = new Ellipse(x, y, w, h, co);
        outer.draw(g2d);

        Ellipse inner = new Ellipse(x + w * 0.05, y + h*0.05, w * 0.9, h *0.9, ci);
        inner.draw(g2d);
    }

    /**
        Increments the X position of the mat.
        @param d The amount to change the x-coordinate by.
    */
    public void moveX(double d){
        x += d;
    }

    /**
        Returns the current x-coordinate of the mat.
        @return The x-coordinate.
    */
    public double getX(){
        return x;
    }

    /**
        Returns the width of the mat.
        @return The width.
    */
    public double getW(){
        return w;
    }
}