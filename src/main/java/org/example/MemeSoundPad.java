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
        setLocationRelativeTo(null);

        painel = new JPanel(new GridLayout(3, 3, 10, 10));


// Adicionar 9 botões com imagens e sons


        adicionarBotaoMeme("imagen1.jpg", "gato rindo.wav");
        adicionarBotaoMeme("imagen4.jpg", "TAPORRA MENÓ.wav");
        adicionarBotaoMeme("imagen3.png", "");
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
        MemeButton botao = new MemeButton(imagem, som);
        botao.addActionListener(e -> {
            // 1. Muda a cor para "Tocando"
            botao.setTocando(true);

            new Thread(() -> {
                // 2. Toca o som e passa o que deve acontecer ao terminar
                player.tocar("src/main/resources/sounds/" + som, () -> {
                    // 3. Volta a cor ao normal
                    botao.setTocando(false);
                });
            }).start();
        });

        painel.add(botao);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MemeSoundPad().setVisible(true);
        });
    }}
