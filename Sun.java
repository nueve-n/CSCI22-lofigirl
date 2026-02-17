import java.awt.*;
import java.awt.geom.*;
public class Sun implements DrawingObject{
    double x, y, size;

    public Sun(double x, double y, double size){
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public void draw(Graphics2D g2d){
        Circle sun = new Circle(x, y, size, Color.decode("#ebb000"));
        Circle s1 = new Circle(x - size*0.05, y - size*0.05, size + size*0.1, Color.decode("#e3bf55"));
        Circle s2 = new Circle(x - size*0.1, y - size*0.1, size + size*0.2, Color.decode("#dcc376"));
        Circle s3 = new Circle(x - size*0.15, y - size*0.15, size + size*0.3, Color.decode("#d9c58a"));

        s3.draw(g2d);
        s2.draw(g2d);
        s1.draw(g2d);
        sun.draw(g2d);
    }

    public double getY(){
        return y;
    }

    public void adjustY(double addY){
        y += addY;
    }
}