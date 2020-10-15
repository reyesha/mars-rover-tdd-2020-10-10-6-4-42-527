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
        }else if (command.equals("R")){
            turnRight();
        }
    }

    private void turnRight() {
        if (heading.equals("N")) {
            heading = "E";
        }else if (heading.equals("S")) {
            heading = "W";
        }else if (heading.equals("E")) {
            heading = "S";
        }
    }

    private void turnLeft() {
        if (heading.equals("N")) {
            heading = "W";
        }else if (heading.equals("S")) {
            heading = "E";
        }else if (heading.equals("E")) {
            heading = "N";
        }
    }

    private void move() {
        if (heading.equals("N")) {
            locationY += 1;
        }else if (heading.equals("S")) {
            locationY -= 1;
        }else if (heading.equals("E")) {
            locationX += 1;
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
