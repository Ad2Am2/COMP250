package assignment2;

public class Region {

    private int minX;
    private int minY;
    private int maxX;
    private int maxY;


    public Region(int minX, int minY, int maxX, int maxY) {
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public boolean contains (Position position){
        if (minX <= position.getX() && position.getX() <= maxX && minY <= position.getY() && position.getY() <= maxY) return true;
        else return false;
    }

}
