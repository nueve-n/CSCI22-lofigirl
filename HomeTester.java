import javax.swing.*;

public class HomeTester{
    public static void main(String[] args){
        //add responsiveness; panel resize listeners
        int w = 800;
        int h = 600;
        
        HomeFrame hf = new HomeFrame(w, h);
        hf.setUp();
        hf.setUpListener();
    }
}