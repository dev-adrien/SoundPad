package org.example;
import javax.swing.*;
import java.awt.*;

public class MemeSoundPad extends JFrame {
    private JPanel painel;
    private SoundPlayer player = new SoundPlayer();

    public MemeSoundPad() {
        setTitle("Meme Sound Pad");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        painel = new JPanel(new GridLayout(3, 3, 10, 10));


// Adicionar 9 botões com imagens e sons

        adicionarBotaoMeme("", "");
        adicionarBotaoMeme("", "");
        adicionarBotaoMeme("", "");
        adicionarBotaoMeme("", "");
        adicionarBotaoMeme("", "");
        adicionarBotaoMeme("", "");
        adicionarBotaoMeme("", "");
        adicionarBotaoMeme("", "");
        adicionarBotaoMeme("", "");

// ... mais 7

        add(painel);
        setVisible(true);
    }
    private void adicionarBotaoMeme(String imagem, String som) {
        JButton botao = new JButton();
        botao.setIcon(new ImageIcon("resources/images/" + imagem));
        botao.addActionListener(e -> {
// Tocar em thread separada
            //   new Thread(() -> player.tocar("resources/sounds/" + som)).start();
        });
        painel.add(botao);

    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(() ->{
            new MemeSoundPad().setVisible(true);
        });
    }
}