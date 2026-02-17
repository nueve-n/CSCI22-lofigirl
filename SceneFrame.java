//https://docs.oracle.com/javase/tutorial/uiswing/events/componentlistener.html

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SceneFrame{
    int w, h;
    JFrame f;
    JPanel panel, panelS;
    SceneCanvas sceneComponent;
    JButton moveMatR, moveMatL;

    public SceneFrame(int width, int height){
        w = width;
        h = height;
        f = new JFrame();
        f.pack();

        panel = new JPanel(new BorderLayout());
        panelS = new JPanel(new GridLayout(0,3));
        sceneComponent = new SceneCanvas(w, h);
        sceneComponent.getShelf().drawBooksInShelves();

        moveMatR = new JButton("->");
        moveMatL = new JButton("<-");
    }

    public void setUp(){
        f.setSize(w,h);
        f.setTitle("LofiGirl_MacalalalagxRanario");
        f.add(panel);
        f.add(panelS, BorderLayout.SOUTH);

        panel.add(sceneComponent);

        panelS.add(moveMatL);
        panelS.add(moveMatR);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public void setUpListener(){
        ActionListener MoveMatListener = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                Object moveB = ae.getSource();
                double matx = sceneComponent.getMat().getX();
                double matw = sceneComponent.getMat().getW();

                if(moveB == moveMatR){

                    if(matx + matw < (panel.getWidth() - w*0.05)){
                        sceneComponent.getMat().moveX(w*0.05);
                        f.repaint();
                    }
                    else if((matx + matw) < panel.getWidth()){
                        sceneComponent.getMat().moveX(panel.getWidth() - (matx + matw));
                        f.repaint();
                    }
                }
                else if(moveB == moveMatL){
                    if(matx > panel.getWidth()*0.05){
                        sceneComponent.getMat().moveX(-1*w*0.05);
                        f.repaint();
                    }
                    else if(matx > 0){
                        sceneComponent.getMat().moveX(-matx);
                        f.repaint();
                    }
                }
            }
        };
        moveMatR.addActionListener(MoveMatListener);
        moveMatL.addActionListener(MoveMatListener);
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
                panel.removeAll();
                sceneComponent = new SceneCanvas(f.getWidth(), f.getHeight());
                sceneComponent.getShelf().drawBooksInShelves();
                panel.add(sceneComponent);
                f.setVisible(true);
            }
        };
        panel.addComponentListener(HomeFrameListener);
    }
    
}