package com.afs.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MarsRoverTest {
    @Test
    void should_x_0_y_1_heading_N_when_execute_given_x_0_y_0_heading_N_and_command_M() {
        MarsRover marsRover = new MarsRover(0, 0, "N");

        marsRover.executeCommands("M");

        assertEquals(0, marsRover.getLocationX());
        assertEquals(1, marsRover.getLocationY());
        assertEquals("N", marsRover.getHeading());
    }

    @Test
    void should_x_0_y_0_heading_N_when_execute_given_x_0_y_0_heading_N_and_command_M() {
        MarsRover marsRover = new MarsRover(0, 0, "N");

        marsRover.executeCommands("L");

        assertEquals(0, marsRover.getLocationX());
        assertEquals(0, marsRover.getLocationY());
        assertEquals("W", marsRover.getHeading());
    }
}
