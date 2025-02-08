package fr.funecirce.circlesexpanding;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener, MouseListener{

    public final int X_SIZE = 600;
    public final int Y_SIZE = 400;
    public final Dimension WINDOW_SIZE = new Dimension(X_SIZE, Y_SIZE);

    private final int DELAY = 10;
    private int cooldown = 0;

    @SuppressWarnings("FieldMayBeFinal")
    private ArrayList<Circle> circles = new ArrayList<>();

    private final Timer timer;

    public Board() {
        setPreferredSize(WINDOW_SIZE);
        setBackground(new Color(0,0,0));

        timer = new Timer(DELAY, this);

        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(3));

        for(Circle circle : circles) {
            circle.draw(g2d);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Point pos = e.getPoint();
        int radius = 50;
        int offset = 10;
        
        circles.add(new Circle(pos.x-radius/2-offset, pos.y-radius-offset, radius));
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(cooldown != 0) reduceCooldown(DELAY);
        
        updateCircles();

        repaint();
    }

    public void updateCircles() {
        ArrayList<Circle> fadedCircles = new ArrayList<>();
        for(Circle circle : circles) {
            if(circle.evolve()) {
                fadedCircles.add(circle);
            }
        }
        circles.removeAll(fadedCircles);
    }

    public void reduceCooldown(int amount) {
        cooldown-=amount;
    }

}
