package org.example;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Clip.*;
import java.io.File;

public class SoundPlayer {

    public void tocar(String caminhoArquivo) {
        try {
            File song = new File(caminhoArquivo);
            AudioInputStream som = AudioSystem.getAudioInputStream(song);
            Clip clip = AudioSystem.getClip();
            clip.open(som);
            clip.start();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
