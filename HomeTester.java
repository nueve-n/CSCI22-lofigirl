import javax.swing.*;

public class HomeTester{
    public static void main(String[] args){
        //add responsiveness; panel resize listeners
        int w = 800;
        int h = 600;
        JFrame f = new JFrame();

        Home homeComponent = new Home(w, h);
        
        f.setSize(w,h);
        f.setTitle("LofiGirl_MacalalalagxRanario");
        f.add(homeComponent);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}