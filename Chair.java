import java.awt.*;
import java.awt.geom.*;

public class Chair implements DrawingObject {
    private double x, y, w, h;
    private Color light, shadow1, shadow2;

    public Chair(double x, double y, double w, double h, Color light, Color shadow1, Color shadow2) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.light = light;
        this.shadow1 = shadow1;
        this.shadow2 = shadow2;
    }

    @Override
    public void draw(Graphics2D g2d) {

        Quadrilateral backrest = new Quadrilateral(
            x + w * 0.075, y,
            x + w * 0.3, y - h * 0.05,
            x + w * 0.3, y + h * 0.65,
            x + w * 0.075, y + h * 0.75,
            light
        );
        
        Quadrilateral seat = new Quadrilateral(
            x + w * 0.075, y + h * 0.75,
            x + w * 0.3, y + h * 0.65,
            x + w, y + h * 0.65,
            x + w * 0.90, y + h * 0.75,
            light
        );

        RoundRectangle2D.Double backrestWidth1 = new RoundRectangle2D.Double(
            x,
            y - h * 0.075,
            w*0.14,
            h*0.925,
            w*0.15,
            w*0.20
        );

        RoundRectangle2D.Double backrestWidth2 = new RoundRectangle2D.Double(
            x + w * 0.24,
            y - h * 0.1,
            w*0.12,
            h*0.85,
            w*0.15,
            w*0.20
        );

        Rectangle support = new Rectangle(
            x + w * 0.075, 
            y + h * 0.75, 
            w * 0.825, 
            h * 0.1, 
            shadow1
        );

        Rectangle foot1 = new Rectangle(
            x + w * 0.075, 
            y + h * 0.85, 
            w * 0.12, 
            h * 0.30, 
            shadow2
        );

        Rectangle foot2 = new Rectangle(
            x + w * 0.73, 
            y + h * 0.85, 
            w * 0.12, 
            h * 0.30, 
            shadow2
        );

        Rectangle foot3 = new Rectangle(
            x + w * 0.3, 
            y + h * 0.65, 
            w * 0.115, 
            h * 0.28, 
            shadow2
        );
        
        foot3.draw(g2d);
        g2d.setColor(shadow1);
        g2d.fill(backrestWidth2);
        backrest.draw(g2d);
        seat.draw(g2d);
        support.draw(g2d);
        g2d.setColor(shadow1);
        g2d.fill(backrestWidth1);
        foot1.draw(g2d);
        foot2.draw(g2d);

    }
}
