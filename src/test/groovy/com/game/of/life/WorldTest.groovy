package com.game.of.life

import spock.lang.Specification


class WorldTest extends Specification {

    def 'empty world stays empty after tick'() {
        given:
        def world = World.emptyWorld()

        when:
        world.tick()

        then:
        world.isEmpty()
    }

    def 'empty world is not empty when living cell added'() {
        given:
        def world = World.emptyWorld()

        when:
        world.setLivingCellAt(Location.random())

        then:
        !world.isEmpty()
    }

    def "living cell stays alive when there are #numberOfNeighbors neighbors"() {
        given:
        def world = World.emptyWorld()
        def livingCellLocation = Location.atWithLivingCell(2, 2)
        world.setLivingCellAt(livingCellLocation)
        world.setLivingCellAt(Location.atWithLivingCell(1,2))
        world.setLivingCellAt(Location.atWithLivingCell(1,1))

        when:
        world.tick()

        then:
        world.livingCellExistsAt(livingCellLocation)

        where:
        numberOfNeighbors << [2,3]
    }

    def 'living cell dies when there are less than 2 neighbors'() {
        given:
        def world = World.emptyWorld()
        def livingCellLocation = Location.atWithLivingCell(2, 2)
        def neighborLocation = Location.atWithLivingCell(1, 2)
        world.setLivingCellAt(livingCellLocation)
        world.setLivingCellAt(neighborLocation)

        when:
        world.tick()

        then:
        !world.livingCellExistsAt(livingCellLocation)
    }

    def 'living cell dies when there are more than 3 neighbors'() {
        given:
        def world = World.emptyWorld()
        def livingCellLocation = Location.atWithLivingCell(2, 2)
        def neighbor1Location = Location.atWithLivingCell(1, 2)
        def neighbor2Location = Location.atWithLivingCell(3, 2)
        def neighbor3Location = Location.atWithLivingCell(3, 3)
        def neighbor4Location = Location.atWithLivingCell(3, 1)
        world.setLivingCellAt(livingCellLocation)
        world.setLivingCellAt(neighbor1Location)
        world.setLivingCellAt(neighbor2Location)
        world.setLivingCellAt(neighbor3Location)
        world.setLivingCellAt(neighbor4Location)

        when:
        world.tick()

        then:
        !world.livingCellExistsAt(livingCellLocation)
    }

    def 'dead cell comes to life when there are 3 neighbors'() {
        given:
        def world = World.emptyWorld()
        def deadCellLocation = Location.atWithDeadCell(2, 2)
        def neighbor1Location = Location.atWithLivingCell(1, 2)
        def neighbor2Location = Location.atWithLivingCell(3, 2)
        def neighbor3Location = Location.atWithLivingCell(3, 3)
        world.setLivingCellAt(deadCellLocation)
        world.setLivingCellAt(neighbor1Location)
        world.setLivingCellAt(neighbor2Location)
        world.setLivingCellAt(neighbor3Location)

        when:
        world.tick()

        then:
        world.livingCellExistsAt(deadCellLocation)
    }



}
