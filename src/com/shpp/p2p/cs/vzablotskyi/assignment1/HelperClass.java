package com.shpp.p2p.cs.vzablotskyi.assignment1;

import com.shpp.karel.KarelTheRobot;

public class HelperClass extends KarelTheRobot {
    // the method turns Karel 90 degrees clockwise
    public void turnRight() throws Exception {
        turnLeft();
        turnLeft();
        turnLeft();
    }

    // the method turns Karel 180 degrees clockwise
    public void turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }

    // The method allows you to go and pick up a newspaper that
    // is lying on the doorstep outside the door
    public void pickTheNewspaper() throws Exception {
        turnRight();
        move();
        turnLeft();
        move();
        move();
        move();
        move();
        pickBeeper();
    }

    public void goHome() throws Exception {
        turnAround();
        move();
        move();
        move();
        move();
        turnRight();
        move();
        turnRight();
        putBeeper();
    }
}
