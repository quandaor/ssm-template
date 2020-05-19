package com.ssm.tanke;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;

/**
 * @author quandaoran
 * @date 2020-05-18
 * @description
 */
@Setter
@Getter
public class Tank {

    private int x, y;

    private Dir dir;

    private static final int SPEED = 10;

    private Boolean moving = false;

    private TanKeFrame tanKeFrame;

    public Tank(int x, int y, Dir dir, TanKeFrame tanKeFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tanKeFrame = tanKeFrame;
    }

    public void fire() {
        tanKeFrame.bullets.add(new Bullet(this.x, this.y, this.dir, this.tanKeFrame));
    }

    public void paint(Graphics g) {
        g.fillRect(x, y, 50, 50);
        if (!moving) {
            return;
        }
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
    }
}
