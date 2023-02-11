package assignment1;

public class Customer {

    private String name;
    private int balance;
    private Basket basket;

    public Customer(String name, int initialBalance) {

        if (name == null) throw new IllegalArgumentException("Customer cannot have a null name.");

        this.name = name;
        this.balance = initialBalance;
        this.basket = new Basket();

    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public Basket getBasket() {
        return basket;
    }

    public int addFunds(int amount) {

        if (amount < 0) throw new IllegalArgumentException("Cannot add negative funds!");

        balance += amount;

        return balance;
    }

    public int addToBasket(Reservation reservation) {

        if (reservation == null) throw new IllegalArgumentException("Reservation cannot be null.");

        if(!reservation.reservationName().equals(name)) throw new IllegalArgumentException("The name on the reservation doesn't match!");

        basket.add(reservation);

        return basket.getNumOfReservations();
    }

    public int addToBasket(Hotel hotel, String roomType, int numNights, boolean breakfast){

        if (hotel == null || roomType == null) throw new IllegalArgumentException("Arguments cannot be null!");

        roomType = roomType.toLowerCase();

        if (breakfast) {
            BnBReservation reservation = new BnBReservation(name, hotel, roomType, numNights);
            basket.add(reservation);
        } else {
            HotelReservation reservation = new HotelReservation(name, hotel, roomType, numNights);
            basket.add(reservation);
        }

        //TODO why does it throw a compile error to add the reservation to the basket outside the if else statement? It's initialized in both instances of the if else

        return basket.getNumOfReservations();
    }

    public int addToBasket(Airport departureAirport, Airport arrivalAirport) {

        if(departureAirport == null || arrivalAirport == null) throw new IllegalArgumentException("Arguments cannot be null!");

        FlightReservation reservation = new FlightReservation(name, departureAirport, arrivalAirport);

        basket.add(reservation);

        return basket.getNumOfReservations();
    }

    public boolean removeFromBasket(Reservation reservation) {

        boolean successful = basket.remove(reservation);

        return successful;
    }

    public int checkOut() {

        if (balance < basket.getTotalCost()) {
            throw new IllegalArgumentException("Not enough funds to check out!");
        } else {
            balance -= basket.getTotalCost();
            basket.clear();
        }

        return balance;
    }

}
