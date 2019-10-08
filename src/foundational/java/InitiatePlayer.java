package foundational.java;

import java.util.HashMap;

public class InitiatePlayer extends Player {

    private int score;

    @Override
    public Player computerPlayer(Player compPlayer) {
        String[] moves = {"rock", "paper", "scissors"};
        compPlayer.setName("Ex Machina");
        compPlayer.setMove(moves[getRandomInt(3)]);
        return compPlayer;
    }

    @Override
    public int getScore() {
        return this.score;
    }

    @Override
    public void setScore(int score) {
        this.score = score;
    }


    private int getRandomInt(int max) {
        return (int) Math.floor(Math.random() * Math.floor(max));
    }

}
