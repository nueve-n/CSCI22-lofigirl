import java.awt.*;
import java.awt.geom.*;

public class Lamp implements DrawingObject{
    double x, y, w, h;
    Color lightC;

    public Lamp(double x, double y, double w, double h){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;

        lightC = new Color(255, 203, 139, 127);
    }

    public void draw(Graphics2D g2d){
        Ellipse topC = new Ellipse(x + w*0.1, y, w*0.8, h*0.05, Color.decode("#baac7a"));

        Path2D.Double head = new Path2D.Double();
        head.moveTo(x + w*0.1, y + h*0.05*0.5);
        head.lineTo(x + w*0.9, y + h*0.05*0.5);
        head.lineTo(x + w, y + h*0.25);
        head.quadTo(x + (w*0.5), y + h*0.3, x, y + h*0.25);
        head.closePath();

        Path2D.Double light = new Path2D.Double();
        light.moveTo(x + w*0.1, y + h*0.05*0.5);
        light.lineTo(x + w*0.9, y + h*0.05*0.5);
        light.lineTo(x + w + w*0.1, y + h);
        light.quadTo(x + w*0.5, y + h + h*0.1, x - w*0.1, y + h);
        light.closePath();

        Rectangle stand = new Rectangle(x + (w * 0.45), y, w * 0.1, h, Color.decode("#3b2410"));
        Ellipse base = new Ellipse(x, y + (h * 0.95), w, h * 0.05, Color.decode("#251501"));

        g2d.setColor(lightC);
        g2d.fill(light);
        stand.draw(g2d);
        base.draw(g2d);
        g2d.setColor(Color.decode("#ffedab"));
        g2d.fill(head);
        
        topC.draw(g2d);

    }

    public void changeColor(Color c){
        lightC = c;
    }

}