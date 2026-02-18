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
    Celestial sun;
    Celestial moon;
    Bg bg;
    Window windowWeather;
    Rectangle outside;

    public SceneCanvas(double width, double height){
        w = width;
        h = height;

        windowWeather = new Window(w*0.5, h*0.1, w*0.40, h*0.5, Color.decode("#938b7e"), Color.decode("#d6cdc0"));
        shelf = new Shelf(w*0.125 , h*0.1, w*0.25, h*0.65, Color.decode("#372403"), Color.decode("#4d3101"));
        mat = new Mat(w*0.125*0.5, h*0.8, w*0.25 + w*0.125, h * 0.1, Color.decode("#584528"), Color.decode("#977b50"));
        sun = new Celestial(w*0.5 + w*0.13, h*0.75, w*0.1, Color.decode("#ebb000"), Color.decode("#e3bf55"), Color.decode("#dcc376"), Color.decode("#d9c58a"));
        moon = new Celestial(w*0.5 + w*0.13, h, w*0.1, Color.decode("#ffebb1"), Color.decode("#d2c5a1"), Color.decode("#b9b19a"), Color.decode("#b1ab9a"));
        bg = new Bg(w, h);
        outside = new Rectangle(0, 0, w, h, Color.decode("#dc8904"));

        objects = new DrawingObject[6];

        objects[0] = sun;
        objects[1] = moon;
        objects[2] = bg;
        objects[3] = windowWeather;
        objects[4] = mat;
        objects[5] = shelf;

        setPreferredSize(new Dimension(800, 600));
    }

    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);

        outside.draw(g2d);
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

    public Celestial getSun(){
        return sun;
    }

    public Celestial getMoon(){
        return moon;
    }

    public Rectangle getOutside(){
        return outside;
    }
}