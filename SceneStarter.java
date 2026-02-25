/**
    The SceneStarter class serves as the starter for the Lofi Girl application.
    It contains the main method, and it triggers the setup routines for the GUI, animations, audio, and user input listeners.

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

public class SceneStarter{

    /**
        The main method starts the execution.
        It instantiates the SceneFrame and prints the user control 
        instructions to the terminal.
    */
    public static void main(String[] args){
        int w = 800;
        int h = 600;
        
        SceneFrame hf = new SceneFrame(w, h);
        hf.setUpGUI();
        hf.setUpTimer();
        hf.setUpMusic();
        hf.setUpListener();

        System.out.println("Welcome to Lofi Girl Radio");
        System.out.println("Press [D] to change time to day");
        System.out.println("Press [N] to change time to night");
        System.out.println("Press [S] to randomize stars");
        System.out.println("Press [B] to randomize books");
        System.out.println("Press [L] to turn the lamp on/off");
    }
}