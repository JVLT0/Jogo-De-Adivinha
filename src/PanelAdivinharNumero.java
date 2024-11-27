import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PanelAdivinharNumero extends JPanel {
    private int numeroSecreto;
    private int tentativas;
    private Player player;

    private Color cinzaFundo = new Color(75, 0, 130);
    private Color cinzaClaro = new Color(200, 200, 200);
    private Color laranjaDestaque = new Color(255, 140, 0);

    private JLabel feedbackLabel;

    public PanelAdivinharNumero(JFrame frame, Player player) {
        this.player = player; // Usar a mesma referência de player
        numeroSecreto = (int) (Math.random() * 100) + 1;
        tentativas = 0;

        setLayout(new BorderLayout());
        setBackground(cinzaFundo);

        JLabel tituloLabel = new JLabel("Adivinhe o numero secreto (1 - 100)", JLabel.CENTER);
        tituloLabel.setForeground(laranjaDestaque);
        add(tituloLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        inputPanel.setBackground(cinzaFundo);

        JLabel adivinharLabel = new JLabel("Digite seu Palpite");
        adivinharLabel.setForeground(cinzaClaro);
        JTextField adivinharField = new JTextField(5);
        JButton adivinharButton = new JButton("Adivinhar");
        adivinharButton.setForeground(Color.WHITE);
        adivinharButton.setBackground(laranjaDestaque);

        feedbackLabel = new JLabel();
        feedbackLabel.setForeground(laranjaDestaque);
        feedbackLabel.setHorizontalAlignment(JLabel.CENTER);
        feedbackLabel.setVisible(false);  // Inicialmente oculto

        adivinharButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int adivinhar = Integer.parseInt(adivinharField.getText());
                    tentativas++;

                    if (adivinhar < numeroSecreto) {
                        feedbackLabel.setText("Muito Baixo");
                    } else if (adivinhar > numeroSecreto) {
                        feedbackLabel.setText("Muito Alto");
                    } else {
                        player.addPoints(10);
                        feedbackLabel.setText("Você acertou! Pontuação: " + player.getScore());

                        numeroSecreto = (int) (Math.random() * 100) + 1;
                        tentativas = 0;
                    }

                    feedbackLabel.setVisible(true);
                    validate();  // Atualizar o layout
                    repaint();   // Garantir que a interface seja repintada

                } catch (NumberFormatException ex) {
                    feedbackLabel.setText("Entrada inválida! Digite um número.");
                    feedbackLabel.setForeground(Color.RED);  // Mensagem de erro em vermelho
                    feedbackLabel.setVisible(true);
                    validate();
                    repaint();
                }
            }
        });

        inputPanel.add(adivinharLabel);
        inputPanel.add(adivinharField);
        inputPanel.add(adivinharButton);
        add(inputPanel, BorderLayout.CENTER);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
        southPanel.setBackground(cinzaFundo);
        
        southPanel.add(feedbackLabel);

        JButton backButton = new JButton("Menu Principal");
        backButton.setBackground(laranjaDestaque);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelMenuPrincipal mainMenu = new PanelMenuPrincipal(frame, player);
                frame.setContentPane(mainMenu);
                frame.revalidate();
            }
        });
        southPanel.add(backButton);

        
        add(southPanel, BorderLayout.SOUTH);
    }
}
