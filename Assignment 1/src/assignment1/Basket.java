package assignment1;

public class Basket {

    private Reservation[] reservations;

    public Basket() {
        this.reservations = new Reservation[0];
    }

    public Reservation[] getProducts() {
        Reservation[] output = new Reservation[reservations.length];

        for (int i = 0; i < reservations.length; i++) {
            output[i] = reservations[i];
        }

        return output;
    }

    public int add(Reservation reservation) {

        Reservation[] newReservations = new Reservation[reservations.length + 1];

        for (int i = 0; i < reservations.length; i++) {
            newReservations[i] = reservations[i];
        }

        newReservations[reservations.length] = reservation;

        this.reservations = newReservations;

        return newReservations.length;
    }


    public boolean remove(Reservation reservation) {

        int index = -1;

        for (int i = 0; i < reservations.length; i++) {
            if (reservation.equals(reservations[i])) {
                index = i;
                break;
            }
        }

        if (index == -1) return false;

        Reservation[] newReservations = new Reservation[reservations.length - 1];

        for (int i = 0; i < reservations.length; i++) {
            if (i < index) {
                newReservations[i] = reservations[i];
            } else if (i >= index) {
                if (i != newReservations.length) {
                    newReservations[i] = reservations[i+1];
                }
            }

        }

        this.reservations = newReservations;

        return true;
    }

    public void clear() {
        reservations = new Reservation[0];
    }

    public int getNumOfReservations() {
        return reservations.length;
    }

    public int getTotalCost() {
        int cost = 0;

        for (int i = 0; i < reservations.length; i++) {
            cost += reservations[i].getCost();
        }

        return cost;
    }


    public static void main(String[] args) {
        Basket basket1 = new Basket();
        Airport airport1 = new Airport(44, 120, 100);
        Airport airport2 = new Airport(50, 112, 110);
        boolean status;

        FlightReservation reservation1 = new FlightReservation("Gon", airport1, airport2);
        FlightReservation reservation2 = new FlightReservation("Killua", airport1, airport2);

        basket1.add(reservation1);
        basket1.add(reservation2);
        basket1.add(reservation1);
        basket1.add(reservation1);
        // basket1 == {reservation1, reservation2, reservation1, reservation1, . . .}
        basket1.remove(reservation1);
        // basket1 == {reservation2, reservation1, reservation1, . . .} AND NOT {reservation2, . . .}

        status = (basket1.getProducts()[0].equals(reservation2) && basket1.getProducts()[1].equals(reservation1) && basket1.getProducts()[2].equals(reservation1));
    }

}