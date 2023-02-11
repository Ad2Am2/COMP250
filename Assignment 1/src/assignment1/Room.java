package assignment1;

public class Room {

    private String type;
    private int price;
    private boolean available;

    public Room(String type) {

        if (type.toLowerCase().equals("double")){

            this.type = type.toLowerCase();
            this.price = 90*100;
            this.available = true;


        } else if (type.toLowerCase().equals("queen")) {

            this.type = type.toLowerCase();
            this.price = 110*100;
            this.available = true;

        } else if (type.toLowerCase().equals("king")) {

            this.type = type.toLowerCase();
            this.price = 150*100;
            this.available = true;

        } else {
            throw new IllegalArgumentException("The type of the room must either \"double\", \"queen\", or \"king\". ");
        }

    }

    public Room(Room room) {

        if (room == null) throw new IllegalArgumentException("Room to copy cannot be null");

        this.type = room.type.toLowerCase();
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

        if (rooms == null || type == null) return null;

        for (int i = 0; i < rooms.length; i++) {
            if (!(rooms[i] == null)) {
                if (rooms[i].available && rooms[i].type.toLowerCase().equals(type.toLowerCase())) {
                    return rooms[i];
                }
            }
        }
        return null;
    }

    public static boolean makeRoomAvailable(Room[] rooms, String type) {

        for (int i = 0; i < rooms.length; i++) {
            if (!(rooms[i] == null)) {
                if (rooms[i].available == false) {
                    rooms[i].available = true;
                    return true;
                }
            }
        }
        return false;
    }

}
