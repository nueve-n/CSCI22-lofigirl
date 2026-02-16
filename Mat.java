import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class Mat implements DrawingObject{
    double x, y, w, h;
    Color co, ci;

    public Mat(double x,double y,double w, double h, Color co, Color ci, Graphics2D g2d){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.co = co;
        this.ci = ci;

        draw(g2d);
        
    }

    @Override
    public void draw(Graphics2D g2d){
        Ellipse outer = new Ellipse(x, y, w, h, co, g2d);
        Ellipse inner = new Ellipse(x + w * 0.05, y + h*0.05, w * 0.9, h *0.9, ci, g2d);
    }
}