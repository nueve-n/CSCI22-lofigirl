import java.awt.*;
import java.awt.geom.*;

public class StuffedToy implements DrawingObject {
    static double baseX = 433.5;
    static double baseY = 358.5;
    static double baseWidth  = 209.9;
    static double baseHeight = 201.9;
    double x, y, w, h;
    Color bodyC, earC, tummyC;

    public StuffedToy(double  x, double y, double w, double h, Color bodyC, Color earC, Color tummyC) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.bodyC = bodyC;
        this.earC = earC; 
        this.tummyC = tummyC;
    }
    
    @Override 
    public void draw(Graphics2D g2d) {

        Path2D.Double body = new Path2D.Double();
        body.moveTo(552.5, 457.1);
        body.quadTo(553.9, 502.5, 556.4, 551.4);
        body.quadTo(539.0, 573.0, 534.3, 547.5);
        body.quadTo(532.2, 503.3, 528.9, 466.0);
        body.quadTo(484.6, 450.9, 499.8, 414.8);
        body.quadTo(482.2, 460.0, 434.5, 454.5);
        body.quadTo(416.3, 451.0, 433.5, 441.5);
        body.quadTo(489.9, 449.4, 491.9, 360.4);
        body.quadTo(541.1, 311.9, 588.8, 358.5);
        body.quadTo(593.5, 456.5, 643.4, 438.1);
        body.quadTo(659.6, 443.7, 642.4, 451.7);
        body.quadTo(616.2, 460.8, 600.1, 443.0);
        body.quadTo(615.2, 499.2, 603.3, 560.4);
        body.quadTo(589.6, 580.3, 580.5, 558.9);
        body.quadTo(593.6, 506.1, 573.0, 454.9);
        body.closePath();

        Path2D.Double ear1 = new Path2D.Double();
        ear1.moveTo(492.5, 337.9);
        ear1.lineTo(491.9, 360.4);
        ear1.lineTo(522.2, 342.1);
        ear1.closePath();

        Path2D.Double ear2 = new Path2D.Double();
        ear2.moveTo(589.9, 340.0);
        ear2.lineTo(561.9, 343.7);
        ear2.lineTo(586.4, 374.3);
        ear2.closePath();

        Path2D.Double ear1Inner = new Path2D.Double();
        ear1Inner.moveTo(495.3, 340.5);
        ear1Inner.lineTo(494.9, 356.4);
        ear1Inner.lineTo(516.3, 343.5);
        ear1Inner.closePath();

        Path2D.Double ear2Inner = new Path2D.Double();
        ear2Inner.moveTo(586.8, 343.7);
        ear2Inner.lineTo(567.0, 346.3);
        ear2Inner.lineTo(584.3, 368.0);
        ear2Inner.closePath();

        Ellipse2D.Double tummy = new Ellipse2D.Double(516.4, 382.6, 65.9, 67.9);

        Ellipse2D.Double glass1 = new Ellipse2D.Double(493.5, 341.6, 44.0, 44.0);
        
        Ellipse2D.Double glass2 = new Ellipse2D.Double(557.4, 344.6, 44.0, 44.0);

        Path2D.Double glass3 = new Path2D.Double();
        glass3.moveTo(537.5, 359.6);
        glass3.quadTo(547.2, 351.7, 557.4, 359.6);

        Ellipse2D.Double eye1 = new Ellipse2D.Double(508.0, 358.3, 15.0, 18.0);
        Ellipse2D.Double eye2 = new Ellipse2D.Double(565.6, 358.3, 15.0, 18.0);

        Ellipse2D.Double eye1Inner = new Ellipse2D.Double(512.5, 364.3, 4.0, 4.0);
        Ellipse2D.Double eye2Inner = new Ellipse2D.Double(570.1, 364.3, 4.0, 4.0);

        Path2D.Double nose = new Path2D.Double();
        nose.moveTo(541.2, 368.3);
        nose.lineTo(547.4, 375.7);
        nose.lineTo(552.3, 367.7);
        nose.closePath();

        AffineTransform at = new AffineTransform();

        at.translate(x, y);
        at.scale(w/baseWidth, h/baseHeight);
        at.translate(-baseX, -baseY);

        g2d.setStroke(new BasicStroke(1.0f));

        g2d.setColor(bodyC);
        g2d.fill(at.createTransformedShape(ear2));

        g2d.setColor(bodyC);
        g2d.fill(at.createTransformedShape(ear1));

        g2d.setColor(earC);
        g2d.fill(at.createTransformedShape(ear1Inner));
        g2d.fill(at.createTransformedShape(ear2Inner));

        g2d.setColor(bodyC);
        g2d.fill(at.createTransformedShape(body));

        g2d.setColor(tummyC);
        g2d.fill(at.createTransformedShape(tummy));

        g2d.setColor(Color.BLACK);
        g2d.draw(at.createTransformedShape(glass1));
        g2d.draw(at.createTransformedShape(glass2));
        g2d.draw(at.createTransformedShape(glass3));

        g2d.setColor(Color.WHITE);
        g2d.fill(at.createTransformedShape(eye1));
        g2d.fill(at.createTransformedShape(eye2));

        g2d.setColor(Color.BLACK);
        g2d.fill(at.createTransformedShape(eye1Inner));
        g2d.fill(at.createTransformedShape(eye2Inner));

        g2d.setColor(earC);
        g2d.fill(at.createTransformedShape(nose));
    }
}
