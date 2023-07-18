package school;

import javax.swing.*;

public class ThreadFirst extends Thread {

    static int y = 0;

    public void run() {
        while (!Thread.currentThread().isInterrupted()) {

            try {
                Thread.sleep(100);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Hello", ex.getMessage(), JOptionPane.OK_OPTION);
            }
            y += 1;
        }
    }

    public int getY() {
        return y;
    }
}
