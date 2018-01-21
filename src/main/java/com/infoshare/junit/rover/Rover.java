package com.infoshare.junit.rover;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Rover {

    private String orientation = "N";
    private int positionX = 0;
    private int positionY = 0;
    static String[] directions = {"N", "E", "S", "W"};

    public String execute(String commands) {

        char[] commandsArray = commands.toCharArray();

        for (char c: commandsArray){
            if(c=='M'){
               int[] newPosition = RoverMovement.move(positionX, positionY,orientation);
               positionX =newPosition[0];
               positionY = newPosition[1];
            }
            else {
                orientation = RoverMovement.turn(c,orientation);
            }
        }

//
//        }
        return positionX + ":" + positionY + ":" + orientation;

        //return commands.equals("RR")?"0:0:S":"0:0:E";
    }




}
