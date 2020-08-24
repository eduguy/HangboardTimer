import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Timer {

    private int sets;
    private int timeOnHang;
    private int restTime;
    AudioInputStream audioInputStream;
    Clip clip;

    //create a timer object that will tell you when to start/rest, time in seconds
    public Timer (int repetitions, int timeOnHang, int restTime) {
        this.sets = repetitions;
        this.timeOnHang = timeOnHang;
        this.restTime = restTime;
        try {
            audioInputStream =
                    AudioSystem.getAudioInputStream(new File("data/BeeperSound.wav").getAbsoluteFile());
            // create clip reference
            clip = AudioSystem.getClip();

            // open audioInputStream to the clip
            clip.open(audioInputStream);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }


    }

    public void countDown() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {

        }
        int i = 1;
        while (sets > 0) {
            clip.setMicrosecondPosition(0);
            clip.start();

            System.out.println("You are on set: " + i);
            System.out.println("Start");
            try {
                TimeUnit.SECONDS.sleep(timeOnHang);
            } catch (InterruptedException e) {
                System.out.println("Fail");
            }

            System.out.println("stop");
            clip.setMicrosecondPosition(0);
            clip.start();

            try {
                TimeUnit.SECONDS.sleep(restTime);
            } catch (InterruptedException e) {
                System.out.println("Fail");
            }

            i++;
            sets--;
        }
    }


}
