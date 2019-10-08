package foundational.java;

import jdk.internal.util.xml.impl.Pair;

import java.util.HashMap;


public abstract class Player {

    private String name;
    private String move;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMove() {
        return move;
    }

    public void setMove(String move) {
        this.move = move;
    }

    public abstract Player computerPlayer (Player player);
    public abstract int getScore();
    public abstract void setScore(int score);

}
