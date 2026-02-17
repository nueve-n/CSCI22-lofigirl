//https://www.geeksforgeeks.org/java/java-math-random-method-examples/

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class Shelf implements DrawingObject{
    double x, y, w, h;
    Color co, ci;
    public Shelf(double x, double y, double w, double h, Color co, Color ci, Graphics2D g2d){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.co = co;
        this.ci = ci;

        draw(g2d);
    }

    public void draw(Graphics2D g2d){
        Rectangle outer = new Rectangle(x, y, w, h, co, g2d);
        Rectangle inner = new Rectangle(x + w * 0.05, y + h * 0.05, w * 0.9, h * 0.9, ci, g2d);

        Rectangle shelf1 = new Rectangle(x + w*0.05, y + h * 0.33 - h * 0.05, w * 0.9, h *0.05, co, g2d);
        Rectangle shelf2 = new Rectangle(x + w*0.05, y + h * 0.66 - h * 0.05, w * 0.9, h *0.05, co, g2d);

        //shelf1
        drawBooks((y + h * 0.33 - h * 0.05)-(y + h * 0.05), y + h * 0.05, y + h * 0.33 - h * 0.05, g2d);
        //shelf2
        drawBooks((y + h * 0.66 - h * 0.05) - ((y + h * 0.33 - h * 0.05) + h *0.05), (y + h * 0.33 - h * 0.05) + h *0.05, y + h * 0.66 - h * 0.05, g2d);
        //shelf3
        drawBooks((y + h * 0.05 + h * 0.9) - ((y + h * 0.66 - h * 0.05) + h *0.05), (y + h * 0.66 - h * 0.05) + h *0.05, y + h * 0.05 + h * 0.9, g2d);
    }

    public void drawBooks(double rangeH, double maxH, double minH, Graphics2D g2d){
        double shelfW = w * 0.9;
        Color[] bookCA = {Color.decode("#6b0a0a"), Color.decode("#0d6b0a"), Color.decode("#1f174b"), Color.decode("#6e370b")};
        double currentW = 0;
        int bookCi = -1;
        
        while(currentW < shelfW){
            System.out.println(currentW);
            double bookH = (double)(Math.random() * (rangeH*0.7)) + maxH;
            int bookC = (int)(Math.random() * 4); 

            while(bookC == bookCi){
                bookC = (int)(Math.random() * 4); 
            }
            bookCi = bookC;

            if(shelfW - currentW > shelfW*0.15){
                double bookW = (double)(Math.random() * (shelfW*(0.15) - shelfW*(0.03))) + shelfW*(0.03);

                Rectangle book = new Rectangle(x + w*0.05 + currentW, bookH, bookW, minH - bookH, bookCA[bookC], g2d);
                System.out.println(bookW);
                currentW += bookW;
            }
            else{
                double bookW = shelfW - currentW;
                Rectangle book = new Rectangle(x + w*0.05 + currentW, bookH, bookW, minH - bookH, bookCA[bookC], g2d);
                currentW += bookW;
            }
        }
    }
}