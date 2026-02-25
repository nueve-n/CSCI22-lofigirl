import java.util.*;
import java.awt.*;
import javax.swing.*;

public class SceneCanvas extends JComponent{
    double w;
    double h;
    ArrayList<DrawingObject> objects;
    Mat mat;
    Shelf shelf;
    Table table;
    TableBackFeet tableFeet;
    Chair chair;
    Celestial sun;
    Celestial moon;
    Stars stars;
    Background background;
    Window windowWeather;
    Sky outside;
    Girl girl;
    Lamp lamp;
    StudyLamp studyLamp;
    StuffedToy stuffedToy;
    GirlArms girlArms;
    Laptop laptop;
    TableDecor tableDecor;

    public SceneCanvas(double width, double height){
        w = width;
        h = height;

        windowWeather = new Window(w*0.5, h*0.1, w*0.40, h*0.5, Color.decode("#938b7e"), Color.decode("#d6cdc0"));
        shelf = new Shelf(w*0.125 , h*0.1, w*0.25, h*0.65, Color.decode("#372403"), Color.decode("#4d3101"));
        mat = new Mat(w*0.125*0.5, h*0.8, w*0.25 + w*0.125, h * 0.1, Color.decode("#584528"), Color.decode("#977b50"));
        chair = new Chair(w*0.43, h*0.56, w*0.14, h * 0.30, Color.decode("#d6827d"), Color.decode("#b25b4e"), Color.decode("#2c2c2c"));
        table = new Table(w*0.50, h*0.60, w*0.35, h * 0.15, Color.decode("#50312f"), Color.decode("#392421"), Color.decode("#2c2020"));
        laptop = new Laptop(w * 0.608, h * 0.49, w * 0.12, h * 0.18, Color.decode("#222222"), Color.decode("#d1d5d8"), Color.decode("#444444"), Color.decode("#2d2d2d"), Color.decode("#333333"));
        tableFeet = new TableBackFeet(w*0.50, h*0.60, w*0.35, h * 0.15, Color.decode("#231818"));
        sun = new Celestial(w*0.5 + w*0.13, h*0.75, w*0.1, Color.decode("#ebb000"), Color.decode("#e3bf55"), Color.decode("#dcc376"), Color.decode("#d9c58a"));
        moon = new Celestial(w*0.5 + w*0.13, h, w*0.1, Color.decode("#ffebb1"), Color.decode("#d2c5a1"), Color.decode("#b9b19a"), Color.decode("#b1ab9a"));
        background = new Background(w, h);
        outside = new Sky(w, h, Color.decode("#eaa02a"), Color.decode("#ebb258"), Color.decode("#f3c67f"));
        stars = new Stars(w*0.5, h*0.1, w*0.40, h*0.5);
        lamp = new Lamp(w*0.02, h*0.375, w*0.1, h*0.4);
        studyLamp = new StudyLamp(w*0.5 + w*0.25, h*0.4, w*0.2, h*0.45);
        stuffedToy = new StuffedToy(w * 0.715, h * 0.608, w * 0.12, h * 0.18, Color.decode("#945c6b"), Color.decode("#7a4553"), Color.decode("#ad7685"));
        girl = new Girl(w * 0.475, h * 0.44, w * 0.16, h * 0.45, Color.decode("#a45341"), Color.decode("#0e0a09"), Color.decode("#1d1312"), Color.decode("#81614c"), Color.decode("#907563"), Color.decode("#01221d"), Color.decode("#301210"), Color.decode("#a05884"), Color.decode("#170e11"));
        tableDecor = new TableDecor(w * 0.58, h * 0.528, w * 0.25, h * 0.14, Color.decode("#9a938c"), Color.decode("#766e67"), Color.decode("#4a372d"), Color.decode("#33241d"), Color.decode("#5e1d13"), Color.decode("#3d2235"), Color.decode("#4f3216"), Color.decode("#36200a"), Color.decode("#404252"), Color.decode("#292b36"), Color.decode("#262626"), Color.decode("#121212"));
        girlArms = new GirlArms(w * 0.475, h * 0.44, w * 0.16, h * 0.45, Color.decode("#03352d"), Color.decode("#01221d"), Color.decode("#b2664d"), Color.decode("#a45341"));
        
        objects = new ArrayList<>();

        objects.add(stars);
        objects.add(sun);
        objects.add(moon);
        objects.add(background);
        objects.add(windowWeather);
        objects.add(mat);
        objects.add(shelf);
        objects.add(tableFeet);
        objects.add(chair);
        objects.add(girl);
        objects.add(table);
        objects.add(tableDecor);
        objects.add(laptop);
        objects.add(girlArms);
        objects.add(stuffedToy);
        objects.add(lamp);
        objects.add(studyLamp);

        setPreferredSize(new Dimension(800, 600));
    }

    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);

        outside.draw(g2d);
        for(DrawingObject object : objects){
            object.draw(g2d);
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

    public Sky getOutside(){
        return outside;
    }

    public Stars getStars(){
        return stars;
    }

    public Background getBG(){
        return background;
    }

    public Lamp getLamp(){
        return lamp;
    }

    public Girl getGirl(){
        return girl;
    }

    public GirlArms getGirlArms() {
        return girlArms;
    }
    public StudyLamp getStudyLamp() {
        return studyLamp;
    }
}