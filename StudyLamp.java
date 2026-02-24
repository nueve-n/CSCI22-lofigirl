//https://stackoverflow.com/questions/34688182/java-graphics2d-draw-an-image-with-gradient-opacity

import java.awt.*;
import java.awt.geom.*;

public class StudyLamp implements DrawingObject{
    double x, y, w, h;
    boolean isOn = true;

    public StudyLamp(double x, double y, double w, double h){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public void draw(Graphics2D g2d){
        AffineTransform originalTransform = g2d.getTransform();
        
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

        Path2D.Double beam = new Path2D.Double();
        beam.moveTo(headX[3], headY[3]); 
        beam.lineTo(headX[2], headY[2]);
        beam.lineTo(headX[2] + (w * 0.4), headY[2] + (h * 0.5)); 
        beam.lineTo(headX[3] - (w * 0.4), headY[3] + (h * 0.5));
        beam.closePath();
        
        g2d.rotate(Math.toRadians(45), (x + w*0.125 + w*0.1 + x + w*0.375 + w*0.1)*0.5, y);
        
        float x1 = (float)((headX[2] + headX[3]) / 2.0);
        float y1 = (float)((headY[2] + headY[3]) / 2.0);

        float x2 = x1;
        float y2 = (float)((headY[2] + headY[3])/2 + (h * 0.5));

        LinearGradientPaint beamGradient = new LinearGradientPaint(
                x1, y1,
                x2, y2,
                new float[]{0f, 1f},
                new Color[]{
                    new Color(255, 240, 180, 60),
                    new Color(255, 240, 180, 0)
                }
        );

        g2d.setPaint(beamGradient);
        if (isOn) g2d.fill(beam);

        bulb.draw(g2d);

        g2d.setColor(Color.decode("#251501"));
        g2d.fill(head);
        
        g2d.setTransform(originalTransform);
    }

    public void flicker() {

    }

    public void toggle() {
        isOn = !isOn;
    }
}