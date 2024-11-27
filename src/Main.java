import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Jogo de Adivinhação");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);

        Player player = new Player(); 
        PanelMenuPrincipal mainMenu = new PanelMenuPrincipal(frame, player);
        frame.setContentPane(mainMenu);
        frame.setVisible(true);
    }
}
