import java.util.Timer;
import java.util.TimerTask;

public class SceneStarter{
    public static void main(String[] args){
        int w = 800;
        int h = 600;
        
        SceneFrame hf = new SceneFrame(w, h);
        hf.setUp();
        hf.setUpTimer();
        hf.setUpListener();
    }
}