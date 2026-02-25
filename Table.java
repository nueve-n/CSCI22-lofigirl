/**
    The Table class represents a table in the scene. 
    It utilizes a combination of the quadrilateral class and rectangle class to render the table top and supporting legs.

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

public class Table implements DrawingObject {
    private double x, y, w, h;
    private Color light, shadow1, shadow2;

    /**
        Constructs a Table with specific position, size, and color palette.
        @param x The x-coordinate of the table.
        @param y The y-coordinate of the table.
        @param w The width of the table.
        @param h The height of the table.
        @param light The color used for the tabletop surface.
        @param shadow1 The primary shadow color for the table's thickness.
        @param shadow2 The secondary shadow color for the table legs.
    */
    public Table (double x, double y, double w, double h, Color light, Color shadow1, Color shadow2){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.light = light;
        this.shadow1 = shadow1;
        this.shadow2 = shadow2;

    }

    /**
        Renders the table by drawing the tabletop, thickness, and legs in a 
        specific order to maintain the correct visual depth and perspective.
        @param g2d The Graphics2D object used for drawing.
    */
    @Override
    public void draw(Graphics2D g2d) {
        Quadrilateral tableTop = new Quadrilateral(
            x + w * 0.2, y,
            x + w * 0.9, y,
            x + w, y + h * 0.70 + 1, 
            x, y + h * 0.70 + 1,
            light
        );

        Rectangle width = new Rectangle(
            x, y + h * 0.70 - 1,
            w, h * 0.14 + 2,
            shadow1
        );

        Rectangle support = new Rectangle(
            x + w * 0.20 - 1, y + h * 0.84 - 1,
            w * 0.60 + 2, h * 0.11 + 2,
            shadow2
        );

        Rectangle foot1 = new Rectangle(
            x + w * 0.10, y + h * 0.84, 
            w * 0.10, h * 2 + 1,
            shadow2
        );

        Rectangle foot2 = new Rectangle(
            x + w * 0.80, y + h * 0.84, 
            w * 0.10, h * 2 + 1,
            shadow2
        );

        tableTop.draw(g2d);
        width.draw(g2d);
        foot1.draw(g2d);
        foot2.draw(g2d);
        support.draw(g2d);
    }
}
