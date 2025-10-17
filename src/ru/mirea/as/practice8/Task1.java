// File: src/ru/mirea/as/practice8/Task1.java
package ru.mirea.as.practice8;

import javax.swing.*;
import java.awt.*;

public class Task1 extends JFrame {

    private int milanScore = 0;
    private int madridScore = 0;

    public Task1() {
        super("Match Simulator (Task 1)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        JButton milanButton = new JButton("AC Milan");
        JButton madridButton = new JButton("Real Madrid");
        JLabel resultLabel = new JLabel("Result: 0 X 0", SwingConstants.CENTER);
        JLabel lastScorerLabel = new JLabel("Last Scorer: N/A", SwingConstants.CENTER);
        JLabel winnerLabel = new JLabel("Winner: DRAW", SwingConstants.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(milanButton);
        buttonPanel.add(madridButton);

        JPanel infoPanel = new JPanel(new GridLayout(3, 1));
        infoPanel.add(resultLabel);
        infoPanel.add(lastScorerLabel);
        infoPanel.add(winnerLabel);

        add(buttonPanel, BorderLayout.NORTH);
        add(infoPanel, BorderLayout.CENTER);

        milanButton.addActionListener(e -> {
            milanScore++;
            updateGUI("AC Milan", resultLabel, lastScorerLabel, winnerLabel);
        });

        madridButton.addActionListener(e -> {
            madridScore++;
            updateGUI("Real Madrid", resultLabel, lastScorerLabel, winnerLabel);
        });
    }

    private void updateGUI(String scorer, JLabel res, JLabel last, JLabel win) {
        res.setText("Result: " + milanScore + " X " + madridScore);
        last.setText("Last Scorer: " + scorer);
        if (milanScore > madridScore) win.setText("Winner: AC Milan");
        else if (madridScore > milanScore) win.setText("Winner: Real Madrid");
        else win.setText("Winner: DRAW");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Task1().setVisible(true));
    }
}