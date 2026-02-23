import java.awt.*;

public class TableBackFeet implements DrawingObject {
    private double x, y, w, h;
    private Color color;

    public TableBackFeet (double x, double y, double w, double h, Color color){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g2d) {
        Rectangle foot3 = new Rectangle(
            x + w * 0.226, y, 
            w * 0.07, h * 1.25,
            color
        );

        Rectangle foot4 = new Rectangle(
            x + w * 0.726, y, 
            w * 0.07, h * 1.25,
            color
        );

        foot4.draw(g2d);
        foot3.draw(g2d);
    }
}
