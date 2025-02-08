package fr.funecirce.circlesexpanding;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

public class Circle {

    private final Point pos;
    private int radius;

    private int alpha;

    public Circle(int x, int y, int radius) {
        this.pos = new Point(x, y);
        this. radius = radius;

        Random rand = new Random();

        alpha = rand.nextInt(75,100);
    }

    public Circle(int radius) {
        this.pos = new Point(0, 0);
        this.radius = radius;
    }

    public void draw(Graphics g2d) {
        Random rand = new Random();
        g2d.setColor(new Color(
            rand.nextInt(150,255), 
            rand.nextInt(150,255), 
            rand.nextInt(150,255), 
            alpha));
        g2d.drawOval(pos.x, pos.y, radius, radius);
    }

    public boolean evolve() {
        Random rand = new Random();
        radius += 3;
        alpha -= rand.nextInt(1,3);

        return alpha <= 0;
    }

    public Point getPos() {
        return this.pos;
    }
}
