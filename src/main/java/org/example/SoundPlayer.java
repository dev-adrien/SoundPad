package org.example;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Clip.*;
import javax.sound.sampled.LineEvent;
import javax.swing.*;
import java.io.File;

public class SoundPlayer {

    public void tocar(String caminhoArquivo, Runnable aoTerminar) {
        try {
            File song = new File(caminhoArquivo);
            AudioInputStream som = AudioSystem.getAudioInputStream(song);
            Clip clip = AudioSystem.getClip();
            clip.open(som);

            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    clip.close();
                    // O Swing precisa que mudanças na interface ocorram na thread principal
                    SwingUtilities.invokeLater(aoTerminar);
                }
            });


            clip.start();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
