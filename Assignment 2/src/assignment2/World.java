package assignment2;

public class World {

    private Caterpillar caterpillar;
    private Position foodPosition;
    private Region map;
    private ActionQueue actions;
    private TargetQueue foodPositions;
    private GameState state;

    public World(TargetQueue foodPositions, ActionQueue actions) {
        // TODO can actions be empty?
        if (foodPositions == null || foodPositions.isEmpty() || actions == null /* || actions.isEmpty() */){
            throw new IllegalArgumentException("Arguments are empty!");
        }

        this.caterpillar = new Caterpillar();
        this.map = new Region( 0, 0, 15, 15);
        this.actions = actions;
        this.foodPositions = foodPositions;
        this.foodPosition = foodPositions.dequeue();
        this.state = GameState.MOVE;
    }

    public void step() {
        Direction nextDirection;
        if (actions.isEmpty()) {state = GameState.NO_MORE_ACTION; return;} // return to remove compile-time error where nextDirection may not be initialized. Would be returned anyways from the very next if statement because state here is made to not be MOVE or EAT
        else nextDirection = actions.dequeue();

        if (state != GameState.MOVE && state != GameState.EAT) return;

        Position newPosition = null;
        switch (nextDirection) {
            case NORTH:
                newPosition = new Position(caterpillar.getHead());
                newPosition.moveNorth();
                break;

            case EAST:
                newPosition = new Position(caterpillar.getHead());
                newPosition.moveEast();
                break;

            case SOUTH:
                newPosition = new Position(caterpillar.getHead());
                newPosition.moveSouth();
                break;

            case WEST:
                newPosition = new Position(caterpillar.getHead());
                newPosition.moveWest();
                break;
        }

        if (!map.contains(newPosition)) state = GameState.WALL_COLLISION;

        Caterpillar deepCopyCaterpillar = new Caterpillar();
        deepCopyCaterpillar.clear();
        for (Position p : caterpillar) {
            deepCopyCaterpillar.addLast(p);
        }
//        deepCopyCaterpillar.removeFirst();

        if (deepCopyCaterpillar.selfCollision(newPosition)) state = GameState.SELF_COLLISION;

        if (newPosition.getX() == foodPosition.getX() && newPosition.getY() == foodPosition.getY()) {
            caterpillar.eat(foodPosition);
            if (foodPositions.isEmpty()) state = GameState.DONE;
            else {
                foodPosition = foodPositions.dequeue();
                state = GameState.EAT;
            }
        } else {
            if (state != GameState.MOVE && state != GameState.EAT) return;
            caterpillar.move(newPosition);
            state = GameState.MOVE;
        }

    }

    public GameState getState() {
        return state;
    }

    public Caterpillar getCaterpillar() {
        return caterpillar;
    }

    public Position getFood() {
        return foodPosition;
    }

    public boolean isRunning(){
        if (state != GameState.MOVE && state != GameState.EAT) return false;
        else return true;
    }

}
