import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class Mat implements DrawingObject{
    double x, y, w, h;
    Color co, ci;

    public Mat(double x,double y,double w, double h, Color co, Color ci){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.co = co;
        this.ci = ci;
    }

    @Override
    public void draw(Graphics2D g2d){
        Ellipse outer = new Ellipse(x, y, w, h, co);
        outer.draw(g2d);

        Ellipse inner = new Ellipse(x + w * 0.05, y + h*0.05, w * 0.9, h *0.9, ci);
        inner.draw(g2d);
    }

    public void moveX(double d){
        x += d;
    }

    public double getX(){
        return x;
    }

    public double getW(){
        return w;
    }
}