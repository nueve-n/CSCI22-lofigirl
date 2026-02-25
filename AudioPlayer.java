import javax.sound.sampled.*;
import java.io.*;

public class AudioPlayer{
    private Clip clip;
    private String status;

    AudioInputStream audioInputStream;
    public static String filePath;

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

    public void play(){
        clip.start();
        status = "play";
    }

    public void pause(){
        clip.stop();
        status = "pause";
    }
    public Clip getClip(){
        return clip;
    }

    public String getStatus(){
        return status;
    }
}