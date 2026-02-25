/**
    The Sky class represents the visible exterior background of the scene. 
    It draws the various layers of the sky and allows for color changes.

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

public class Sky implements DrawingObject{
    Color c1, c2, c3;
    double w, h;

    /**
        Constructs the Sky in proportion to frame dimensions.
        @param w The width of the scene.
        @param h The height of the scene.
        @param c1 Color 1 of the sky.
        @param c2 Color 2 of the sky.
        @param c3 Color 3 of the sky.
    */
    public Sky(double w, double h, Color c1, Color c2, Color c3){
        this.w = w;
        this.h = h;
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
    }

    /**
        Renders the sky using Rectangle objects.
        @param g2d The Graphics2D object used for rendering.
    */
    public void draw(Graphics2D g2d){
        Rectangle r1 = new Rectangle(0, 0, w, h, c1);
        Rectangle r2 = new Rectangle(0, 0, w, h*0.3125, c2);
        Rectangle r3 = new Rectangle(0, 0, w, h*0.25, c3);

        r1.draw(g2d);
        r2.draw(g2d);
        r3.draw(g2d);
    }

    /**
        Changes the color of the sky.
        @param c1 The new color 1.
        @param c2 The new color 2.
        @param c3 The new color 3.
    */
    public void changeColor(Color c1, Color c2, Color c3){
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
    }
}