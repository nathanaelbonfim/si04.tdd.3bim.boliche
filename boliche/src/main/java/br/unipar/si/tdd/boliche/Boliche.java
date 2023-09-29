package br.unipar.si.tdd.boliche;

import java.util.ArrayList;

public class Boliche {
    ArrayList<String> players = new ArrayList<String>();
    boolean gameStarted = false;
    
    public void newPlayer(String string) {
        players.add(string);
    }

    public ArrayList<String> getPlayers() {
        return players;
    }

    public void setPinsKnockedDown(int i) {
    }

    public void startGame() {
    }
}
