package assignment1;

public class Hotel {

    private String name;
    private Room[] rooms;

    public Hotel(String name, Room[] rooms) {

        if (name == null || rooms == null) throw new IllegalArgumentException("Arguments cannot be null");

        this.name = name;
        this.rooms = new Room[rooms.length];

        for (int i=0; i < rooms.length;  i++) {
            this.rooms[i] = new Room(rooms[i]);
        }

    }

    public int reserveRoom(String type) {

        if (type.toLowerCase().equals("double")){

            Room r = Room.findAvailableRoom(rooms, "double");
            if (r != null) {
                r.changeAvailability();
                return r.getPrice();
            } else {
                throw new IllegalArgumentException("There is no available room of type double!");
            }

        } else if (type.toLowerCase().equals("queen")) {

            Room r = Room.findAvailableRoom(rooms, "queen");
            if (r != null) {
                r.changeAvailability();
                return r.getPrice();
            } else {
                throw new IllegalArgumentException("There is no available room of type queen!");
            }

        } else if (type.toLowerCase().equals("king")) {

            Room r = Room.findAvailableRoom(rooms, "king");
            if (r != null) {
                r.changeAvailability();
                return r.getPrice();
            } else {
                throw new IllegalArgumentException("There is no available room of type king!");
            }

        } else {
            throw new IllegalArgumentException("The type of the room to reserve must either \"double\", \"queen\", or \"king\" (case insensitive).");
        }

    }


    public boolean cancelRoom(String type) {

        //TODO this or IllegalArgumentException?
        if (type == null || !(type.toLowerCase().equals("double") || type.toLowerCase().equals("queen") || type.toLowerCase().equals("king"))) {
            return false;
        }
        
        return Room.makeRoomAvailable(rooms, type);
    }


}
