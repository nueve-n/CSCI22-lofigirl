import java.awt.*;
import java.awt.geom.*;

public class Window implements DrawingObject{

    private double x, y, w, h;
    private Color cl, cr;

    public Window(double x, double y, double w, double h, Color cl, Color cr){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.cl = cl;
        this.cr = cr;

    }
    @Override
    public void draw(Graphics2D g2d) {
        double[] windowSideLx = {x, x + w*0.9, x + w*0.9 - w * 0.05, x + w * 0.05, x + w * 0.05, x};
        double[] windowSideLy = {y, y, y + h * 0.05, y + h * 0.05, y + h*0.9, y + h * 0.05 + h*0.9};
        Path2D.Double windowSideL = new Path2D.Double();

        windowSideL.moveTo(windowSideLx[0], windowSideLy[0]);
        for(int a = 1; a < 6; a ++){
            windowSideL.lineTo(windowSideLx[a], windowSideLy[a]);
        }
        windowSideL.closePath();
        g2d.setColor(cl);
        g2d.fill(windowSideL);

        double[] windowSideRx = {x + w*0.9, x + w*0.9 - w * 0.05, x + w*0.9 - w * 0.05, x + w * 0.05, x, x + w*0.9};
        double[] windowSideRy = {y, y + h * 0.05, y + h*0.9, y + h*0.9, y + h*0.9 + h * 0.05, y + h*0.9 + h * 0.05};
        Path2D.Double windowSideR = new Path2D.Double();

        windowSideR.moveTo(windowSideRx[0], windowSideRy[0]);
        for(int a = 1; a < 6; a ++){
            windowSideR.lineTo(windowSideRx[a], windowSideRy[a]);
        }
        windowSideR.closePath();
        g2d.setColor(cr);
        g2d.fill(windowSideR);

    }

}