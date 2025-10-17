// File: src/ru/mirea/as/practice8/Task3.java
package ru.mirea.as.practice8;

import javax.swing.*;

public class Task3 {
    public static void main(String[] args) {
        // Проверяем, был ли передан путь к картинке при запуске
        if (args.length == 0) {
            System.out.println("Ошибка: Вы не указали путь к изображению.");
            System.out.println("Пример запуска: java Task3 C:/path/to/image.jpg");
            return; // Завершаем программу, если путь не указан
        }

        // args[0] - это первый аргумент, переданный при запуске
        String imagePath = args[0];

        // Запускаем создание GUI в специальном потоке для безопасности
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Image Viewer (Task 3)");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Создаем иконку из файла по указанному пути
            ImageIcon imageIcon = new ImageIcon(imagePath);

            // Проверяем, загрузилась ли картинка
            if (imageIcon.getImageLoadStatus() == java.awt.MediaTracker.ERRORED) {
                System.out.println("Не удалось загрузить изображение по пути: " + imagePath);
                JOptionPane.showMessageDialog(frame, "Не удалось загрузить изображение!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }

            // Создаем метку (JLabel) для отображения иконки
            JLabel imageLabel = new JLabel(imageIcon);

            // Добавляем метку в окно
            frame.add(new JScrollPane(imageLabel)); // JScrollPane добавит прокрутку, если картинка большая

            // Автоматически подбираем размер окна под размер картинки
            frame.pack();

            // Центрируем окно на экране
            frame.setLocationRelativeTo(null);

            // Делаем окно видимым
            frame.setVisible(true);
        });
    }
}