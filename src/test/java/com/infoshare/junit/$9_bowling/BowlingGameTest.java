package com.infoshare.junit.$9_bowling;


import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BowlingGameTest {

    private BowlingGame bowlingGame;

    @Before
    public void CreateGame() {
        bowlingGame = new BowlingGame();
    }


    @Test
    public void isZeroGame() {
        int rollCount = 20;

        rollSequence(rollCount, 0);
        assertThat(bowlingGame.score()).isEqualTo(0);
    }


    @Test
    public void isPoorGame() {
        int rollCount = 20;

        rollSequence(rollCount, 1);
        assertThat(bowlingGame.score()).isEqualTo(20);
    }


    @Test
    public void isSingleSpareGame() {

        bowlingGame.roll(0);
        bowlingGame.roll(10);  // round 1: spare
        bowlingGame.roll(1);
        bowlingGame.roll(0);  // round 2
        rollSequence(16, 0);
        assertThat(bowlingGame.score()).isEqualTo(12);
    }

    @Test
    public void isSingleSpareInTwoRollsGame() {

        bowlingGame.roll(5);
        bowlingGame.roll(5);  // round 1: spare
        bowlingGame.roll(1);
        bowlingGame.roll(0);  // round 2
        rollSequence(16, 0);
        assertThat(bowlingGame.score()).isEqualTo(12);
    }

    @Test
    public void isDoubleSpareWithNoBonus() {

        bowlingGame.roll(3);
        bowlingGame.roll(7);  // round 1: spare
        bowlingGame.roll(0);
        bowlingGame.roll(10);  // round 2
        rollSequence(16, 0);
        assertThat(bowlingGame.score()).isEqualTo(20);
    }

    @Test
    public void isDoubleSpareWithSingleBonus() {

        bowlingGame.roll(3);
        bowlingGame.roll(7);  // round 1: spare
        bowlingGame.roll(0);
        bowlingGame.roll(10);  // round 2
        bowlingGame.roll(1);
        bowlingGame.roll(0);  // round 3
        rollSequence(14, 0);
        assertThat(bowlingGame.score()).isEqualTo(22);
    }

    @Test
    public void singleStrike() {

        bowlingGame.roll(10); // round 1: spare
        bowlingGame.roll(1);
        bowlingGame.roll(1); // round 2

        rollSequence(16, 0);
        assertThat(bowlingGame.score()).isEqualTo(14);
    }


/*    @Test
    public void isBestGame() {

        rollSequence(12, 10);
        assertThat(bowlingGame.score()).isEqualTo(300);
    }  */

    private void rollSequence(int rollCount, int hitCounter) {
        for (int i = 0; i < rollCount; i++) {
            bowlingGame.roll(hitCounter);
        }
    }



}
