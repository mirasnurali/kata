package com.game.of.life;

public class DeadCell implements Cell {
    @Override
    public Cell nextGeneration(int numberOfNeighbors) {
        return numberOfNeighbors == 3?new LivingCell():this;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof DeadCell);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
