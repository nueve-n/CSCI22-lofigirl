import java.awt.*;
import java.awt.geom.*;

public class Triangle implements DrawingObject{
    double x1, y1, x2, y2, x3, y3;
    Color color;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.color = color;
    } 

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(color);
        Path2D.Double triangle = new Path2D.Double();
        triangle.moveTo(x1, y1);
        triangle.lineTo(x2, y2);
        triangle.lineTo(x3, y3);
        triangle.closePath();
        g2d.fill(triangle);
    }
}
