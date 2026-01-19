import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class ColorfulGuessingGame {

    public static void main(String[] args) {

        Random random = new Random();
        int number = random.nextInt(100) + 1;
        int[] attempts = {5};

        JFrame frame = new JFrame("🎯 Guessing Game");
        frame.setSize(450, 300);
        frame.setLayout(null);

        // Background color
        frame.getContentPane().setBackground(new Color(44, 62, 80)); // dark blue

        JLabel title = new JLabel("Guess the Number (1 - 100)");
        title.setBounds(90, 20, 300, 30);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 18));

        JTextField input = new JTextField();
        input.setBounds(150, 70, 150, 35);
        input.setFont(new Font("Arial", Font.PLAIN, 16));

        JButton button = new JButton("CHECK");
        button.setBounds(170, 120, 100, 35);
        button.setBackground(new Color(46, 204, 113)); // green
        button.setForeground(Color.BLACK);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setFocusPainted(false);

        JLabel result = new JLabel("");
        result.setBounds(80, 180, 300, 30);
        result.setForeground(Color.YELLOW);
        result.setFont(new Font("Arial", Font.BOLD, 14));

        frame.add(title);
        frame.add(input);
        frame.add(button);
        frame.add(result);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (attempts[0] == 0) {
                    result.setText("❌ Game Over! Number was " + number);
                    button.setEnabled(false);
                    return;
                }

                int guess = Integer.parseInt(input.getText());
                attempts[0]--;

                if (guess == number) {
                    result.setText("🎉 Correct! You Win!");
                    button.setEnabled(false);
                } else if (guess > number) {
                    result.setText("📉 Too High! Attempts left: " + attempts[0]);
                } else {
                    result.setText("📈 Too Low! Attempts left: " + attempts[0]);
                }
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
