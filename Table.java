import java.awt.*;

public class Table implements DrawingObject {
    private double x, y, w, h;
    private Color light, shadow1, shadow2;

    public Table (double x, double y, double w, double h, Color light, Color shadow1, Color shadow2){
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
        Quadrilateral tableTop = new Quadrilateral(
            x + w * 0.2, y,
            x + w * 0.9, y,
            x + w, y + h * 0.70 + 1, 
            x, y + h * 0.70 + 1,
            light
        );

        Rectangle width = new Rectangle(
            x, y + h * 0.70 - 1,
            w, h * 0.14 + 2,
            shadow1
        );

        Rectangle support = new Rectangle(
            x + w * 0.20 - 1, y + h * 0.84 - 1,
            w * 0.60 + 2, h * 0.11 + 2,
            shadow2
        );

        Rectangle foot1 = new Rectangle(
            x + w * 0.10, y + h * 0.84, 
            w * 0.10, h * 2 + 1,
            shadow2
        );

        Rectangle foot2 = new Rectangle(
            x + w * 0.80, y + h * 0.84, 
            w * 0.10, h * 2 + 1,
            shadow2
        );

        tableTop.draw(g2d);
        width.draw(g2d);
        foot1.draw(g2d);
        foot2.draw(g2d);
        support.draw(g2d);
    }
}
