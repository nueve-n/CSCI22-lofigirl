import javax.swing.*;

public class HomeFrame{
    int w, h;
    JFrame f;
    Home homeComponent;
    public HomeFrame(int width, int height){
        //add responsiveness; panel resize listeners
        w = width;
        h = height;
        f = new JFrame();
        homeComponent = new Home(w, h);
    }

    public void setUp(){
        f.setSize(w,h);
        f.setTitle("LofiGirl_MacalalalagxRanario");
        f.add(homeComponent);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}