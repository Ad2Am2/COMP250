package assignment1;

public class FlightReservation extends Reservation{

    private Airport departureAirport;
    private Airport arrivalAirport;

    public FlightReservation(String name, Airport departureAirport, Airport arrivalAirport) {

        super(name);

        if (departureAirport.equals(arrivalAirport)) throw new IllegalArgumentException("The departure and arrival airports must not be the same!");

        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;

    }

    public int getCost() {

        int distance = Airport.getDistance(departureAirport, arrivalAirport);
        int pricePerGallon = 124;
        double kilometersPerGallon = 167.52;

        double pricePerKilometer = pricePerGallon/kilometersPerGallon;

        int price = (int) Math.ceil(distance*pricePerKilometer);
        price += departureAirport.getFees() + arrivalAirport.getFees();
        price += 5375;

        return price;

    }


    @Override
    public boolean equals(Object object) {
        if (!object.getClass().equals(this.getClass())) {
            return false;
        }

        FlightReservation o = (FlightReservation) object;

        if (o.departureAirport.equals(this.departureAirport) && o.arrivalAirport.equals(this.arrivalAirport) && o.reservationName().equals(this.reservationName())) {
            return true;
        }

        return false;

    }
}
