import java.awt.*;
import java.awt.geom.*;

public class StudyLamp implements DrawingObject{
    double x, y, w, h;

    public StudyLamp(double x, double y, double w, double h){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public void draw(Graphics2D g2d){

        Ellipse base = new Ellipse(x + (w * 0.5), y + (h * 0.95), w * 0.5, h * 0.05, Color.decode("#251501"));
        base.draw(g2d);
        
        Line standB = new Line(x + (w * 0.75), y + (h * 0.95), x + (w * 0.75), y + (h * 0.5), 8, Color.decode("#251501"));
        standB.draw(g2d);

        Line standT = new Line(x + (w * 0.75), y + (h * 0.5), x + (w * 0.5), y, 8, Color.decode("#251501"));
        standT.draw(g2d);

        Circle bulb = new Circle((x + w*0.125 + w*0.1 + x + w*0.375 + w*0.1)*0.49, y + h*0.1, h * 0.1,Color.decode("#e8cc7d"));
        Path2D.Double head = new Path2D.Double();
        double[] headX = {x + w*0.125 + w*0.1, x + w*0.375 + w*0.1, x + w*0.5 + w*0.1, x + w*0.1};
        double[] headY = {y - h*0.1, y - h*0.1, y + h*0.25- h*0.1, y + h*0.25- h*0.1};
        head.moveTo(headX[0], headY[0]);
        for(int a = 1; a < 4; a++){
            head.lineTo(headX[a], headY[a]);
        }
        head.closePath();
        g2d.rotate(Math.toRadians(45), (x + w*0.125 + w*0.1 + x + w*0.375 + w*0.1)*0.5, y);
        bulb.draw(g2d);
        g2d.setColor(Color.decode("#251501"));
        g2d.fill(head);
    }
}