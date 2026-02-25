/**
    The Stars class represents a collection of stars in the background of the scene. 
    It generates random star positions based on the area of the sky and handles their rendering and color transitions.

    @author Fiona Nadine Macalalag (253550)
    @author John Carlo Ranario (254815)
    @version February 26, 2026

    We have not discussed the Java language code in my program
    with anyone other than our instructor or the teaching assistants
    assigned to this course.

    We have not used Java language code obtained from another student,
    or any other unauthorized source, either modified or unmodified.
    
    If any Java language code or documentation used in our program
    was obtained from another source, such as a textbook or website,
    that has been clearly noted with a proper citation in the comments
    of my program.
*/

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

    /**
        Constructs the Star field with a specified position and size, and initializes the star array.
        @param x The x-coordinate of the star field.
        @param y The y-coordinate of the star field.
        @param w The width of the star field.
        @param h The height of the star field.
    */
    public Stars(double x, double y, double w, double h){
        stars = new ArrayList<ArrayList<Double>>();
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    /**
        Renders each star in the list as a Celestial object.
        @param g2d The Graphics2D object used for rendering.
    */
    public void draw(Graphics2D g2d){
        for(int a = 0; a < stars.size(); a++){
            Celestial star = new Celestial(stars.get(a).get(0), stars.get(a).get(1), 6, c, sc1, sc2, sc3);
            star.draw(g2d);
        }
    }

    /**
        Randomly generates star coordinates based on the field dimensions.
    */
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

    /**
        Updates the color of the stars for time transitions.
        @param newC The new color to be applied.
    */
    public void changeColor(Color newC){
        sc3 = newC;
    }

}

/*
REFERENCES:
    1. W3Schools. "Java Math.round() Method." https://www.w3schools.com/java/ref_math_round.asp
*/