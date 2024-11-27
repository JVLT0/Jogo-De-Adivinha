import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelAdivinharPalavra extends JPanel {
    private String palavraEmbaralhada;
    private String palavraOriginal;
    private Player player;

    private Color cinzaFundo = new Color(75, 0, 130);
    private Color cinzaClaro = new Color(200, 200, 200);
    private Color laranjaDestaque = new Color(255, 140, 0);

    private JLabel feedbackLabel;

    public PanelAdivinharPalavra(JFrame frame, Player player) {
        this.player = player; // Usar a mesma referência de player
        PalavrasEmbaralhada embaralhar = new PalavrasEmbaralhada();
        palavraEmbaralhada = embaralhar.getPalavraEmbaralhada();
        palavraOriginal = embaralhar.getPalavraOriginal();

        setLayout(new BorderLayout());
        setBackground(cinzaFundo);

        JLabel tituloLabel = new JLabel("Adivinhe a palavra embaralhada", JLabel.CENTER);
        tituloLabel.setForeground(laranjaDestaque);
        add(tituloLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        inputPanel.setBackground(cinzaFundo);

        JLabel palavraLabel = new JLabel("Palavra: " + palavraEmbaralhada);
        palavraLabel.setForeground(cinzaClaro);
        JTextField adivinharField = new JTextField(10);
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
                String adivinhar = adivinharField.getText();

                if (adivinhar.equalsIgnoreCase(palavraOriginal)) {
                    player.addPoints(20);
                    feedbackLabel.setText("Você acertou! Pontuação: " + player.getScore());
                } else {
                    feedbackLabel.setText("Palavra errada! Era: " + palavraOriginal);
                }

                feedbackLabel.setVisible(true);
                validate();
                repaint();
            }
        });

        inputPanel.add(palavraLabel);
        inputPanel.add(adivinharField);
        inputPanel.add(adivinharButton);
        add(inputPanel, BorderLayout.CENTER);

        // Criar um painel para feedback e botão de voltar
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
        southPanel.setBackground(cinzaFundo);

        // Adicionar o feedback e o botão ao painel "southPanel"
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
 
        // Adicionar o painel "southPanel" ao BorderLayout.SOUTH
        add(southPanel, BorderLayout.SOUTH);
    }
}
