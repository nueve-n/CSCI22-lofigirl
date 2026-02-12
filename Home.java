import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Home extends JComponent{
    int w;
    int h;
    public Home(int width, int height){
        w = width;
        h = height;
    }
    
    
    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);

        Rectangle2D.Double bg = new Rectangle2D.Double(0, 0, w, h);
        g2d.setColor(Color.decode("#ffe5f1"));
        g2d.fill(bg);
    }
}