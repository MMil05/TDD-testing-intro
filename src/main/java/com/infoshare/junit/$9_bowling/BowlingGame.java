package com.infoshare.junit.$9_bowling;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    private List<Integer> rolls = new ArrayList<>();

    private boolean isSpare = false;
    private boolean isStrike = false;

    public void roll(int i) {
        rolls.add(i);
    }

    public Integer score() {
        int sum = 0;
        for (int i = 0; i < rolls.size(); i++) {
            sum += calcSumForRound(i);

            this.isSpare = checkSpare(i);
            this.isStrike = checkStrike(i);
        }
        return sum;
    }

    private int calcSumForRound(int rollIndex) {
        Integer currentRoll = getCurrentRoll(rollIndex);
        int bonus = 0;
        if (isStrike) {
            // ???
            // Problem: Strike has to be reset after two rolls
        } else if (isSpare) {
            bonus = currentRoll;
            isSpare = false;
        }
        return currentRoll + bonus;
    }

    private boolean checkSpare(int rollIndex) {
        boolean isLastRollInRound = rollIndex % 2 == 1;
        boolean isSpare = getPreviousRoll(rollIndex) + getCurrentRoll(rollIndex) == 10;

        return isSpare && isLastRollInRound;
    }

    private boolean checkStrike(int rollIndex) {
        boolean isFirstRollInRound = rollIndex % 2 == 0;
        boolean isStrike = getCurrentRoll(rollIndex) == 10;

         return isStrike && isFirstRollInRound;
    }

    private Integer getCurrentRoll(int rollIndex) {
        return rolls.get(rollIndex);
    }

    private Integer getPreviousRoll(int rollIndex) {
        return rollIndex > 0 ? rolls.get(rollIndex - 1) : 0;
    }
}
