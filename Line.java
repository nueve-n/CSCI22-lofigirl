import java.awt.geom.*;
import java.awt.*;

public class Line implements DrawingObject{
    double xi, yi, xf, yf; // x initial/final, y initial/final
    float th; //thickness
    Color c;

    public Line(double xi, double yi, double xf, double yf, float th, Color c){
        this.xi = xi;
        this.yi = yi;
        this.xf = xf;
        this.yf = yf;

        this.th = th;
        this.c = c;
    }

    @Override
    public void draw(Graphics2D g2d){
        Line2D.Double line = new Line2D.Double(xi, yi, xf, yf);
        g2d.setColor(c);
        g2d.setStroke(new BasicStroke(th));
        g2d.draw(line);
    }
}