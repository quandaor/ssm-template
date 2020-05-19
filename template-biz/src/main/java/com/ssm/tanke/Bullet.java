package com.ssm.tanke;

import lombok.Data;

import java.awt.*;
import java.util.Iterator;

/**
 * @author quandaoran
 * @date 2020-05-19
 * @description
 */
@Data
public class Bullet {

    private int x, y;
    private Dir dir;
    private boolean live = true;
    private TanKeFrame tanKeFrame;

    private static final int WEIGHT = 15, HEIGHT = 15;
    private static final int SPEED = 5;

    public Bullet(int x, int y, Dir dir, TanKeFrame tanKeFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tanKeFrame = tanKeFrame;
    }

    public void paint(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillOval(x, y, WEIGHT, HEIGHT);
        tanKeFrame.bullets.removeIf((bullet -> !bullet.isLive()));
        move();
    }

    @SuppressWarnings(value = "all")
    private void move() {
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }
        if (x < 0 || y < 0 || x > TanKeFrame.GAME_WIDTH || y > TanKeFrame.GAME_HEIGHT) {
            live = false;
        }
    }
}
