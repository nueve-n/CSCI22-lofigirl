/**
    The Window class represents a window frame in the scene. 
    It uses Path2D.Double to create a frame with 3d perspective.

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

public class Window implements DrawingObject{

    private double x, y, w, h;
    private Color cl, cr;

    /**
        Constructs a Window with a specific position, size, and colors.
        @param x The x-coordinate of the window.
        @param y The y-coordinate of the window.
        @param w The width of the window frame.
        @param h The height of the window frame.
        @param cl The color for the left/top portion of the frame.
        @param cr The color for the right/bottom portion of the frame.
    */
    public Window(double x, double y, double w, double h, Color cl, Color cr){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.cl = cl;
        this.cr = cr;

    }

    /**
        Renders the window frame using Path2D to create the perspective effect.
        @param g2d The Graphics2D object used for drawing.
    */
    @Override
    public void draw(Graphics2D g2d) {
        double[] windowSideLx = {x, x + w*0.9, x + w*0.9 - w * 0.05, x + w * 0.05, x + w * 0.05, x};
        double[] windowSideLy = {y, y, y + h * 0.05, y + h * 0.05, y + h*0.9, y + h * 0.05 + h*0.9};
        Path2D.Double windowSideL = new Path2D.Double();

        windowSideL.moveTo(windowSideLx[0], windowSideLy[0]);
        for(int a = 1; a < 6; a ++){
            windowSideL.lineTo(windowSideLx[a], windowSideLy[a]);
        }
        windowSideL.closePath();
        g2d.setColor(cl);
        g2d.fill(windowSideL);

        double[] windowSideRx = {x + w*0.9, x + w*0.9 - w * 0.05, x + w*0.9 - w * 0.05, x + w * 0.05, x, x + w*0.9};
        double[] windowSideRy = {y, y + h * 0.05, y + h*0.9, y + h*0.9, y + h*0.9 + h * 0.05, y + h*0.9 + h * 0.05};
        Path2D.Double windowSideR = new Path2D.Double();

        windowSideR.moveTo(windowSideRx[0], windowSideRy[0]);
        for(int a = 1; a < 6; a ++){
            windowSideR.lineTo(windowSideRx[a], windowSideRy[a]);
        }
        windowSideR.closePath();
        g2d.setColor(cr);
        g2d.fill(windowSideR);

    }

}