//https://docs.oracle.com/javase/tutorial/uiswing/events/componentlistener.html
//https://youtu.be/tHNWIWxRDDA
//https://www.baeldung.com/java-play-sound
//https://www.geeksforgeeks.org/java/play-audio-file-using-java/
//https://emojipedia.org/
//https://docs.oracle.com/javase/8/docs/api/javax/sound/sampled/Clip.html
//https://pixabay.com/music/lofi-lofi-chill-487321/
//https://pixabay.com/music/beats-good-night-lofi-cozy-chill-music-160166/
//https://pixabay.com/music/beats-lofi-study-calm-peaceful-chill-hop-112191/


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;

public class SceneFrame{
    int w, h;
    int currentTrack;
    public static int don, current;
    JFrame f;
    JPanel panel, panelS, matPanel;
    SceneCanvas sceneComponent;
    JButton moveMatR, moveMatL;
    JButton lastTrack, pauseOrPlay, nextTrack;

    public SceneFrame(int width, int height){
        w = width;
        h = height;
        don = 0;
        current = 0;
        f = new JFrame();
        f.pack();

        panel = new JPanel(new BorderLayout());
        panelS = new JPanel(new GridLayout(0,4));
        matPanel = new JPanel(new GridLayout(0,2));

        sceneComponent = new SceneCanvas(w, h);
        sceneComponent.getShelf().drawBooksInShelves();
        sceneComponent.getStars().drawStars();
        moveMatR = new JButton("➡️");
        moveMatL = new JButton("⬅️");

        lastTrack = new JButton("⏮️");
        pauseOrPlay = new JButton("⏸️");
        nextTrack = new JButton("⏭️");
        
    }

    public void setUp(){
        f.setSize(w,h);
        f.setFocusable(true);
        w = f.getWidth();
        h = f.getHeight();
        f.setTitle("LofiGirl_MacalalalagxRanario");
        f.add(panel);
        f.add(panelS, BorderLayout.SOUTH);

        panel.add(sceneComponent);

        panelS.add(lastTrack);
        panelS.add(pauseOrPlay);
        panelS.add(nextTrack);
        panelS.add(matPanel);

        matPanel.add(moveMatL);
        matPanel.add(moveMatR);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public void setUpMusic(){
        String[] soundTracks = {"track1.wav", "track2.wav", "track3.wav"};
        currentTrack = (int) (Math.random() * 3);

        try{
            AudioPlayer  audioPlayer = new AudioPlayer(soundTracks[currentTrack]);

            LineListener TrackListener = new LineListener(){
                @Override

                public void update(LineEvent event){
                    //if audio ended
                    if(audioPlayer.getClip().getFramePosition() >= audioPlayer.getClip().getFrameLength()){
                        if(currentTrack == 2){
                            currentTrack = 0;
                        }
                        else{
                            currentTrack++;
                        }

                        audioPlayer.switchTrack(soundTracks[currentTrack]);
                        audioPlayer.getClip().addLineListener(this);
                    }
                }
            };

            audioPlayer.getClip().addLineListener(TrackListener);
            audioPlayer.play();

            //buttons
            ActionListener TrackButtons = new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae){

                    if(ae.getSource() == lastTrack){
                        if(currentTrack == 0){
                            currentTrack = 2;
                        }
                        else{
                            currentTrack--;
                        }

                        audioPlayer.switchTrack(soundTracks[currentTrack]);
                        audioPlayer.getClip().addLineListener(TrackListener);
                        pauseOrPlay.setText("⏸️");
                    }

                    else if(ae.getSource() == nextTrack){
                        if(currentTrack == 2){
                            currentTrack = 0;
                        }
                        else{
                            currentTrack++;
                        }

                        audioPlayer.switchTrack(soundTracks[currentTrack]);
                        audioPlayer.getClip().addLineListener(TrackListener);
                        pauseOrPlay.setText("⏸️");
                    }

                    else if(ae.getSource() == pauseOrPlay){
                        if(audioPlayer.getStatus() == "play"){
                            audioPlayer.pause();
                            pauseOrPlay.setText("▶️");
                        }
                        else{
                            audioPlayer.play();
                            pauseOrPlay.setText("⏸️");
                        }
                    }
                }
            };

            lastTrack.addActionListener(TrackButtons);
            nextTrack.addActionListener(TrackButtons);
            pauseOrPlay.addActionListener(TrackButtons);
        }
        catch (Exception ex){
            System.out.println("Error");
        }
    }

    public void setUpTimer(){
        ActionListener TimedAction = new ActionListener(){
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
                                sceneComponent.getOutside().changeColor(Color.decode("#290752"));
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
                sceneComponent.getStars().drawStars();
                panel.add(sceneComponent);
                f.setVisible(true); 
            }
        };
        panel.addComponentListener(HomeFrameListener);

        KeyListener keyCommands = new KeyListener(){
            @Override

            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == 68){
                    sceneComponent.getSun().changeY(panel.getHeight());
                    sceneComponent.getMoon().changeY(panel.getHeight());
                    don = 0;
                    current = 0;
                    f.repaint();
                }
                else if(e.getKeyCode() == 78){
                    sceneComponent.getSun().changeY(panel.getHeight());
                    sceneComponent.getMoon().changeY(panel.getHeight());
                    don = 1;
                    current = 0;
                    f.repaint();
                }
                else if(e.getKeyCode() == 83){
                    sceneComponent.getStars().drawStars();
                    f.repaint();
                }
                else if(e.getKeyCode() == 66){
                    sceneComponent.getShelf().drawBooksInShelves();
                    f.repaint();
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }
        };

        f.addKeyListener(keyCommands);
        moveMatR.addKeyListener(keyCommands);
        moveMatL.addKeyListener(keyCommands);
        pauseOrPlay.addKeyListener(keyCommands);
        nextTrack.addKeyListener(keyCommands);
        lastTrack.addKeyListener(keyCommands);
    }
    
}