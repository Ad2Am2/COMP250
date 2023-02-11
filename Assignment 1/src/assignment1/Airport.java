package assignment1;

public class Airport {

    private int xCoordinate;
    private int yCoordinate;
    private int airportFees;

    public Airport(int xCoordinate, int yCoordinate, int airportFees) {

        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.airportFees = airportFees;

    }


    public int getFees() {
        return airportFees;
    }


    public static int getDistance(Airport airport1, Airport airport2) {

        if (airport1 == null || airport2 == null) throw new IllegalArgumentException("Cannot have null Airport");

        double distance = Math.sqrt(Math.pow((airport1.xCoordinate - airport2.xCoordinate),2) + Math.pow((airport1.yCoordinate - airport2.yCoordinate),2));
        return (int) Math.ceil(distance);

    }

}
