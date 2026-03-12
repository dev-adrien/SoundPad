package org.example;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class MemeButton extends JButton {
    private boolean tocando = false;

    public MemeButton(String imagem, String som) {
        this.setFocusPainted(false);
        this.setMargin(new Insets(0, 0, 0, 0));
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        this.setBackground(Color.WHITE);

        String caminhoImagem = "src/main/resources/images/" + imagem;
        File arquivo = new File(caminhoImagem);

        if (arquivo.exists()) {
            ImageIcon iconOriginal = new ImageIcon(caminhoImagem);

            Image imgEscalada = iconOriginal.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH); // tentativa de deixar a imagem do tamanho do botão
            this.setIcon(new ImageIcon(imgEscalada));
        } else {
            this.setText(som);
            System.out.println("Erro: imagem não encontrada");

        }
    }

    public void setTocando(boolean status) {
        this.tocando = status;

        if (this.tocando) {
            this.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));
            this.setBackground(new Color(230, 230, 255));
        } else {
            this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
            this.setBackground(Color.WHITE);
        }

        this.repaint();
        this.revalidate();
    }
}



