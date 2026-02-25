//https://www.geeksforgeeks.org/java/java-math-random-method-examples/

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;

public class Shelf implements DrawingObject{
    double x, y, w, h;
    Color co, ci;
    ArrayList<Rectangle> books;
    ArrayList<Rectangle> stripes;
    ArrayList<Ellipse> tags;

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

            if(shelfW - currentW > shelfW*(0.1)*2){
                double bookW = (double)(Math.random() * (shelfW*(0.15) - shelfW*(0.1))) + shelfW*(0.1);

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