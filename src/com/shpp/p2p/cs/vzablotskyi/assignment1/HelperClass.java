package com.shpp.p2p.cs.vzablotskyi.assignment1;

import com.shpp.karel.KarelTheRobot;

public class HelperClass extends KarelTheRobot {
    //*****************GENERAL METHODS*****************
    // the method turns Karel 90 degrees clockwise
    protected void turnRight() throws Exception {
        turnLeft();
        turnLeft();
        turnLeft();
    }

    // the method turns Karel 180 degrees clockwise
    protected void turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }

    // the method checks whether the hero can move forward
    // and takes one step forward
    protected void checkIfCanStepForwardAndTakeOneStep() throws Exception {
        if (frontIsClear())
            move();
    }

    protected void fillCell() throws Exception {
        if (noBeepersPresent())
            putBeeper();
        checkIfCanStepForwardAndTakeOneStep();
    }

    //the method moves the hero to the opposite wall
    protected void moveToTheOppositeWall() throws Exception {
        while (frontIsClear()) {
            checkIfCanStepForwardAndTakeOneStep();
        }
    }

    //*****************ASSIGMENT1 METHODS*****************
    // The method allows you to go and pick up a newspaper that
    // is lying on the doorstep outside the door
    protected void pickTheNewspaper() throws Exception {
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
    protected void goHome() throws Exception {
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
    protected void fillHorizontalRows() throws Exception {
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
                checkIfCanStepForwardAndTakeOneStep();
                turnRight();
            }
        }
    }

    // method fills vertical rows with stones
    protected void fillVerticalRows() throws Exception {
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
            checkIfCanStepForwardAndTakeOneStep();
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

    //*****************ASSIGMENT3 METHODS*****************
    // method places the beeper in front of the opposite wall and turns 180 degrees.
    // If we have a beeper on the way to the wall, we place the beeper in front of it
    protected void putBeeperAgainstTheOppositeWall() throws Exception {
        for (int i = 0; i < 2; i++) {
            moveToTheOppositeWall();
            turnAround();
            fillCell();
            move();
            if (beepersPresent()) {
                turnAround();
                move();
                if (noBeepersPresent()) {
                    turnAround();
                    fillCell();
                    move();
                }
            }
        }
        fillCell();
    }
}
