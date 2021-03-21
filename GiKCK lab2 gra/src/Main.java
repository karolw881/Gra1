import java.awt.EventQueue;
import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {

            var game = new Breakout();
            game.setVisible(true);
        });


    }
}
