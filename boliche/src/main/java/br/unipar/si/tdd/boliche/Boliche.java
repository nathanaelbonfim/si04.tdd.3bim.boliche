package br.unipar.si.tdd.boliche;

import java.util.ArrayList;
import java.util.HashMap;

public class Boliche {
    static final int MAX_PINS = 10;
    static final int MAX_FRAMES = 10;
    static final int MAX_ROLLS = 2;

    ArrayList<Player> players = new ArrayList<Player>();
    String currentPlayer;

    int currentFrame = 1;
    int currentPinsStanding;
    int currentRoll = 1;

    boolean gameStarted = false;
    
    public void newPlayer(String string) {
        boolean gameHasStarted = gameStarted;
        boolean playerAlreadyExists = players.stream().anyMatch(player -> player.getName().equals(string));

        if (gameHasStarted)
            throw new RuntimeException("O jogo já começou"); 

        if (playerAlreadyExists)
            throw new RuntimeException("Jogador já existe");

        players.add(new Player(string));
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void startGame() {
        currentPlayer = players.get(0).getName();
        gameStarted = true;
    }

    public int getScore(String string) {
        return players.stream().filter(player -> player.getName().equals(string)).findFirst().get().getScore();
    }

    public boolean canPlay(String string) {
        if (!gameStarted)
            return false;

        return currentPlayer.equals(string);
    }

    public void roll(String player, int pinsKnockedDown) {
        if (!canPlay(player))
            throw new RuntimeException("Não é a vez do jogador");

        currentPinsStanding = calculatePinsStanding(pinsKnockedDown, currentRoll);

        players.stream().filter(p -> p.getName().equals(player)).findFirst().get().addScore(pinsKnockedDown, currentFrame, currentRoll);

        boolean isLastRollInFrame = currentRoll == MAX_ROLLS;
        boolean isStrike = pinsKnockedDown == MAX_PINS;

        if (isLastRollInFrame || isStrike) {
            currentRoll = 1;
            currentPlayer = getNextPlayer();
        } else {
            currentRoll++;

        }
    }

    private int calculatePinsStanding(int pinsKnockedDown, int currentRoll) {
        // Reseta os pinos para o máximo
        boolean isFirstRoll = currentRoll == 1;
        if (isFirstRoll) 
            currentPinsStanding = MAX_PINS;

        int newPinsStanding = currentPinsStanding - pinsKnockedDown;
        boolean isMoreThanMaxPins = newPinsStanding < 0;

        if (isMoreThanMaxPins)
            throw new RuntimeException("Não é possível derrubar mais pinos do que existem");

        return newPinsStanding;
    }

    private String getNextPlayer() {
        int currentPlayerIndex = players.indexOf(players.stream().filter(p -> p.getName().equals(currentPlayer)).findFirst().get());

        if (currentPlayerIndex == players.size() - 1) {
            currentFrame++;
            return players.get(0).getName();
        }

        return players.get(currentPlayerIndex + 1).getName();
    }
}
