// File: src/ru.mirea.as.practice8/Task4.java
package ru.mirea.as.practice8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Task4 {

    private static int currentFrame = 0;
    // Укажи здесь, сколько у тебя всего кадров
    private static final int FRAME_COUNT = 3;
    private static ImageIcon[] frames = new ImageIcon[FRAME_COUNT];

    public static void main(String[] args) {
        // Загружаем все кадры в массив
        for (int i = 0; i < FRAME_COUNT; i++) {
            // Путь "img/frame..." работает, потому что мы положили папку img в корень проекта
            frames[i] = new ImageIcon("img/frame" + (i + 1) + ".png");
        }

        JFrame frame = new JFrame("Animation (Task 4)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Создаем JLabel и сразу устанавливаем ему первый кадр
        JLabel animationLabel = new JLabel(frames[0]);
        frame.add(animationLabel);

        // Timer - это класс Swing, который умеет выполнять код через равные промежутки времени
        // 200 миллисекунд = 5 кадров в секунду (1000 / 200 = 5)
        Timer timer = new Timer(800, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Эта часть кода будет выполняться каждые 200 мс
                currentFrame = (currentFrame + 1) % FRAME_COUNT; // Циклично переключаем кадр 0, 1, 2, 0, 1, 2...
                animationLabel.setIcon(frames[currentFrame]); // Устанавливаем новый кадр в наш JLabel
            }
        });
        timer.start(); // Запускаем таймер

        frame.pack(); // Подгоняем размер окна под размер картинки
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}