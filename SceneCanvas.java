import java.util.*;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class SceneCanvas extends JComponent{
    double w;
    double h;
    DrawingObject[] objects;
    Mat mat;
    Shelf shelf;

    public SceneCanvas(double width, double height){
        w = width;
        h = height;

        DrawingObject windowWeather = new Window(w*0.5, h*0.1, w*0.40, h*0.5, Color.decode("#938b7e"));
        shelf = new Shelf(w*0.125 , h*0.1, w*0.25, h*0.65, Color.decode("#372403"), Color.decode("#4d3101"));
        mat = new Mat(w*0.125*0.5, h*0.8, w*0.25 + w*0.125, h * 0.1, Color.decode("#584528"), Color.decode("#977b50"));

        objects = new DrawingObject[3];

        objects[0] = shelf;
        objects[1] = windowWeather;
        objects[2] = mat;

        setPreferredSize(new Dimension(800, 600));
    }

    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);

        Rectangle2D.Double bg = new Rectangle2D.Double(0, 0, w, h);
        g2d.setColor(Color.decode("#ffe495"));
        g2d.fill(bg);

        Rectangle2D.Double floor = new Rectangle2D.Double(0, h*0.75, w, h);
        g2d.setColor(Color.decode("#5f2e10"));
        g2d.fill(floor);

        for(int a = 0; a < objects.length; a++){
            objects[a].draw(g2d);
        }
    }
    public Mat getMat(){
        return mat;
    }

    public Shelf getShelf(){
        return shelf;
    }
}