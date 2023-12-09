package com.shpp.p2p.cs.vzablotskyi.assignment1;

import com.shpp.karel.KarelTheRobot;

public class HelperClass extends KarelTheRobot {
    //**********************************GENERAL METHODS***************************************************
/*     the method turns Karel 90 degrees clockwise*/
    protected void turnRight() throws Exception {
        turnLeft();
        turnLeft();
        turnLeft();
    }

/*     the method turns Karel 180 degrees clockwise*/
    protected void turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }

/*     the method checks whether the hero can move forward
     and takes one step forward*/
    protected void checkIfCanStepForwardAndTakeOneStep() throws Exception {
        if (frontIsClear())
            move();
    }

/*     the method checks if there is a beeper in the cell, if not, then sets the beeper,
     checks if it can step forward, and takes a step forward*/
    protected void fillCell() throws Exception {
        if (noBeepersPresent())
            putBeeper();
        checkIfCanStepForwardAndTakeOneStep();
    }

/*    the method moves the hero to the opposite wall*/
    protected void moveToTheOppositeWall() throws Exception {
        while (frontIsClear()) {
            checkIfCanStepForwardAndTakeOneStep();
        }
    }

/*    the method clears the field of beepers horizontally from the point where the hero stands and
     in the direction where he looks*/
    protected void cleanTheLine() throws Exception {
        while (frontIsClear()) {
            pickBeeper();
            checkIfCanStepForwardAndTakeOneStep();
        }
        pickBeeper();
    }

/*    the method checks if there is a beeper one step ahead of the hero (takes a step forward, if there is a beeper,
     turns around, takes a step and turns around again)*/
    protected void checkIfThereIsABeeperAhead() throws Exception {
        checkIfCanStepForwardAndTakeOneStep();
        if (beepersPresent()) {
            turnAround();
            move();
            turnAround();
        }
    }

    //**********************************ASSIGNMENT1 METHODS***************************************************
/*     The method allows you to go to the newspaper that
     is lying on the threshold outside the door*/
    protected void pickTheNewspaper() throws Exception {
        pickBeeper();
    }

/*     the method allows the hero to take the newspaper*/
    protected void goToTheNewspaper() throws Exception {
        turnRight();
        move();
        turnLeft();
        move();
        move();
        move();
        move();
    }

/*     The method returns the hero home*/
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

    //**********************************ASSIGNMENT2 METHODS***************************************************
/*     method fills horizontal odd rows with stones*/
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

/*     method fills vertical rows with stones*/
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

/*    method allows the hero to fill all columns with beepers*/
    protected void fillTheColumnsWithBeepers() throws Exception {
        while (leftIsClear()) {
            if (leftIsClear())
                turnLeft();
            while (frontIsClear()) {
                fillCell();
            }
            turnAround();
            fillCell();
            while (frontIsClear()) {
                move();
            }
            if (leftIsClear()) {
                turnLeft();
                for (int i = 0; i < 4; i++) {
                    move();
                }
            }
        }
    }

    //**********************************ASSIGNMENT3 METHODS***************************************************
/*     The method places the beeper in front of the opposite wall and rotates it 180 degrees.
     Goes to the second opposite wall and also places a beeper and rotates 180 degrees again*/
    protected void putBeeperAgainstTheOppositeWall() throws Exception {
        moveToTheOppositeWall();
        fillCell();
        turnAround();
        moveToTheOppositeWall();
        fillCell();
        turnAround();
    }

/*     The method places a beeper in front of the opposite beeper and rotates it 180 degrees.
     Moves to the second opposite beeper and also places a beeper, and again rotates it 180 degrees*/
    protected void putTheBeeperInFrontOfTheBeeper() throws Exception {
        move();
        while (noBeepersPresent()) {
            move();
            if (beepersPresent()) {
                turnAround();
                move();
                putBeeper();
            }
        }
        move();
    }

/*    The method allows the hero to walk in a straight line and place beepers on opposite sides, thus moving
     to the center of the board and stopping on a cent. In the center, the hero places two beepers*/
    protected void placeTheBeeperInFrontOfTheBeeperOnOppositeSidesUntilYouReachTheMiddle() throws Exception {
        putBeeperAgainstTheOppositeWall();
        move();
        while (noBeepersPresent()) {
            putTheBeeperInFrontOfTheBeeper();
        }
        turnAround();
        while (beepersPresent()) {
            move();
        }
        putBeeper();
        putBeeper();
        returnToStart();
        cleanTheLine();
    }

/*     method returns the character to the starting position*/
    protected void returnToStart() throws Exception {
        moveToTheOppositeWall();
        turnAround();
    }

    //**********************************ASSIGNMENT4 METHODS***************************************************
/*     the hero appears in the lower right corner. Then he begins to walk around the given area
     and staggeredly fill it with beamers.*/
    protected void fillInTheChessboard() throws Exception {
        while (noBeepersPresent() && frontIsClear()) {
            while (frontIsClear()) {
                fillCell();
                checkIfCanStepForwardAndTakeOneStep();
            }
            turnLeft();
            checkIfCanStepForwardAndTakeOneStep();
            turnLeft();
            while (frontIsClear()) {
                fillCell();
                checkIfCanStepForwardAndTakeOneStep();
            }
            if (rightIsClear())
                turnRight();
            checkIfCanStepForwardAndTakeOneStep();
            if (noBeepersPresent())
                turnRight();
        }
    }
}