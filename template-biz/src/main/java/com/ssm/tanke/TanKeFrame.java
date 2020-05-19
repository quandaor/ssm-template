package com.ssm.tanke;

import com.google.common.collect.Lists;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author quandaoran
 * @date 2020-05-17
 * @description
 */
public class TanKeFrame extends Frame {


    private Tank tank = new Tank(50, 50, Dir.DOWN, this);

    List<Bullet> bullets = Lists.newArrayList();

    public static final int GAME_WIDTH = 800, GAME_HEIGHT = 600;

    private TanKeFrame() {

        setTitle("Tank War");
        setResizable(false);
        setSize(GAME_WIDTH, GAME_HEIGHT);

        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        this.addKeyListener(new KeyListener());

        setVisible(true);
    }


    private Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.WHITE);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    /**
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.cyan);
        g.drawString("子弹的数量:" + bullets.size(), 10, 60);
        g.setColor(c);
        tank.paint(g);
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }
    }

    class KeyListener extends KeyAdapter {

        private boolean leftFlag = false;
        private boolean upFlag = false;
        private boolean rightFlag = false;
        private boolean downFlag = false;

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();

            switch (keyCode) {
                case KeyCode.LEFT:
                    leftFlag = true;
                    break;
                case KeyCode.UP:
                    upFlag = true;
                    break;
                case KeyCode.RIGHT:
                    rightFlag = true;
                    break;
                case KeyCode.DOWN:
                    downFlag = true;
                    break;
                case KeyCode.CONTROL:
                    tank.fire();
                    break;
                default:
                    break;
            }
            setTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyCode.LEFT:
                    leftFlag = false;
                    break;
                case KeyCode.UP:
                    upFlag = false;
                    break;
                case KeyCode.RIGHT:
                    rightFlag = false;
                    break;
                case KeyCode.DOWN:
                    downFlag = false;
                    break;
                default:
                    break;
            }
            setTankDir();
        }


        void setTankDir() {
            if (!leftFlag && !rightFlag && !downFlag && !upFlag) {
                tank.setMoving(false);
            } else {
                tank.setMoving(true);
                if (leftFlag) tank.setDir(Dir.LEFT);
                if (rightFlag) tank.setDir(Dir.RIGHT);
                if (downFlag) tank.setDir(Dir.DOWN);
                if (upFlag) tank.setDir(Dir.UP);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TanKeFrame frame = new TanKeFrame();
        while (true) {
            TimeUnit.MILLISECONDS.sleep(50);
            frame.repaint();
        }
    }
}
