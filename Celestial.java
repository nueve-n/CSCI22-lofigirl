/**
    The Celestial class represents something in the sky (i.e., sun, moon, stars). 
    It manages the positioning and rendering of the celestial body along with layered glow effects.

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

public class Celestial implements DrawingObject{
    double x, y, size;
    Color c, sc1, sc2, sc3;

    /**
        Constructs a Celestial object with a specific position, size, and color palette.
        The colors provided are used for the main body and the surrounding glow layers.
        @param x The x-coordinate of the celestial body.
        @param y The y-coordinate of the celestial body.
        @param size The diameter of the main celestial circle.
        @param c The color of the main body.
        @param sc1 The color of the innermost glow layer.
        @param sc2 The color of the middle glow layer.
        @param sc3 The color of the outermost glow layer.
    */
    public Celestial(double x, double y, double size, Color c, Color sc1, Color sc2, Color sc3){
        this.x = x;
        this.y = y;
        this.size = size;

        this.c = c;
        this.sc1 = sc1;
        this.sc2 = sc2;
        this.sc3 = sc3;
    }

    /**
        Defines the shapes of the celestial body.
        It draws the glow layers first in descending order of size to ensure the main body appears on top.
        @param g2d The Graphics2D object used for rendering.
    */
    public void draw(Graphics2D g2d){
        Circle main = new Circle(x, y, size, c);
        Circle s1 = new Circle(x - size*0.05, y - size*0.05, size + size*0.1, sc1);
        Circle s2 = new Circle(x - size*0.1, y - size*0.1, size + size*0.2, sc2);
        Circle s3 = new Circle(x - size*0.15, y - size*0.15, size + size*0.3, sc3);

        s3.draw(g2d);
        s2.draw(g2d);
        s1.draw(g2d);
        main.draw(g2d);
    }

    /**
        Calculates the uppermost y-boundary of the celestial body.
        @return The y-coordinate of the top edge.
    */
    public double getYU(){
        return y - size*0.15;
    }

    /**
        Calculates the lowermost y-boundary of the celestial body.
        @return The y-coordinate of the top edge.
    */
    public double getYD(){
        return y + size + size*0.3;
    }

    /**
        Increments or decrements the current y-position of the object.
        @param addY The amount to add to the current y-coordinate.
    */
    public void adjustY(double addY){
        y += addY;
    }

    /**
        Sets the y-position of the celestial body to a specific value..
        @param newY The new y-coordinate.
    */
    public void changeY(double newY){
        y = newY;
    }
}