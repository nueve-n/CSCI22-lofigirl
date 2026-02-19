//https://docs.oracle.com/javase/tutorial/uiswing/events/componentlistener.html
//https://youtu.be/tHNWIWxRDDA

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
        w = f.getWidth();
        h = f.getHeight();
        f.setTitle("LofiGirl_MacalalalagxRanario");
        f.add(panel);
        f.add(panelS, BorderLayout.SOUTH);

        panel.add(sceneComponent);

        panelS.add(moveMatL);
        panelS.add(moveMatR);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public void setUpTimer(){
        ActionListener TimedAction = new ActionListener(){
            public static int don = 0;
            public static int current = 0;

            @Override 
            public void actionPerformed(ActionEvent ae){
                double sunYU = sceneComponent.getSun().getYU();
                double sunYD = sceneComponent.getSun().getYD();

                double moonYU = sceneComponent.getMoon().getYU();
                double moonYD = sceneComponent.getMoon().getYD();

                if(don == 0){ //day
                    if(current == 0){ //sunrise
                        if(sunYU - h*0.005 > 0){
                            sceneComponent.getSun().adjustY(-1*h*0.0025);

                            if(sunYU > h*0.40){
                                sceneComponent.getOutside().changeColor(Color.decode("#dc8904"));
                            }
                            else{
                                sceneComponent.getOutside().changeColor(Color.decode("#b4d8f6"));
                            }

                            f.repaint();
                        }
                        else{
                            sceneComponent.getSun().adjustY(-1*sunYU);
                            
                            f.repaint();
                            current = 1;
                        }
                    }
                    else{ //sunset
                        if(sunYD + h*0.005 < f.getHeight()){
                            sceneComponent.getSun().adjustY(h*0.0025);

                            if(sunYU > h*0.40){
                                sceneComponent.getOutside().changeColor(Color.decode("#e20181"));
                            }
                            else{
                                sceneComponent.getOutside().changeColor(Color.decode("#b4d8f6"));
                            }

                            f.repaint();
                            
                        }
                        else{
                            sceneComponent.getSun().adjustY(h - sunYD);
                            f.repaint();
                            current = 0;
                            don = 1;
                        }
                    }
                }
                else{ //night
                    if(current == 0){ //dusk
                        if(moonYU - h*0.005 > 0){
                            sceneComponent.getMoon().adjustY(-1*h*0.0025);
                            
                            if(moonYU > h*0.40){
                                sceneComponent.getOutside().changeColor(Color.decode("#290752"));
                            }
                            else{
                                sceneComponent.getOutside().changeColor(Color.decode("#040731"));
                            }

                            f.repaint();
                        }
                        else{
                            sceneComponent.getMoon().adjustY(-1*moonYU);
                            f.repaint();
                            current = 1;
                        }
                    }
                    else{ //dawn
                        if(moonYD + h*0.005 < f.getHeight()){
                            sceneComponent.getMoon().adjustY(h*0.0025);

                            if(moonYU > h*0.40){
                                sceneComponent.getOutside().changeColor(Color.decode("#4b2107"));
                            }
                            else{
                                sceneComponent.getOutside().changeColor(Color.decode("#040731"));
                            }

                            f.repaint();
                        }
                        else{
                            sceneComponent.getMoon().adjustY(h - moonYD);
                            f.repaint();
                            current = 0;
                            don = 0;
                        }
                    }
                }
            }
        };
        Timer timer = new Timer(50, TimedAction);
        timer.start();
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