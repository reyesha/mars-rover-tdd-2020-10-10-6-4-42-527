package com.afs.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MarsRoverTest {
    @Test
    void should_x_0_y_1_heading_N_when_execute_given_x_0_y_0_heading_N_and_command_M() throws CommandNotDefinedException {
        MarsRover marsRover = new MarsRover(0, 0, "N");

        marsRover.executeCommands("M");

        assertEquals(0, marsRover.getLocationX());
        assertEquals(1, marsRover.getLocationY());
        assertEquals("N", marsRover.getHeading());
    }

    @Test
    void should_x_0_y_0_heading_W_when_execute_given_x_0_y_0_heading_N_and_command_L() throws CommandNotDefinedException {
        MarsRover marsRover = new MarsRover(0, 0, "N");

        marsRover.executeCommands("L");

        assertEquals(0, marsRover.getLocationX());
        assertEquals(0, marsRover.getLocationY());
        assertEquals("W", marsRover.getHeading());
    }

    @Test
    void should_x_0_y_0_heading_E_when_execute_given_x_0_y_0_heading_N_and_command_R() throws CommandNotDefinedException {
        MarsRover marsRover = new MarsRover(0, 0, "N");

        marsRover.executeCommands("R");

        assertEquals(0, marsRover.getLocationX());
        assertEquals(0, marsRover.getLocationY());
        assertEquals("E", marsRover.getHeading());
    }

    @Test
    void should_x_0_y_negative1_heading_S_when_execute_given_x_0_y_0_heading_S_and_command_M() throws CommandNotDefinedException {
        MarsRover marsRover = new MarsRover(0, 0, "S");

        marsRover.executeCommands("M");

        assertEquals(0, marsRover.getLocationX());
        assertEquals(-1, marsRover.getLocationY());
        assertEquals("S", marsRover.getHeading());
    }

    @Test
    void should_x_0_y_0_heading_E_when_execute_given_x_0_y_0_heading_S_and_command_L() throws CommandNotDefinedException {
        MarsRover marsRover = new MarsRover(0, 0, "S");

        marsRover.executeCommands("L");

        assertEquals(0, marsRover.getLocationX());
        assertEquals(0, marsRover.getLocationY());
        assertEquals("E", marsRover.getHeading());
    }

    @Test
    void should_x_0_y_0_heading_W_when_execute_given_x_0_y_0_heading_S_and_command_R() throws CommandNotDefinedException {
        MarsRover marsRover = new MarsRover(0, 0, "S");

        marsRover.executeCommands("R");

        assertEquals(0, marsRover.getLocationX());
        assertEquals(0, marsRover.getLocationY());
        assertEquals("W", marsRover.getHeading());
    }

    @Test
    void should_x_1_y_0_heading_E_when_execute_given_x_0_y_0_heading_E_and_command_M() throws CommandNotDefinedException {
        MarsRover marsRover = new MarsRover(0, 0, "E");

        marsRover.executeCommands("M");

        assertEquals(1, marsRover.getLocationX());
        assertEquals(0, marsRover.getLocationY());
        assertEquals("E", marsRover.getHeading());
    }

    @Test
    void should_x_0_y_0_heading_N_when_execute_given_x_0_y_0_heading_E_and_command_L() throws CommandNotDefinedException {
        MarsRover marsRover = new MarsRover(0, 0, "E");

        marsRover.executeCommands("L");

        assertEquals(0, marsRover.getLocationX());
        assertEquals(0, marsRover.getLocationY());
        assertEquals("N", marsRover.getHeading());
    }

    @Test
    void should_x_0_y_0_heading_S_when_execute_given_x_0_y_0_heading_E_and_command_R() throws CommandNotDefinedException {
        MarsRover marsRover = new MarsRover(0, 0, "E");

        marsRover.executeCommands("R");

        assertEquals(0, marsRover.getLocationX());
        assertEquals(0, marsRover.getLocationY());
        assertEquals("S", marsRover.getHeading());
    }

    @Test
    void should_x_negative1_y_0_heading_W_when_execute_given_x_0_y_0_heading_W_and_command_M() throws CommandNotDefinedException {
        MarsRover marsRover = new MarsRover(0, 0, "W");

        marsRover.executeCommands("M");

        assertEquals(-1, marsRover.getLocationX());
        assertEquals(0, marsRover.getLocationY());
        assertEquals("W", marsRover.getHeading());
    }

    @Test
    void should_x_0_y_0_heading_S_when_execute_given_x_0_y_0_heading_W_and_command_L() throws CommandNotDefinedException {
        MarsRover marsRover = new MarsRover(0, 0, "W");

        marsRover.executeCommands("L");

        assertEquals(0, marsRover.getLocationX());
        assertEquals(0, marsRover.getLocationY());
        assertEquals("S", marsRover.getHeading());
    }

    @Test
    void should_x_0_y_0_heading_N_when_execute_given_x_0_y_0_heading_W_and_command_R() throws CommandNotDefinedException {
        MarsRover marsRover = new MarsRover(0, 0, "W");

        marsRover.executeCommands("R");

        assertEquals(0, marsRover.getLocationX());
        assertEquals(0, marsRover.getLocationY());
        assertEquals("N", marsRover.getHeading());
    }

    @Test
    void should_return_CommandNotDefinedException_when_execute_given_multiple_commands() throws CommandNotDefinedException {
        MarsRover marsRover = new MarsRover(0, 0, "W");
        assertThrows(CommandNotDefinedException.class, () -> marsRover.executeCommands("MMLRF"));
    }

    @Test
    void should_return_CommandNotDefinedException_when_execute_given_invalid_commands() throws CommandNotDefinedException {
        MarsRover marsRover = new MarsRover(0, 0, "W");
        assertThrows(CommandNotDefinedException.class, () -> marsRover.executeCommands("A"));
    }
}
