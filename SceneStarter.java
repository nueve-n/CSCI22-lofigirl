import javax.swing.*;

public class SceneStarter{
    public static void main(String[] args){
        //add responsiveness; panel resize listeners
        int w = 800;
        int h = 600;
        
        SceneFrame hf = new SceneFrame(w, h);
        hf.setUp();
        hf.setUpListener();
    }
}