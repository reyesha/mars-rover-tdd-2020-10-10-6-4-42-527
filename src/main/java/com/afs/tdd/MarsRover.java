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

    private void turnRight() {
        if (heading.equals("N")) {
            heading = "E";
        }else if (heading.equals("S")) {
            heading = "W";
        }else if (heading.equals("E")) {
            heading = "S";
        }else if (heading.equals("W")) {
            heading = "N";
        }
    }

    private void turnLeft() {
        if (heading.equals("N")) {
            heading = "W";
        }else if (heading.equals("S")) {
            heading = "E";
        }else if (heading.equals("E")) {
            heading = "N";
        }else if (heading.equals("W")) {
            heading = "S";
        }
    }

    private void move() throws CommandNotDefinedException {
        if (heading.equals("N")) {
            locationY += 1;
        }else if (heading.equals("S")) {
            locationY -= 1;
        }else if (heading.equals("E")) {
            locationX += 1;
        }else if (heading.equals("W")) {
            locationX -= 1;
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
