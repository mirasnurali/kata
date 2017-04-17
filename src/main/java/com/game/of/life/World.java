package com.game.of.life;

import java.util.HashSet;
import java.util.Set;

public class World {

    private final Set<Location> grid;

    private World() {
        grid = new HashSet<>();
    }

    public static World emptyWorld() {
        return new World();
    }

    public void tick() {
        grid.forEach(location -> location.tick(numberOfNeighbors(location)));

    }

    private int numberOfNeighbors(Location location) {
        int counter = 0;
        for(Location neighbor: location.neighbors()) {
          if(grid.contains(neighbor)) {
              counter++;
          }
        }
        return counter;
    }

    public boolean isEmpty() {
        return grid.isEmpty();
    }

    public void setLivingCellAt(Location location) {
        location.addCell(new LivingCell());
        grid.add(location);
    }

    public boolean livingCellExistsAt(Location location) {
        return grid.contains(location);
    }
}
