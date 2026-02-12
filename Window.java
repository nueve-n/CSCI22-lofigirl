import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class Window implements DrawingObject{

    private double x, y, size;
    private Color color;

    public Window(double x, double y, double size, Color color, Graphics2D g2d){
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;

        draw(g2d);
    }
    @Override
    public void draw(Graphics2D g2d) {
        Square outer = new Square(x, y, size, color);
        outer.draw(g2d);
        Square inner = new Square(x + size * 0.05, y + size * 0.05, size*0.9, Color.WHITE);
        inner.draw(g2d);
    }

}