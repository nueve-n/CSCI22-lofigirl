import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class Ellipse implements DrawingObject{

    private double x, y, w, h;
    private Color color;

    public Ellipse(double x, double y, double w, double h, Color color){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.color = color;
        
    }
    @Override
    public void draw(Graphics2D g2d) {
        Ellipse2D.Double c = new Ellipse2D.Double(x, y, w, h);
        g2d.setColor(color);
        g2d.fill(c);
    }

}