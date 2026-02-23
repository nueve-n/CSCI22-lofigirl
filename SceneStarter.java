import java.util.Timer;
import java.util.TimerTask;

public class SceneStarter{
    public static void main(String[] args){
        int w = 800;
        int h = 600;
        
        SceneFrame hf = new SceneFrame(w, h);
        hf.setUp();
        hf.setUpTimer();
        hf.setUpMusic();
        hf.setUpListener();

        System.out.println("Welcome to Lofi Girl Radio");
        System.out.println("Press d to change time to day");
        System.out.println("Press n to change time to night");
        System.out.println("Press s to change time to randomize stars");
        System.out.println("Press b to change time to randomize books");
    }
}