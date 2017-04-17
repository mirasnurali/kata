package com.game.of.life;

public class LivingCell implements Cell {
    @Override
    public Cell nextGeneration(int numberOfNeighbors) {
        return (numberOfNeighbors == 2 || numberOfNeighbors == 3)? this: new DeadCell();
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof LivingCell);
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
