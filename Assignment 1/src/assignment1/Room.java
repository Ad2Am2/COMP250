package assignment1;

public class Room {

    private String type;
    private int price;
    private boolean available;

    public Room(String type) {

        if (type.equals("double")){

            this.type = type;
            this.price = 90*100;
            this.available = true;


        } else if (type.equals("queen")) {

            this.type = type;
            this.price = 110*100;
            this.available = true;

        } else if (type.equals("king")) {

            this.type = type;
            this.price = 150*100;
            this.available = true;

        } else {
            throw new IllegalArgumentException("The type of the room must either \"double\", \"queen\", or \"king\". ");
        }

    }

    public Room(Room room) {

        this.type = room.type;
        this.price = room.price;
        this.available = room.available;

    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public void changeAvailability() {
        available = !available;
    }

    public static Room findAvailableRoom(Room[] rooms, String type) {

        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].available && rooms[i].type.equals(type)) {
                return rooms[i];
            }
        }
        return null;
    }

    public static boolean makeRoomAvailable(Room[] rooms, String type) {

        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].available == false) {
                rooms[i].available = true;
                return true;
            }
        }
        return false;
    }

}
