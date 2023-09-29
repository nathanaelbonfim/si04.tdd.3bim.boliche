package br.unipar.si.tdd.boliche;

public class Player {
    private String name;
    private int score;

    private int currentFramePoints;

    private boolean hasStrike = false;
    private boolean hasSpare = false;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    void addScore(int pinsKnockedDown, int frame, int roll) {
        score += computeScore(pinsKnockedDown, roll);

        boolean isStrike = pinsKnockedDown == Boliche.MAX_PINS;
        boolean isSpare = currentFramePoints + pinsKnockedDown == Boliche.MAX_PINS;

        if (isStrike)
            hasStrike = true;

        if (isSpare)
            hasSpare = true;

        boolean isLastRollInFrame = roll == Boliche.MAX_ROLLS;
        if (isLastRollInFrame) {
            currentFramePoints = 0;
            return;
        }

        currentFramePoints += pinsKnockedDown;
    }

    private int computeScore(int pinsKnockedDown, int currentRoll) {
        boolean applyStrikeBonus = hasStrike && currentRoll <= 2;
        if (applyStrikeBonus) {
            return pinsKnockedDown * 2;
        }

        boolean removeStrikeBonus = currentRoll == 2 || pinsKnockedDown == Boliche.MAX_PINS;
        if (removeStrikeBonus) {
            hasStrike = false;
        }

        boolean applySpareBonus = hasSpare && currentRoll == 1;

        if (applySpareBonus) {
            hasSpare = false;
            return pinsKnockedDown * 2;
        }

        return pinsKnockedDown;
    }
}
