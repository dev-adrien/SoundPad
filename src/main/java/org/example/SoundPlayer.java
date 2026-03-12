package org.example;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;

public class SoundPlayer {

    public void tocar(String caminhoArquivo, Runnable aoTerminar) {
        try {
            File song = new File(caminhoArquivo);
            if (!song.exists()) {
                System.out.println("Erro: arquivo não encontrado");
                if (aoTerminar != null) {
                    // aoTerminar.run();

                    SwingUtilities.invokeLater(aoTerminar);
                }

                return; // sai do método para nao travar
            }

            AudioInputStream som = AudioSystem.getAudioInputStream(song);
            Clip clip = AudioSystem.getClip();
            clip.open(som);
            clip.start();

            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    clip.close();
                    if (aoTerminar != null) {
                        SwingUtilities.invokeLater(aoTerminar);
                    } // mesmo metodo para fechar a borda
                }
            });


        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            if (aoTerminar != null) {
                SwingUtilities.invokeLater(aoTerminar);
            } // se der erro usa o mesmo metodo para desligar a borda
        }
    }
}
