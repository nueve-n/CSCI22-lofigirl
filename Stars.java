//https://www.w3schools.com/java/ref_math_round.asp

import java.awt.*;
import java.util.*;

public class Stars implements DrawingObject{
    ArrayList<ArrayList<Double>> stars;
    double x, y, w, h;
    static Color c = new Color(180, 216, 246, 127);
    static Color sc1 = new Color(180, 216, 246, 20);
    static Color sc2 = new Color(180, 216, 246, 10);
    static Color sc3 = new Color(180, 216, 246, 5); 

    public Stars(double x, double y, double w, double h){
        stars = new ArrayList<ArrayList<Double>>();
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public void draw(Graphics2D g2d){
        for(int a = 0; a < stars.size(); a++){
            Celestial star = new Celestial(stars.get(a).get(0), stars.get(a).get(1), 6, c, sc1, sc2, sc3);
            star.draw(g2d);
        }
    }

    public void drawStars(){
        stars = new ArrayList<ArrayList<Double>>();
        for(int a = 0; a < Math.round((w*h)/4000); a++){
            double starx = (double)(Math.random() * w) + x;
            double stary = (double)(Math.random() * h) + y;

            stars.add(new ArrayList<Double> ());
            stars.get(a).add(starx);
            stars.get(a).add(stary);
        }
    }

    public void changeColor(Color newC){
        sc3 = newC;
    }

}