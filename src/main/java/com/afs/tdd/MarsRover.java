package com.afs.tdd;

import java.util.HashMap;
import java.util.Map;

public class MarsRover {

    public static final String E = "E";
    public static final String W = "W";
    public static final String S = "S";
    public static final String N = "N";
    private int locationX;
    private int locationY;
    private String heading;

    public MarsRover(int locationX, int locationY, String heading) {
        this.locationX = locationX;
        this.locationY = locationY;
        this.heading = heading;
    }

    public enum Commandments {M, L, R}

    public void executeCommands(String command) throws CommandNotDefinedException {
        Map<String,Runnable> map = new HashMap<>();
        map.put(Commandments.M.toString(), this::move);
        map.put(Commandments.L.toString(), this::turnLeft);
        map.put(Commandments.R.toString(), this::turnRight);

        try {
            map.get(command).run();
        } catch (NullPointerException e) {
            throw new CommandNotDefinedException("CommandNotDefinedException");
        }
    }

    public enum HeadingDirection {N, S, E, W}

    private void turn(String direction1, String direction2, String direction3, String direction4) {
        Map<String,Runnable> map = new HashMap<>();
        map.put(HeadingDirection.N.toString(),() -> heading = direction1);
        map.put(HeadingDirection.S.toString(),() -> heading = direction2);
        map.put(HeadingDirection.E.toString(),() -> heading = direction3);
        map.put(HeadingDirection.W.toString(),() -> heading = direction4);

        map.get(heading).run();
    }

    private void turnRight() {
        turn(E, W, S, N);
    }

    private void turnLeft() {
        turn(W, E, N, S);
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
