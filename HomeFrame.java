import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HomeFrame{
    int w, h;
    JFrame f;
    JPanel panel;
    Home homeComponent;

    public HomeFrame(int width, int height){
        //add responsiveness; panel resize listeners
        w = width;
        h = height;
        f = new JFrame();
        panel = new JPanel(new BorderLayout());
        homeComponent = new Home(w, h);
    }

    public void setUp(){
        f.setSize(w,h);
        f.setTitle("LofiGirl_MacalalalagxRanario");
        f.add(panel);
        panel.add(homeComponent);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public void setUpListener(){
        ComponentListener HomeFrameListener = new ComponentListener(){
            
            @Override
            public void componentHidden(ComponentEvent e){
            }

            @Override
            public void componentShown(ComponentEvent e){
            }

            @Override
            public void componentMoved(ComponentEvent e){
            }

            @Override
            public void componentResized(ComponentEvent e){
                homeComponent = new Home(panel.getWidth(), panel.getHeight());
                panel.removeAll();
                panel.add(homeComponent);
                f.setVisible(true);
            }
        };
        panel.addComponentListener(HomeFrameListener);
    }
    
}