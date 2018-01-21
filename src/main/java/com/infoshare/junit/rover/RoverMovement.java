package com.infoshare.junit.rover;

import java.util.stream.IntStream;

public class RoverMovement {


     static int[] move(int positionX, int positionY,String orientation) {

        switch (orientation) {
            case "N":
                positionY++;
                break;
            case "S":
                positionY--;
                break;
            case "E":
                positionX++;
                break;
            case "W":
                positionX--;
                break;
        }
        int[] result = {positionX,positionY};
        return result;
    }


    static String turn(char turn, String orientation) {
        int turnIndex = find(orientation);
        int newIndex = 0;
        if (turn=='L') {

            newIndex = turnIndex > 0 ? turnIndex - 1 : 3;
        } else if (turn=='R') {
            newIndex = turnIndex < 3 ? turnIndex + 1 : 0;
        }
       return Rover.directions[newIndex];
    }

    static int find(String turn) {
        return IntStream.range(0, Rover.directions.length)
                .filter(i -> turn.equals(Rover.directions[i]))
                .findFirst().orElse(-1);
    }
}
