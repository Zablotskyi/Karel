package com.shpp.p2p.cs.vzablotskyi.assignment1;

import com.shpp.karel.KarelTheRobot;

public class Assigment1Part1 extends KarelTheRobot {
    @Override
    public void run() throws Exception {
        move();
        pause();
        turnLeft();
        pickBeeper();
        pickBeeper();
        pickBeeper();
        pickBeeper();
        move();
        move();
        move();

    }
}
