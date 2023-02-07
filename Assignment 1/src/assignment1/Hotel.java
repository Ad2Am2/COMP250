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

        //TODO this or IllegalArgumentException?
        if (type == null || !(type.equals("double") || type.equals("queen") || type.equals("king"))) {
            return false;
        }
        
        return Room.makeRoomAvailable(rooms, type);
    }


}
