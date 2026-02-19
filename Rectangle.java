import java.awt.*;
import java.awt.geom.*;

public class Rectangle implements DrawingObject{
    double x, y, w, h;
    Color color;

    public Rectangle(double x, double y, double w, double h, Color color) {
        this.x = x;
        this.y= y;
        this.w = w;
        this.h = h;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.fill(new Rectangle2D.Double(x, y, w, h));
    }

    public void changeColor(Color c){
        color = c;
    }

}
