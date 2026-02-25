/**
    The AudioPlayer class handles the loading and playback of audio files within the application. 
    It provides an interface for starting, pausing, and switching between different soundtracks.

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

import javax.sound.sampled.*;
import java.io.*;

public class AudioPlayer{
    private Clip clip;
    private String status;

    AudioInputStream audioInputStream;
    public static String filePath;

    /**
        Constructs an AudioPlayer and loads the initial audio file.
        It prepares the AudioInputStream and opens the clip for playback.
        @param filePath The relative path to the audio file.
    */
    public AudioPlayer(String filePath){
        this.filePath = filePath;

        try{
            audioInputStream = AudioSystem.getAudioInputStream(new File(this.filePath).getAbsoluteFile());

            clip = AudioSystem.getClip();

            clip.open(audioInputStream);
        }

        catch (Exception ex){
            System.out.println("Error");
        }
    }

    /**
        Stops the current track and loads a new audio file to start.
        This method ensures the previous resources are closed before opening a new stream.
        @param filePath The path of the new audio track to play.
    */
    public void switchTrack(String filePath){
        clip.stop();
        clip.close();

        this.filePath = filePath;

        try{
            audioInputStream = AudioSystem.getAudioInputStream(new File(this.filePath).getAbsoluteFile());

            clip = AudioSystem.getClip();

            clip.open(audioInputStream);
            clip.start();

            status = "play";
        }

        catch (Exception ex){
            System.out.println("Error");
        }
    }

    /**
        Starts or resumes the audio playback.
        Updates the status of the player to "play".
    */
    public void play(){
        clip.start();
        status = "play";
    }

    /**
        Pauses the audio playback.
        Updates the status of the player to "pause".
    */
    public void pause(){
        clip.stop();
        status = "pause";
    }

    /**
        Returns the Clip object currently managed by the player.
        @return The Clip instance.
    */
    public Clip getClip(){
        return clip;
    }

    /**
        Returns the current playback status.
        @return The status string.
    */
    public String getStatus(){
        return status;
    }
}

/**
REFERENCES:
    1. GeeksforGeeks. "Play Audio File using Java." https://www.geeksforgeeks.org/java/play-audio-file-using-java/
*/