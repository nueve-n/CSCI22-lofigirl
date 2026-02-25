/**
    The SceneFrame class manages the primary window and the arrangement and animation of the application's moving elements. 
    It is responsible for initializing the GUI layout, coordinating the animation timers, managing the music player system, and handling all user input via listeners.

    @author Fiona Nadine Macalalag (253550)
    @author John Carlo Ranario (254815)
    @version February 26, 2026

    We have not discussed the Java language code in my program
    with anyone other than our instructor or the teaching assistants
    assigned to this course.

    We have not used Java language code obtained from another student,
    or any other unauthorized source, either modified or unmodified.
    
    If any Java language code or documentation used in our program
    was obtained from another source, such as a textbook or website,
    that has been clearly noted with a proper citation in the comments
    of my program.
*/

//https://docs.oracle.com/javase/tutorial/uiswing/events/componentlistener.html
//https://youtu.be/tHNWIWxRDDA
//https://www.baeldung.com/java-play-sound
//https://www.geeksforgeeks.org/java/play-audio-file-using-java/
//https://emojipedia.org/
//https://docs.oracle.com/javase/8/docs/api/javax/sound/sampled/Clip.html
//https://pixabay.com/music/lofi-lofi-chill-487321/
//https://pixabay.com/music/beats-good-night-lofi-cozy-chill-music-160166/
//https://pixabay.com/music/beats-lofi-study-calm-peaceful-chill-hop-112191/
//https://www.geeksforgeeks.org/java/java-keylistener-in-awt/


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

    /**
        Constructs a SceneFrame with initial dimensions, and then calls pack().
        It initializes the core containers, UI buttons, and the scene component.
        @param width The initial width of the frame.
        @param height The initial height of the frame.
    */
    public SceneFrame(int width, int height){
        w = width;
        h = height;
        don = 0;
        current = 0;
        f = new JFrame();
        
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
        
        f.pack();
    }

    /**
        Sets up the Graphical User Interface components and layout.
        This method sets up the JFrame properties and the JPanels.
    */
    public void setUpGUI(){
        f.setSize(w,h);
        f.setFocusable(true);
        w = f.getWidth();
        h = f.getHeight();
        f.setTitle("Midterm Project - Macalalag - Ranario");
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

    /**
        Initializes the background music system and playback controls.
        It handles track switching and play/pause functionality through buttons.
    */
    public void setUpMusic(){
        String[] soundTracks = {"track1.wav", "track2.wav", "track3.wav"};
        currentTrack = (int) (Math.random() * 3);

        try{
            AudioPlayer  audioPlayer = new AudioPlayer(soundTracks[currentTrack]);

            /**
                Inner LineListener to handle track ending events.
                Automatically switches to the next track when a clip finishes.
            */
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

            /**
                Inner ActionListener for music control buttons.
                Manages ⏮️, ⏸️, and ⏭️ interactions.
            */
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

    /**
        Sets up the animation timers for the scene.
        Manages girl's breathing, blinking, and the day/night cycle transitions.
    */
    public void setUpTimer(){
        /**
            Inner ActionListener for main frame updates.
            Handles the progression of time and character idle animations.
        */
        ActionListener TimedAction = new ActionListener(){
            @Override 
            public void actionPerformed(ActionEvent ae){
                sceneComponent.getGirl().breathe();
                sceneComponent.getGirl().blink();
    
                if (Math.random() < 0.015) { 
                    sceneComponent.getGirl().startBlink();
                }
                sceneComponent.getGirlArms().animate();
                sceneComponent.repaint();

                double sunYU = sceneComponent.getSun().getYU();
                double sunYD = sceneComponent.getSun().getYD();

                double moonYU = sceneComponent.getMoon().getYU();
                double moonYD = sceneComponent.getMoon().getYD();
                if(don == 0){
                    if(current == 0){
                        if(sunYU - h*0.005 > 0){
                            sceneComponent.getSun().adjustY(-1*h*0.0025);

                            if(sunYU > h*0.40){
                                sceneComponent.getOutside().changeColor(Color.decode("#eaa02a"), Color.decode("#ebb258"), Color.decode("#f3c67f"));
                                sceneComponent.getBG().changeColor(Color.decode("#e3ab61"), Color.decode("#cf9850"), Color.decode("#6e3f16"), Color.decode("#643913"));
                                sceneComponent.getLamp().changeColor(new Color(255, 203, 139, 127));
                            }
                            else{
                                sceneComponent.getOutside().changeColor(Color.decode("#b4d8f6"), Color.decode("#9fd4ff"), Color.decode("#8fcdff"));
                                sceneComponent.getBG().changeColor(Color.decode("#ffe495"), Color.decode("#e9d188"), Color.decode("#5f2e10"), Color.decode("#4a240d"));
                                sceneComponent.getLamp().changeColor(new Color(255, 203, 139, 0));
                            }

                            f.repaint();
                        }
                        else{
                            sceneComponent.getSun().adjustY(-1*sunYU);
                            
                            f.repaint();
                            current = 1;
                        }
                    }
                    else{
                        if(sunYD + h*0.005 < f.getHeight()){
                            sceneComponent.getSun().adjustY(h*0.0025);

                            if(sunYU > h*0.40){
                                sceneComponent.getOutside().changeColor(Color.decode("#f050ab"), Color.decode("#f668b9"), Color.decode("#fd7dc6"));
                                sceneComponent.getBG().changeColor(Color.decode("#ffc895"), Color.decode("#e7b586"), Color.decode("#6e3511"), Color.decode("#5f2e10"));
                                sceneComponent.getLamp().changeColor(new Color(255, 203, 139, 127));
                            }
                            else{
                                sceneComponent.getOutside().changeColor(Color.decode("#b4d8f6"), Color.decode("#9fd4ff"), Color.decode("#8fcdff"));
                                sceneComponent.getBG().changeColor(Color.decode("#ffe495"), Color.decode("#e9d188"), Color.decode("#5f2e10"), Color.decode("#4a240d"));
                                sceneComponent.getLamp().changeColor(new Color(255, 203, 139, 0));
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
                else{
                    if(current == 0){
                        if(moonYU - h*0.005 > 0){
                            sceneComponent.getMoon().adjustY(-1*h*0.0025);
                            
                            if(moonYU > h*0.40){
                                sceneComponent.getOutside().changeColor(Color.decode("#330d62"), Color.decode("#290752"), Color.decode("#220645"));
                                sceneComponent.getBG().changeColor(Color.decode("#c6b276"), Color.decode("#ae9e6e"), Color.decode("#53280d"), Color.decode("#48220b"));
                                sceneComponent.getLamp().changeColor(new Color(255, 203, 139, 127));
                            }
                            else{
                                sceneComponent.getOutside().changeColor(Color.decode("#040731"), Color.decode("#030521"), Color.decode("#010319"));
                                sceneComponent.getBG().changeColor(Color.decode("#bba86f"), Color.decode("#9a8c61"), Color.decode("#49230c"), Color.decode("#41200b"));
                                sceneComponent.getLamp().changeColor(new Color(255, 203, 139, 127));

                            }

                            f.repaint();
                        }
                        else{
                            sceneComponent.getMoon().adjustY(-1*moonYU);
                            f.repaint();
                            current = 1;
                        }
                    }
                    else{
                        if(moonYD + h*0.005 < f.getHeight()){
                            sceneComponent.getMoon().adjustY(h*0.0025);

                            if(moonYU > h*0.40){
                                sceneComponent.getOutside().changeColor(Color.decode("#330d62"), Color.decode("#290752"), Color.decode("#220645"));
                                sceneComponent.getBG().changeColor(Color.decode("#c6b276"), Color.decode("#ae9e6e"), Color.decode("#53280d"), Color.decode("#48220b"));
                            }
                            else{
                                sceneComponent.getOutside().changeColor(Color.decode("#040731"), Color.decode("#030521"), Color.decode("#010319"));
                                sceneComponent.getBG().changeColor(Color.decode("#bba86f"), Color.decode("#9a8c61"), Color.decode("#49230c"), Color.decode("#41200b"));
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

        /**
            Inner ActionListener for star twinkle effect.
            Toggles star opacity periodically.
        */
        ActionListener Twinkle = new ActionListener(){
            public static int i = 0;
            public void actionPerformed(ActionEvent ae){
                i++;

                if(i%2 == 1){
                    sceneComponent.getStars().changeColor(new Color(180, 216, 246, 50));
                }
                else{
                    sceneComponent.getStars().changeColor(new Color(180, 216, 246, 0));
                }
            }
        };
        Timer colors = new Timer(500, Twinkle);
        colors.start();
    }

    /**
        Sets up Action, Component, and Key listeners for the frame.
        Handles mat movement, window resizing, and keyboard shortcuts.
    */
    public void setUpListener(){
        /**
            Inner ActionListener for shifting the mat left and right.
        */
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

        /**
            Inner ComponentListener to handle frame resizing.
            Redraws the scene to maintain proportions.
        */
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

        /**
            Inner KeyListener for controls via keys.
            Listens for D (Day), N (Night), S (Stars), B (Books), and L (Lamp).
        */
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
                else if (e.getKeyCode() == 76){
                    sceneComponent.getStudyLamp().toggle();
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

/**
REFERENCES:
    1. Oracle. "How to Write a Component Listener." https://docs.oracle.com/javase/tutorial/uiswing/events/componentlistener.html
    2. BroCode YouTube Tutorial. "Java 2D animation 🎞️." https://youtu.be/tHNWIWxRDDA
    3. Baeldung. "How to Play Sound With Java." https://www.baeldung.com/java-play-sound
    4. GeeksforGeeks. "Java KeyListener in AWT." https://www.geeksforgeeks.org/java/java-keylistener-in-awt/
    5. Emojipedia. https://emojipedia.org/
    6. Oracle Documentation. "Interface Clip." https://docs.oracle.com/javase/8/docs/api/javax/sound/sampled/Clip.html
    7. Pixabay Lofi Music. "Lofi Chill." https://pixabay.com/music/lofi-lofi-chill-487321/
    8. Pixabay Lofi Music. "Good Night Lofi Cozy Chill." https://pixabay.com/music/beats-good-night-lofi-cozy-chill-music-160166/
    9. Pixabay Lofi Music. "Lofi Study Calm Peaceful." https://pixabay.com/music/beats-lofi-study-calm-peaceful-chill-hop-112191/
*/