package assignment1;

public class HotelReservation extends Reservation{

    private Hotel hotel;
    private String roomType;
    private int numNights;
    private int roomPricePerNight;


    public HotelReservation(String name, Hotel hotel, String roomType, int numNights) {

        super(name);

        this.hotel = hotel;
        this.roomType = roomType;
        this.numNights = numNights;

        //TODO super inefficient and disgusting code
        Room room = new Room(roomType);
        this.roomPricePerNight = room.getPrice();

        hotel.reserveRoom(roomType);
    }

    public int getNumOfNights() {
        return numNights;
    }

    @Override
    public int getCost() {
        return roomPricePerNight*numNights;
    }

    public boolean equals(Object object) {

        if (!object.getClass().toString().equals("HotelReservation")) return false;

        HotelReservation hotelReservation = (HotelReservation) object;

        if (hotelReservation.reservationName().equals(this.reservationName()) && hotelReservation.hotel.equals(this.hotel) && hotelReservation.roomType.equals(this.roomType) && hotelReservation.numNights == this.numNights && hotelReservation.roomPricePerNight == this.roomPricePerNight) return true;
        else return false;

    }
}