package com.game.of.life;

import java.util.*;

public class Location {

    private final int x;
    private final int y;
    private Cell cell;

    private Location(int x, int y, Cell cell) {
        this.x = x;
        this.y = y;
        this.cell = cell;
    }

    public static Location random() {
        Random random = new Random();
        return new Location(random.nextInt(), random.nextInt(), new DeadCell());
    }

    public static Location atWithLivingCell(int x, int y) {
        return new Location(x, y, new LivingCell());
    }

    public static Location atWithDeadCell(int x, int y) {
        return new Location(x,y, new DeadCell());
    }

    void addCell(Cell cell) {
        this.cell = cell;
    }

    void tick(int numberOfNeighbors) {
        cell = cell.nextGeneration(numberOfNeighbors);
    }

    Set<Location> neighbors() {
        Set<Location> neighbors = new HashSet<>();
        Cell livingCell = new LivingCell();
        Location neighbor1 = new Location(x-1,y, livingCell);
        Location neighbor2 = new Location(x-1,y+1, livingCell);
        Location neighbor3 = new Location(x,y-1, livingCell);
        Location neighbor4 = new Location(x+1,y-1, livingCell);
        Location neighbor5 = new Location(x-1,y-1, livingCell);
        Location neighbor6 = new Location(x+1,y, livingCell);
        Location neighbor7 = new Location(x,y+1, livingCell);
        Location neighbor8 = new Location(x+1,y+1, livingCell);
        neighbors.addAll(Arrays.asList(neighbor1, neighbor2, neighbor3,
                neighbor4, neighbor5, neighbor6, neighbor7, neighbor8));
        return neighbors;
    }

    @Override
    public boolean equals(Object obj) {
        Location other = (Location) obj;
        return Objects.equals(x, other.x) &&
                Objects.equals(y, other.y) &&
                  Objects.equals(cell, other.cell);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x,y,cell);
    }
}
