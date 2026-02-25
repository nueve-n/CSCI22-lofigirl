/**
    The Lamp class represents a lamp in the scene.
    It utilizes a combination of the rectangle class, elipse class, and  Java's path.    
    It has a light beam that can change color.

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

public class Lamp implements DrawingObject{
    double x, y, w, h;
    Color lightC;

    /**
        Constructs a Lamp object with specified positions, size and position.
        Initializes the default light beam color with a semi-transparent yellow.
        @param x The x-coordinate of the lamp.
        @param y The y-coordinate of the lamp.
        @param w The width of the lamp base and head.
        @param h The total height of the lamp.
     */
    public Lamp(double x, double y, double w, double h){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;

        lightC = new Color(255, 203, 139, 127);
    }

    /**
        Renders the lamp by drawing the elements in a specific 
        order to maintain the correct visual depth and perspective.
        @param g2d The Graphics2D object used for drawing.
    */
    @Override
    public void draw(Graphics2D g2d){
        Ellipse topC = new Ellipse(x + w*0.1, y, w*0.8, h*0.05, Color.decode("#baac7a"));

        Path2D.Double head = new Path2D.Double();
        head.moveTo(x + w*0.1, y + h*0.05*0.5);
        head.lineTo(x + w*0.9, y + h*0.05*0.5);
        head.lineTo(x + w, y + h*0.25);
        head.quadTo(x + (w*0.5), y + h*0.3, x, y + h*0.25);
        head.closePath();

        Path2D.Double light = new Path2D.Double();
        light.moveTo(x + w*0.1, y + h*0.05*0.5);
        light.lineTo(x + w*0.9, y + h*0.05*0.5);
        light.lineTo(x + w + w*0.1, y + h);
        light.quadTo(x + w*0.5, y + h + h*0.1, x - w*0.1, y + h);
        light.closePath();

        Rectangle stand = new Rectangle(x + (w * 0.45), y, w * 0.1, h, Color.decode("#3b2410"));
        Ellipse base = new Ellipse(x, y + (h * 0.95), w, h * 0.05, Color.decode("#251501"));

        g2d.setColor(lightC);
        g2d.fill(light);
        stand.draw(g2d);
        base.draw(g2d);
        g2d.setColor(Color.decode("#ffedab"));
        g2d.fill(head);
        
        topC.draw(g2d);

    }

    /**
        Updates the color of the lamp's light beam.
        @param c The new Color for the light beam.
    */
    public void changeColor(Color c){
        lightC = c;
    }

}