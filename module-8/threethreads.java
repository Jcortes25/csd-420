import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ThreeThreads extends JFrame {
    private static final int COUNT = 10000; // number of characters per thread
    private JTextArea textArea;
    private final Object lock = new Object(); // synchronization lock

    public ThreeThreads() {
        setTitle("Three Threads Output");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        setVisible(true);

        // Start threads
        new Thread(new LetterGenerator()).start();
        new Thread(new DigitGenerator()).start();
        new Thread(new SpecialCharGenerator()).start();
    }

    // Thread to generate letters
    class LetterGenerator implements Runnable {
        @Override
        public void run() {
            Random rand = new Random();
            for (int i = 0; i < COUNT; i++) {
                char letter = (char) ((rand.nextBoolean() ? 'A' : 'a') + rand.nextInt(26));
                appendToTextArea(letter);
            }
        }
    }

    // Thread to generate digits
    class DigitGenerator implements Runnable {
        @Override
        public void run() {
            Random rand = new Random();
            for (int i = 0; i < COUNT; i++) {
                char digit = (char) ('0' + rand.nextInt(10));
                appendToTextArea(digit);
            }
        }
    }

    // Thread to generate special characters
    class SpecialCharGenerator implements Runnable {
        private final char[] specialChars = {'!', '@', '#', '$', '%', '&', '*'};

        @Override
        public void run() {
            Random rand = new Random();
            for (int i = 0; i < COUNT; i++) {
                char special = specialChars[rand.nextInt(specialChars.length)];
                appendToTextArea(special);
            }
        }
    }

    // Thread-safe update to JTextArea
    private void appendToTextArea(char c) {
        synchronized (lock) {
            SwingUtilities.invokeLater(() -> textArea.append(String.valueOf(c)));
        }
    }

    // Main method to run the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ThreeThreads::new);
    }
}
