/**
    The Background class is responsible for the static background of the scene. 
    It draws the main walls, the floor, and the shadows, while also allowing for color changes during time-of-day transitions.

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

public class Background implements DrawingObject{
    double w, h;
    Color wallC, wallCS, floorC, floorCS;
    
    /**
        Constructs the Background in proportion to frame dimensions.
        It initializes the color palette for the walls and floor surfaces.
        @param w The width of the scene.
        @param h The height of the scene.
    */
    public Background(double w, double h){
        this.w = w;
        this.h = h;

        wallC = Color.decode("#ffe495");
        wallCS = Color.decode("#e9d188");
        floorC = Color.decode("#5f2e10");
        floorCS = Color.decode("#4a240d");
    }

    /**
        Renders the walls, shadows, and floor using Path2D and Rectangle2D shapes.
        @param g2d The Graphics2D object used for rendering.
    */
    public void draw(Graphics2D g2d){

        double[] bgx = {0, w, w, w*0.5, w*0.5, w*0.05 + w*0.81, w * 0.05 + w*0.81, w, w, 0};
        double[] bgy = {0, 0, h*0.1, h*0.1, h*0.1 + h*0.475, h*0.1 + h*0.475, h*0.1, h*0.1, h, h};

        Path2D.Double bg = new Path2D.Double();
        bg.moveTo(bgx[0], bgy[0]);
        for(int a = 1; a < 10; a++){
            bg.lineTo(bgx[a], bgy[a]);
        }
        bg.closePath();
        g2d.setColor(wallC);
        g2d.fill(bg);

        double[] bgSx = {0, w, w * 0.05 + w*0.81, w*0.5, w*0.5, w*0.125 + w*0.25, 0};
        double[] bgSy = {0, 0, h*0.1, h*0.1, h*0.1 + h*0.475, h*0.75, h*0.75};

        Path2D.Double bgS = new Path2D.Double();
        bgS.moveTo(bgSx[0], bgSy[0]);
        for(int a = 1; a < 7; a++){
            bgS.lineTo(bgSx[a], bgSy[a]);
        }
        bgS.closePath();
        g2d.setColor(wallCS);
        g2d.fill(bgS);

        Rectangle2D.Double floor = new Rectangle2D.Double(0, h*0.75, w, h);
        g2d.setColor(floorC);
        g2d.fill(floor);

        double[] fSx = {0, w*0.125 + w*0.25, w*0.125, 0};
        double[] fSy = {h*0.75, h*0.75, h, h};

        Path2D.Double fS = new Path2D.Double();
        fS.moveTo(fSx[0], fSy[0]);
        for(int a = 1; a < 4; a++){
            fS.lineTo(fSx[a], fSy[a]);
        }
        fS.closePath();
        g2d.setColor(floorCS);
        g2d.fill(fS);
    }

    public void changeColor(Color w, Color wS, Color f, Color fS){
        wallC = w;
        wallCS = wS;
        floorC = f;
        floorCS = fS;
    }
}