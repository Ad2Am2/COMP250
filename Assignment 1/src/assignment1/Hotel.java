package assignment1;

public class Hotel {

    private String name;
    private Room[] rooms;

    public Hotel(String name, Room[] rooms) {

        this.name = name;
        this.rooms = new Room[rooms.length];

        for (int i=0; i < rooms.length;  i++) {
            this.rooms[i] = new Room(rooms[i]);
        }

    }

    public int reserveRoom(String type) {

        if (type.equals("double")){

            Room r = Room.findAvailableRoom(rooms, "double");
            if (r != null) {
                r.changeAvailability();
                return r.getPrice();
            } else {
                throw new IllegalArgumentException("There is no available room of type double!");
            }

        } else if (type.equals("queen")) {

            Room r = Room.findAvailableRoom(rooms, "queen");
            if (r != null) {
                r.changeAvailability();
                return r.getPrice();
            } else {
                throw new IllegalArgumentException("There is no available room of type queen!");
            }

        } else if (type.equals("king")) {

            Room r = Room.findAvailableRoom(rooms, "king");
            if (r != null) {
                r.changeAvailability();
                return r.getPrice();
            } else {
                throw new IllegalArgumentException("There is no available room of type king!");
            }

        } else {
            throw new IllegalArgumentException("The type of the room to reserve must either \"double\", \"queen\", or \"king\". ");
        }

    }


    public boolean cancelRoom(String type) {


        if (!(type.equals("double") || type.equals("queen") || type.equals("king"))) {
            return false;
        }

        for (int i = 0; i < rooms.length; i++) {
//            if (!(rooms[i].available) && rooms[i].getType().equals(type)) {
//                rooms[i].changeAvailability();
//                return true;
//
//            }

            //TODO: this is bullshit


            if (!(rooms[i].equals(new Room(type)))) {
                rooms[i].changeAvailability();
                return true;
            }


        }

        return false;
    }


}
