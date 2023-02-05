package assignment1;

public class BnBReservation extends HotelReservation {

    public BnBReservation(String name, Hotel hotel, String roomType, int numNights) {
        super(name, hotel, roomType, numNights);
    }

    public int getCost() {
        return super.getCost()+10;
    }

}