package assignment2;

public class Caterpillar extends MyDoublyLinkedList<Position> {

    public Caterpillar() {
        super();
        Position initialPosition = new Position(7,7);
        size = 0;
        addFirst(initialPosition);
    }

    public Position getHead() {
        return peekFirst();
    }

    public void eat(Position position) {
        // ^ means XOR: it is not adjacent if it is diagonal, so it must be exclusive
        if (!(getHead().getX() == position.getX()+1 ^ getHead().getX() == position.getX()-1 ^ getHead().getY() == position.getY()+1 ^ getHead().getY() == position.getY()-1)) throw new IllegalArgumentException("Position is not adjacent to the head!");
        else addFirst(position);
    }

    public void move(Position position) {
        // ^ means XOR: it is not adjacent if it is diagonal, so it must be exclusive
        if (!(getHead().getX() == position.getX()+1 ^ getHead().getX() == position.getX()-1 ^ getHead().getY() == position.getY()+1 ^ getHead().getY() == position.getY()-1)) throw new IllegalArgumentException("Position is not adjacent to the head!");
        else{
            addFirst(position);
            removeLast();
        }
    }

    public boolean selfCollision(Position position) {
        for (Position p : this) {
            if (p.getX() == position.getX() && p.getY() == position.getY()) return true;
        }
        return false;
    }

}
