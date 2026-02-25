//Coordinate tracing tool for shapes by Marxus Magisa

import java.awt.*;
import java.awt.geom.*;

public class Laptop implements DrawingObject {
    double x, y, w, h;
    static double baseX = 28.5;
    static double baseY = 131.6;
    static double baseWidth  = 290.5;
    static double baseHeight = 251.0;
    Color frameC, screenC, baseC, widthC, keyboardC;

    public Laptop(double x, double y, double w, double h, Color frameC, Color screenC, Color baseC, Color widthC, Color keyboardC) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.frameC = frameC;
        this.screenC = screenC;
        this.baseC = baseC;
        this.widthC = widthC;
        this.keyboardC = keyboardC;
    }

    @Override 
    public void draw(Graphics2D g2d) {
        Path2D.Double frame = new Path2D.Double();
        frame.moveTo(319.0, 145.0);
        frame.quadTo(276.4, 261.7, 234.7, 376.0);
        frame.quadTo(214.2, 353.9, 192.7, 330.8);
        frame.quadTo(231.4, 232.2, 269.7, 131.6);
        frame.closePath();

        Path2D.Double screen = new Path2D.Double();
        screen.moveTo(270.4, 141.6);
        screen.quadTo(289.6, 146.8, 308.7, 152.0);
        screen.quadTo(269.9, 256.7, 231.0, 361.5);
        screen.quadTo(213.8, 345.9, 196.5, 330.4);
        screen.closePath();

        Path2D.Double base = new Path2D.Double();
        base.moveTo(193.6, 331.7);
        base.quadTo(212.9, 353.5, 232.2, 375.3);
        base.quadTo(132.3, 374.4, 32.4, 373.6);
        base.quadTo(38.9, 349.4, 46.2, 330.8);
        base.closePath();

        Path2D.Double width = new Path2D.Double();
        width.moveTo(232.9, 375.3);
        width.quadTo(232.1, 381.3, 229.2, 382.6);
        width.quadTo(129.7, 382.4, 30.2, 382.2);
        width.quadTo(26.8, 381.3, 28.5, 373.6);
        width.closePath();

        Path2D.Double keyboard = new Path2D.Double();
        keyboard.moveTo(99.0, 369.7);
        keyboard.quadTo(149.6, 369.0, 200.3, 368.4);
        keyboard.quadTo(185.4, 351.1, 170.6, 333.8);
        keyboard.quadTo(126.8, 334.3, 82.9, 334.7);
        keyboard.closePath();

        AffineTransform at = new AffineTransform();

        at.translate(x, y);
        at.scale(w/baseWidth, h/baseHeight);
        at.translate(-baseX, -baseY);

        g2d.setColor(frameC);
        g2d.fill(at.createTransformedShape(frame));

        g2d.setColor(screenC);
        g2d.fill(at.createTransformedShape(screen));
        
        g2d.setColor(baseC);
        g2d.fill(at.createTransformedShape(base));
        
        g2d.setColor(widthC);
        g2d.fill(at.createTransformedShape(width));
        
        g2d.setColor(keyboardC);
        g2d.fill(at.createTransformedShape(keyboard));       
    }
}
