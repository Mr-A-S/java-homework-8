// File: src/ru/mirea/as/practice8/DrawingPanel.java
package ru.mirea.as.practice8;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class DrawingPanel extends JPanel {
    private final List<Shape> shapes = new ArrayList<>();

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    // Этот метод вызывается автоматически, когда панель нужно перерисовать
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape shape : shapes) {
            shape.draw(g);
        }
    }
}