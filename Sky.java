import java.awt.*;
import java.awt.geom.*;

public class Sky implements DrawingObject{
    Color c1, c2, c3;
    double w, h;

    public Sky(double w, double h, Color c1, Color c2, Color c3){
        this.w = w;
        this.h = h;
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
    }

    public void draw(Graphics2D g2d){
        Rectangle r1 = new Rectangle(0, 0, w, h, c1);
        Rectangle r2 = new Rectangle(0, 0, w, h*0.3125, c2);
        Rectangle r3 = new Rectangle(0, 0, w, h*0.25, c3);

        r1.draw(g2d);
        r2.draw(g2d);
        r3.draw(g2d);
    }

    public void changeColor(Color c1, Color c2, Color c3){
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
    }
}