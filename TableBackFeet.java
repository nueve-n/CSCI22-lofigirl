/**
    The TableBackFeet class represents the rear legs of the table. 
    It draws the back supports as separate objects to help maintain proper layering and depth within the scene.

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

public class TableBackFeet implements DrawingObject {
    private double x, y, w, h;
    private Color color;

    /**
        Constructs the TableBackFeet with specific position, size, and color.
        @param x The x-coordinate of the feet.
        @param y The y-coordinate of the feet.
        @param w The width of the table base for scaling.
        @param h The height of the feet.
        @param color The color used for the table legs.
    */
    public TableBackFeet (double x, double y, double w, double h, Color color){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.color = color;
    }

    /**
        Renders the rear legs of the table using Rectangle objects.
        @param g2d The Graphics2D object used for drawing.
    */
    @Override
    public void draw(Graphics2D g2d) {
        Rectangle foot3 = new Rectangle(
            x + w * 0.226, y, 
            w * 0.07, h * 1.25,
            color
        );

        Rectangle foot4 = new Rectangle(
            x + w * 0.726, y, 
            w * 0.07, h * 1.25,
            color
        );

        foot4.draw(g2d);
        foot3.draw(g2d);
    }
}
