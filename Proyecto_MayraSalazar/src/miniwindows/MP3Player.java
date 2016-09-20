/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniwindows;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.AudioDevice;
import javazoom.jl.player.Player;

/**
 *
 * @author Sindy
 */
public class MP3Player{

    private final static int INIT = 0;
    private final static int PLAYING = 1;
    private final static int PAUSED = 2;
    private final static int STOP = 3;

    private final Player player;

    private final Object communicate = new Object();

    private int playerStatus = INIT;

    public MP3Player(final InputStream inputStream) throws JavaLayerException {
        this.player = new Player(inputStream);
    }

    public MP3Player(final InputStream inputStream, final AudioDevice audioDevice) throws JavaLayerException {
        this.player = new Player(inputStream, audioDevice);
    }

    public void play() throws JavaLayerException {
        synchronized (communicate) {
            switch (playerStatus) {
                case INIT:
                    final Runnable r = new Runnable() {
                        public void run() {
                            playInternal();
                        }
                    };
                    final Thread t = new Thread(r);
                    t.setDaemon(true);
                    t.setPriority(Thread.MAX_PRIORITY);
                    playerStatus = PLAYING;
                    t.start();
                    break;
                case PAUSED:
                    resume();
                    break;
                default:
                    break;
            }
        }
    }
    public boolean pause() {
        synchronized (communicate) {
            if (playerStatus == PLAYING) {
                playerStatus = PAUSED;
            }
            return playerStatus == PAUSED;
        }
    }
    public boolean resume() {
        synchronized (communicate) {
            if (playerStatus == PAUSED) {
                playerStatus = PLAYING;
                communicate.notifyAll();
            }
            return playerStatus == PLAYING;
        }
    }
    public void stop() {
        synchronized (communicate) {
            playerStatus = STOP;
            communicate.notifyAll();
        }
    }

    private void playInternal() {
        while (playerStatus != STOP) {
            try {
                if (!player.play(1)) {
                    break;
                }
            } catch (final JavaLayerException e) {
                break;
            }
            synchronized (communicate) {
                while (playerStatus == PAUSED) {
                    try {
                        communicate.wait();
                    } catch (final InterruptedException e) {
                        break;
                    }
                }
            }
        }
        close();
    }

    public void close() {
        synchronized (communicate) {
            playerStatus = STOP;
        }
        try {
            player.close();
        } catch (final Exception e) {
        }
    }
}
