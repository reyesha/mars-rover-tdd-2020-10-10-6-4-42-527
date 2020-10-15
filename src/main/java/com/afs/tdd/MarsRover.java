package com.afs.tdd;

public class MarsRover {

    private int locationX;
    private int locationY;
    private String heading;

    public MarsRover(int locationX, int locationY, String heading) {
        this.locationX = locationX;
        this.locationY = locationY;
        this.heading = heading;
    }

    public void executeCommands(String command) {
        if (command.equals("M")){
            move();
        }else if (command.equals("L")){
            turnLeft();
        }
    }

    private void turnLeft() {
        if (heading.equals("N")) {
            heading = "W";
        }
    }

    private void move() {
        if (heading.equals("N")) {
            locationY += 1;
        }
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
