package org.example;

import javax.swing.*;
import java.awt.*;

public class MemeButton extends JButton {
    private boolean tocando = false;

    public MemeButton(String imagem, String som) {
        this.setFocusPainted(false);
        this.setMargin(new Insets(0, 0, 0, 0));
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        this.setBackground(Color.WHITE);

        ImageIcon iconOriginal = new ImageIcon("src/main/resources/images/" + imagem);
        Image imgEscalada = iconOriginal.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        this.setIcon(new ImageIcon(imgEscalada));
    }

    public void setTocando(boolean status) {
        this.tocando = status;

        if (this.tocando) {
            // Quando estiver TOCANDO: Borda colorida (ex: Verde ou Amarelo) e espessa
            this.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
            this.setBackground(new Color(230, 255, 230)); // Um fundo levemente verde
        } else {
            this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
            this.setBackground(Color.WHITE);
        }

        this.repaint();
        this.revalidate();
    }
}



