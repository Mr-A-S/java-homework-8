// File: src/ru/mirea/as/practice8/Task2.java
package ru.mirea.as.practice8;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("20 Random Shapes (Task 2)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        DrawingPanel panel = new DrawingPanel();
        Random rand = new Random();

        // Создаем 20 случайных фигур
        for (int i = 0; i < 20; i++) {
            int x = rand.nextInt(750);
            int y = rand.nextInt(550);
            Color color = new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat());

            if (rand.nextBoolean()) { // Случайно выбираем, что создать: круг или прямоугольник
                panel.addShape(new Circle(color, x, y, rand.nextInt(40) + 10));
            } else {
                panel.addShape(new Rectangle(color, x, y, rand.nextInt(80) + 20, rand.nextInt(80) + 20));
            }
        }

        frame.add(panel);
        frame.setVisible(true);
    }
}