//https://docs.oracle.com/javase/tutorial/uiswing/events/componentlistener.html

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SceneFrame{
    int w, h;
    JFrame f;
    JPanel panel;
    SceneCanvas homeComponent;

    public SceneFrame(int width, int height){
        w = width;
        h = height;
        f = new JFrame();
        f.pack();
        panel = new JPanel(new BorderLayout());
        homeComponent = new SceneCanvas(w, h);
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
                homeComponent = new SceneCanvas(panel.getWidth(), panel.getHeight());
                panel.removeAll();
                panel.add(homeComponent);
                f.setVisible(true);
            }
        };
        panel.addComponentListener(HomeFrameListener);
    }
    
}