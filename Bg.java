import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Bg implements DrawingObject{
    double w, h;
    Color wallC, wallCS, floorC, floorCS;
    
    public Bg(double w, double h){
        this.w = w;
        this.h = h;

        wallC = Color.decode("#ffe495");
        wallCS = Color.decode("#e9d188");
        floorC = Color.decode("#5f2e10");
        floorCS = Color.decode("#4a240d");
    }

    public void draw(Graphics2D g2d){
        //bg proper
        double[] bgx = {0, w, w, w*0.5, w*0.5, w*0.05 + w*0.81, w * 0.05 + w*0.81, w, w, 0};
        double[] bgy = {0, 0, h*0.1, h*0.1, h*0.1 + h*0.475, h*0.1 + h*0.475, h*0.1, h*0.1, h, h};

        Path2D.Double bg = new Path2D.Double();
        bg.moveTo(bgx[0], bgy[0]);
        for(int a = 1; a < 10; a++){
            bg.lineTo(bgx[a], bgy[a]);
        }
        bg.closePath();
        g2d.setColor(wallC);
        g2d.fill(bg);

        //bg shadow
        double[] bgSx = {0, w, w * 0.05 + w*0.81, w*0.5, w*0.5, w*0.125 + w*0.25, 0};
        double[] bgSy = {0, 0, h*0.1, h*0.1, h*0.1 + h*0.475, h*0.75, h*0.75};

        Path2D.Double bgS = new Path2D.Double();
        bgS.moveTo(bgSx[0], bgSy[0]);
        for(int a = 1; a < 7; a++){
            bgS.lineTo(bgSx[a], bgSy[a]);
        }
        bgS.closePath();
        g2d.setColor(wallCS);
        g2d.fill(bgS);

        //floor
        Rectangle2D.Double floor = new Rectangle2D.Double(0, h*0.75, w, h);
        g2d.setColor(floorC);
        g2d.fill(floor);

        //shelf to floor shadow
        double[] fSx = {0, w*0.125 + w*0.25, w*0.125, 0};
        double[] fSy = {h*0.75, h*0.75, h, h};

        Path2D.Double fS = new Path2D.Double();
        fS.moveTo(fSx[0], fSy[0]);
        for(int a = 1; a < 4; a++){
            fS.lineTo(fSx[a], fSy[a]);
        }
        fS.closePath();
        g2d.setColor(floorCS);
        g2d.fill(fS);
    }

    public void changeColor(Color w, Color wS, Color f, Color fS){
        wallC = w;
        wallCS = wS;
        floorC = f;
        floorCS = fS;
    }
}