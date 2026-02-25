/**
    The Shelf class represents a bookshelf in the scene.
    It generates a random set of books. 
    It calculates random heights, widths, and colors for each book to fill the shelves dynamically.

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

import java.awt.*;
import java.util.*;

public class Shelf implements DrawingObject{
    double x, y, w, h;
    Color co, ci;
    ArrayList<Rectangle> books;
    ArrayList<Rectangle> stripes;
    ArrayList<Ellipse> tags;

    /**
        Constructs a Shelf with specified positions, dimensions, and color palette.
        @param x The x-coordinate of the shelf.
        @param y The y-coordinate of the shelf.
        @param w The width of the shelf.
        @param h The total height of the shelf.
        @param co The outer frame color.
        @param ci The inner background color.
    */
    public Shelf(double x, double y, double w, double h, Color co, Color ci){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.co = co;
        this.ci = ci;

        books = new ArrayList<Rectangle>();
        stripes = new ArrayList<Rectangle>();
        tags = new ArrayList<Ellipse>();
    }

    /**
        Renders the shelf frame and all randomly generated books.
        @param g2d The Graphics2D object used for rendering.
    */
    public void draw(Graphics2D g2d){
        Rectangle outer = new Rectangle(x, y, w, h, co);
        outer.draw(g2d);
        Rectangle inner = new Rectangle(x + w * 0.05, y + h * 0.05, w * 0.9, h * 0.9, ci);
        inner.draw(g2d);
        Rectangle shelf1 = new Rectangle(x + w*0.05, y + h * 0.33 - h * 0.05, w * 0.9, h *0.05, co);
        shelf1.draw(g2d);
        Rectangle shelf2 = new Rectangle(x + w*0.05, y + h * 0.66 - h * 0.05, w * 0.9, h *0.05, co);
        shelf2.draw(g2d);

        for(int a = 0; a < books.size(); a++){
            books.get(a).draw(g2d);
        }

        for(int a = 0; a < stripes.size(); a++){
            stripes.get(a).draw(g2d);
        }

        for(int a = 0; a < tags.size(); a++){
            tags.get(a).draw(g2d);
        }
    }

    /**
        Triggers the generation of books for all three shelf levels.
        Resets existing book lists before generating new ones.
    */
    public void drawBooksInShelves(){
        books = new ArrayList<Rectangle>();
        stripes = new ArrayList<Rectangle>();
        tags = new ArrayList<Ellipse>();
        
        //shelf1
        drawBooks((y + h * 0.33 - h * 0.05)-(y + h * 0.05), y + h * 0.05, y + h * 0.33 - h * 0.05);
        //shelf2
        drawBooks((y + h * 0.66 - h * 0.05) - ((y + h * 0.33 - h * 0.05) + h *0.05), (y + h * 0.33 - h * 0.05) + h *0.05, y + h * 0.66 - h * 0.05);
        //shelf3
        drawBooks((y + h * 0.05 + h * 0.9) - ((y + h * 0.66 - h * 0.05) + h *0.05), (y + h * 0.66 - h * 0.05) + h *0.05, y + h * 0.05 + h * 0.9);
    }

    /**
        Fills a specific shelf range with books.
        Uses random values to determine book dimensions.
        @param rangeH The available vertical range for book height.
        @param maxH The highest point (top) the books can reach.
        @param minH The lowest point (bottom) the books sit on.
    */
    public void drawBooks(double rangeH, double maxH, double minH){
        double shelfW = w * 0.9;
        Color[] bookCA = {Color.decode("#6b0a0a"), Color.decode("#0d6b0a"), Color.decode("#1f174b"), Color.decode("#6e370b")};
        double currentW = 0;
        int bookCi = -1;
        
        while(currentW < shelfW){
            double bookH = (double)(Math.random() * (rangeH*0.7)) + maxH;
            int bookC = (int)(Math.random() * 4); 

            while(bookC == bookCi){
                bookC = (int)(Math.random() * 4); 
            }
            bookCi = bookC;

            if(shelfW - currentW > shelfW*0.15){
                double bookW = (double)(Math.random() * (shelfW*(0.15) - shelfW*(0.03))) + shelfW*(0.03);

                Rectangle book = new Rectangle(x + w*0.05 + currentW, bookH, bookW, minH - bookH, bookCA[bookC]);
                books.add(book);

                Rectangle stripe = new Rectangle(x + w*0.05 + currentW, bookH + (minH - bookH)*0.2, bookW, (minH - bookH)*0.05, Color.decode("#b08204"));
                stripes.add(stripe);

                Ellipse tag = new Ellipse(x + w*0.05 + currentW + bookW*0.25, bookH + (minH - bookH)*0.3, bookW*0.5, (minH - bookH)*0.2, Color.decode("#c4920a"));
                tags.add(tag);

                currentW += bookW;
            }
            else{
                double bookW = shelfW - currentW;
                Rectangle book = new Rectangle(x + w*0.05 + currentW, bookH, bookW, minH - bookH, bookCA[bookC]);
                books.add(book);

                Rectangle stripe = new Rectangle(x + w*0.05 + currentW, bookH + (minH - bookH)*0.2, bookW, (minH - bookH)*0.05, Color.decode("#b08204"));
                stripes.add(stripe);

                Ellipse tag = new Ellipse(x + w*0.05 + currentW + bookW*0.25, bookH + (minH - bookH)*0.3, bookW*0.5, (minH - bookH)*0.2, Color.decode("#b08204"));
                tags.add(tag);

                currentW += bookW;
            }
        }
    }
}

/*
REFERENCES:
    1. GeeksforGeeks. "Java.math.random() method with Examples." https://www.geeksforgeeks.org/java/java-math-random-method-examples/
*/