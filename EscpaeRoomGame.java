import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EscapeRoomGame extends JFrame implements ActionListener {
    JTextArea story;
    JTextField input;
    JButton submit;
    int stage = 1;

    public EscapeRoomGame() {
        setTitle("Escape Room Game developed by Monty");
        setSize(500, 400);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        story = new JTextArea();
        story.setEditable(false);
        story.setFont(new Font("Arial", Font.BOLD, 14));
        add(new JScrollPane(story), BorderLayout.CENTER);

        JPanel panel = new JPanel();
        input = new JTextField(15);
        submit = new JButton("Submit");
        submit.addActionListener(this);
        panel.add(input);
        panel.add(submit);

        add(panel, BorderLayout.SOUTH);

        showStage1();
        setVisible(true);
    }

    void showStage1() {
        story.setText("You wake up in a locked room.\n\nClue: What has keys but can't open locks?\nType your answer:");
    }

    void showStage2() {
        story.setText("Door opens!\n\nYou see a box with a number lock.\nClue: What number comes next in series: 2, 4, 8, 16, ?\nType your answer:");
    }

    void showStage3() {
        story.setText("Box opens!\n\nFinal door asks:\nClue: I speak without a mouth and hear without ears. What am I?\nType your answer:");
    }

    public void actionPerformed(ActionEvent e) {
        String ans = input.getText().toLowerCase().trim();
        input.setText("");

        if (stage == 1 && ans.equals("keyboard")) {
            stage = 2;
            showStage2();
        } else if (stage == 2 && ans.equals("32")) {
            stage = 3;
            showStage3();
        } else if (stage == 3 && ans.equals("echo")) {
            JOptionPane.showMessageDialog(this, "Congratulations! You Escaped the Room!");
            System.exit(0);
        } else {
            JOptionPane.showMessageDialog(this, "Wrong answer! Try again.");
        }
    }

    public static void main(String[] args) {
        new EscapeRoomGame();
    }
}
