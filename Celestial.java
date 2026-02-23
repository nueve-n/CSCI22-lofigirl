import java.awt.*;
import java.awt.geom.*;
public class Celestial implements DrawingObject{
    double x, y, size;
    Color c, sc1, sc2, sc3;

    public Celestial(double x, double y, double size, Color c, Color sc1, Color sc2, Color sc3){
        this.x = x;
        this.y = y;
        this.size = size;

        this.c = c;
        this.sc1 = sc1;
        this.sc2 = sc2;
        this.sc3 = sc3;
    }

    public void draw(Graphics2D g2d){
        Circle main = new Circle(x, y, size, c);
        Circle s1 = new Circle(x - size*0.05, y - size*0.05, size + size*0.1, sc1);
        Circle s2 = new Circle(x - size*0.1, y - size*0.1, size + size*0.2, sc2);
        Circle s3 = new Circle(x - size*0.15, y - size*0.15, size + size*0.3, sc3);

        s3.draw(g2d);
        s2.draw(g2d);
        s1.draw(g2d);
        main.draw(g2d);
    }

    public double getYU(){
        return y - size*0.15;
    }

    public double getYD(){
        return y + size + size*0.3;
    }
    public void adjustY(double addY){
        y += addY;
    }

    public void changeY(double newY){
        y = newY;
    }
}