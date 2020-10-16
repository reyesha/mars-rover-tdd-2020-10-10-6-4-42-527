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
    private HashMap<String,String> turnRightMap = new HashMap<>();
    private HashMap<String,String> turnLeftMap = new HashMap<>();


    public MarsRover(int locationX, int locationY, String heading) {
        this.locationX = locationX;
        this.locationY = locationY;
        this.heading = heading;

        turnRightMap.put("N", "E");
        turnRightMap.put("S", "W");
        turnRightMap.put("E", "S");
        turnRightMap.put("W", "N");

        turnLeftMap.put("N", "W");
        turnLeftMap.put("S", "E");
        turnLeftMap.put("E", "N");
        turnLeftMap.put("W", "S");
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



    private void turnRight() {
        heading = turnRightMap.get(heading);
    }

    private void turnLeft() {
        heading = turnLeftMap.get(heading);
    }

    private void move() {
        Map<String,Runnable> map = new HashMap<>();
        map.put(N, () -> locationY++);
        map.put(S, () -> locationY--);
        map.put(E, () -> locationX++);
        map.put(W, () -> locationX--);

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
