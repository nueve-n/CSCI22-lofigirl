import java.util.*;

public class Clock extends TimerTask{
    public static int i = 0;

    public void run(){
        i++;

        System.out.println("it's working");
    }
}