// File: src/ru/mirea/as/practice8/Shape.java
package ru.mirea.as.practice8;

import java.awt.*;

public abstract class Shape {
    protected Color color;
    protected int x, y;

    public Shape(Color color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    // Абстрактный метод, который должны будут реализовать все наследники
    public abstract void draw(Graphics g);
}