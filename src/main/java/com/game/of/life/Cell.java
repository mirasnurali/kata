package com.game.of.life;

public interface Cell {
    Cell nextGeneration(int numberOfNeighbors);
}
