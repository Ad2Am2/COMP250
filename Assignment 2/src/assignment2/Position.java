package assignment2;

public class Position {

    private int xCoordinate;
    private int yCoordinate;

    public Position(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public Position(Position position) {
        this.xCoordinate = position.xCoordinate;
        this.yCoordinate = position.yCoordinate;
    }

    public void reset(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public void reset(Position position) {
        this.xCoordinate = position.xCoordinate;
        this.yCoordinate = position.yCoordinate;
    }

    public static int getDistance(Position p1, Position p2) {
        return (Math.abs(p1.xCoordinate- p2.xCoordinate) + Math.abs(p1.yCoordinate- p2.yCoordinate));
    }

    public int getX() {
        return xCoordinate;
    }

    public int getY() {
        return yCoordinate;
    }

    public void moveWest() {
        xCoordinate -= 1;
    }

    public void moveEast() {
        xCoordinate += 1;
    }

    public void moveNorth() {
        yCoordinate -= 1;
    }

    public void moveSouth() {
        yCoordinate += 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return xCoordinate == position.xCoordinate && yCoordinate == position.yCoordinate;
    }


}
