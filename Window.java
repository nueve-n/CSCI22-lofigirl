import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class Window implements DrawingObject{

    private double x, y, w, h;
    private Color color;

    public Window(double x, double y, double w, double h, Color color, Graphics2D g2d){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.color = color;

        draw(g2d);
    }
    @Override
    public void draw(Graphics2D g2d) {
        Rectangle outer = new Rectangle(x, y, w, h, color, g2d);
        Rectangle inner = new Rectangle(x + w * 0.05, y + h * 0.05, w*0.9, h*0.9, Color.WHITE, g2d);
    }

}