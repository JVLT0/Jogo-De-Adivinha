import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelMenuPrincipal extends JPanel {
    
    private Color cinzaFundo = new Color(75, 0, 130);
    private Color laranjaDestaque = new Color(255, 140, 0);
    private Player player; // Referência ao jogador

    public PanelMenuPrincipal(JFrame frame, Player player) {
        this.player = player; // Guardar referência do player
        setLayout(new BorderLayout());
        setBackground(cinzaFundo);

        JLabel tituloLabel = new JLabel("Escolha o modo de jogo", JLabel.CENTER);
        tituloLabel.setForeground(laranjaDestaque);
        add(tituloLabel, BorderLayout.NORTH);

        // Mostrar pontuação
        JLabel scoreLabel = new JLabel("Pontuação Atual: " + player.getScore(), JLabel.CENTER);
        scoreLabel.setForeground(Color.WHITE);
        add(scoreLabel, BorderLayout.SOUTH);

        JPanel botaoPanel = new JPanel();
        botaoPanel.setBackground(cinzaFundo);
        botaoPanel.setLayout(new FlowLayout());

        JButton botaoGameNumero = new JButton("Adivinhar número");
        botaoGameNumero.setBackground(laranjaDestaque);
        botaoGameNumero.setForeground(Color.WHITE);
        botaoGameNumero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelAdivinharNumero numeroPanel = new PanelAdivinharNumero(frame, player);
                frame.setContentPane(numeroPanel);
                frame.revalidate();
            }
        });

        JButton botaoGamePalavra = new JButton("Adivinhar palavra");
        botaoGamePalavra.setBackground(laranjaDestaque);
        botaoGamePalavra.setForeground(Color.WHITE);
        botaoGamePalavra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelAdivinharPalavra palavraPanel = new PanelAdivinharPalavra(frame, player);
                frame.setContentPane(palavraPanel);
                frame.revalidate();
            }
        });

        botaoPanel.add(botaoGameNumero);
        botaoPanel.add(botaoGamePalavra);
        add(botaoPanel, BorderLayout.CENTER);
    }
}
