package com.shpp.p2p.cs.vzablotskyi.assignment1;

import com.shpp.karel.KarelTheRobot;

public class HelperClass extends KarelTheRobot {
    //*****************GENERAL METHODS*****************
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

    // the method checks whether the hero can move forward
    // and takes one step forward
    public void isCanMoveStraightAhead() throws Exception {
        if (frontIsClear())
            move();
    }

    public void fillCell() throws Exception {
        if (noBeepersPresent())
            putBeeper();
        isCanMoveStraightAhead();
    }

    //*****************ASSIGMENT1 METHODS*****************
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

    // The method returns the hero home
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

    //*****************ASSIGMENT1 METHODS*****************
    // method fills horizontal odd rows with stones
    public void fillHorizontalRows() throws Exception {
        while (frontIsClear()) {
            while (frontIsClear()) {
                fillCell();
            }
            turnAround();
            while (frontIsClear()) {
                fillCell();
            }
            turnRight();
            if (frontIsClear()) {
                isCanMoveStraightAhead();
                turnRight();
            }
        }
    }

    // method fills vertical rows with stones
    public void fillVerticalRows() throws Exception {
        while (frontIsClear()) {
            turnLeft();
            while (frontIsClear()) {
                fillCell();
            }
            turnAround();
            while (frontIsClear()) {
                fillCell();
            }
            turnLeft();
            isCanMoveStraightAhead();
        }
        turnLeft();
        while (frontIsClear()) {
            fillCell();
        }
        turnAround();
        while (frontIsClear()) {
            fillCell();
        }
    }

//    // the method fills the three highest points of
//    // the north side of the location with pebbles
//    public void fillTopColumns() throws Exception {
//        isCanMoveStraightAhead();
//        turnRight();
//        move();
//        putBeeper();
//        turnLeft();
//        move();
//        putBeeper();
//        move();
//        putBeeper();
//        turnAround();
//        move();
//        turnLeft();
//        move();
//        putBeeper();
//        turnAround();
//        move();
//        move();
//        turnRight();
//        move();
//        move();
//    }
}
