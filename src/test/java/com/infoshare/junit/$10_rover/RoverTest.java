package com.infoshare.junit.$10_rover;

import com.infoshare.junit.rover.Rover;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class RoverTest {

    private Rover rover;

    @Before
    public void createRover() {
        rover = new Rover();
    }

    @Test
    @Ignore
    public void should_turn_right_once() {
        Rover rover = new Rover();
        String position = rover.execute("R");
        assertThat(position).isEqualTo("0:0:E");
    }

    @Test
    @Ignore
    public void should_turn_right_twice() {
        Rover rover = new Rover();
        String position = rover.execute("R");
        assertThat(position).isEqualTo("0:0:E");
    }

    // tests above can be simplified using JUnitParams plugin

    @Test
    @Parameters({
            "R, 0:0:E",
            "RR, 0:0:S"
    })
    public void should_turn_right(String commands, String position) {

        String result = rover.execute(commands);
        assertThat(result).isEqualTo(position);
    }


    // obrót w lewo (1,2,3,4) razy
    @Test
    @Parameters({
            "L, 0:0:W",
            "LL, 0:0:S"
    })
    public void should_turn_left(String commands, String position) {

        String result = rover.execute(commands);
        assertThat(result).isEqualTo(position);
    }

    // naprzod  go forward
    @Test
    @Parameters({
            "M, 0:1:N",
            "MM, 0:2:N",
            "MMM, 0:3:N"
    })
    public void should_go_forward(String commands, String position) {

        String result = rover.execute(commands);
        assertThat(result).isEqualTo(position);
    }

    // naprzod i zmiana kierunku
    @Test
    @Parameters({
            "MR, 0:1:E",
            "ML, 0:1:W",
            "MML, 0:2:W",
            "MRM, 1:1:E"
    })
    public void should_go_forward_and_turn(String commands, String position) {

        String result = rover.execute(commands);
        assertThat(result).isEqualTo(position);
    }

    // przekroczenie granicy -> wyjśc z 2giej strony

    // napotkanie przeszkody
}
