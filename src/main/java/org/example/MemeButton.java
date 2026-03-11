package org.example;

import javax.swing.*;
import java.awt.*;

public class MemeButton extends JButton {
    private boolean tocando = false;

    public MemeButton(String imagem, String som) {
        this.setFocusPainted(false);
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        this.setBackground(Color.WHITE);

        String foto = "resources/images/" + imagem;
        this.setIcon(new ImageIcon(foto));

    }

    public void setTocando(boolean status) {
        this.tocando = status;

        if (this.tocando) {
            // Quando estiver TOCANDO: Borda colorida (ex: Verde ou Amarelo) e espessa
            this.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
            this.setBackground(new Color(230, 255, 230)); // Um fundo levemente verde
        } else {
            // Quando PARAR: Volta para a borda cinza original
            this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
            this.setBackground(Color.WHITE);
        }

        // Dica: Isso força o Swing a redesenhar o botão imediatamente
        this.repaint();
        this.revalidate();
    }
}



