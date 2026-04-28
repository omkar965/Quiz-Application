package project;

import java.util.TimerTask;

public class Timer {

    volatile boolean timeUp = false;

    public void startTimer(int seconds) {

        java.util.Timer timer = new java.util.Timer();

        timer.schedule(new TimerTask() {
            public void run() {
                timeUp = true;   // ❌ print काढला (important)
                timer.cancel();
            }
        }, seconds * 1000);
    }
}