package com.afs.tdd;

import java.util.HashMap;
import java.util.Map;

public class MarsRover {

    private int locationX;
    private int locationY;
    private String heading;

    public MarsRover(int locationX, int locationY, String heading) {
        this.locationX = locationX;
        this.locationY = locationY;
        this.heading = heading;
    }

    public void executeCommands(String command) throws CommandNotDefinedException {
        if (command.equals("M")){
            move();
        }else if (command.equals("L")){
            turnLeft();
        }else if (command.equals("R")){
            turnRight();
        }else {
            throw new CommandNotDefinedException("CommandNotDefinedException");
        }
    }
    public enum HeadingDirection {N, S, E, W};

    private void turnRight() {
        Map<String,Runnable> map = new HashMap<>();
        map.put(HeadingDirection.N.toString(),() -> heading = "E");
        map.put(HeadingDirection.S.toString(),() -> heading = "W");
        map.put(HeadingDirection.E.toString(),() -> heading = "S");
        map.put(HeadingDirection.W.toString(),() -> heading = "N");

        map.get(heading).run();
    }

    private void turnLeft() {
        Map<String,Runnable> map = new HashMap<>();
        map.put(HeadingDirection.N.toString(),() -> heading = "W");
        map.put(HeadingDirection.S.toString(),() -> heading = "E");
        map.put(HeadingDirection.E.toString(),() -> heading = "N");
        map.put(HeadingDirection.W.toString(),() -> heading = "S");

        map.get(heading).run();
    }

    private void move() {
        Map<String,Runnable> map = new HashMap<>();
        map.put(HeadingDirection.N.toString(),() -> locationY++);
        map.put(HeadingDirection.S.toString(),() -> locationY--);
        map.put(HeadingDirection.E.toString(),() -> locationX++);
        map.put(HeadingDirection.W.toString(),() -> locationX--);

        map.get(heading).run();
    }

    public int getLocationX() {
        return locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public String getHeading() {
        return heading;
    }
}
