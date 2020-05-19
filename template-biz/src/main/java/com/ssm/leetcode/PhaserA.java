package com.ssm.leetcode;

import java.awt.*;
import java.io.IOException;
import java.util.concurrent.Phaser;

/**
 * @author quandaoran
 * @date 2020-05-10
 * @description
 */
public class PhaserA extends Phaser {

    public static void main(String[] args) throws IOException {
        ThreadLocal<PhaserA> tl1 = new ThreadLocal<>();
        ThreadLocal<PhaserA> tl2 = new ThreadLocal<>();

        tl1.set(
                new PhaserA()
        );

        tl2.set(new PhaserA());
        Thread thread = Thread.currentThread();

        System.in.read();

    }
}
