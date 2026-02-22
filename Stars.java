//https://www.w3schools.com/java/ref_math_round.asp

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;

public class Stars implements DrawingObject{
    ArrayList<Celestial> stars;
    double x, y, w, h;
    static Color c = new Color(180, 216, 246, 128);
    static Color sc1 = new Color(180, 216, 246, 77);
    static Color sc2 = new Color(180, 216, 246, 30);
    static Color sc3 = new Color(180, 216, 246, 15); 

    public Stars(double x, double y, double w, double h){
        stars = new ArrayList<Celestial>();
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public void draw(Graphics2D g2d){
        for(int a = 0; a < stars.size(); a++){
            stars.get(a).draw(g2d);
        }
    }

    public void drawStars(){
        stars = new ArrayList<Celestial>();
        for(int a = 0; a < Math.round((w*h)/4000); a++){
            double starx = (double)(Math.random() * w) + x;
            double stary = (double)(Math.random() * h) + y;

            Celestial star = new Celestial(starx, stary, 6, c, sc1, sc2, sc3);
            stars.add(star);
        }
    }

}