package assignment2;

public class ActionQueue extends MyQueue<Direction> {

    private int i;
    private MyStack<Integer> stack;

    public ActionQueue() {
        super();
        this.i = 0;
        stack = new MyStack();
    }

    public void clear() {
        super.clear();
        // TODO clear any field that I may add
    }

    public void loadFromEncodedString(String string) {

        String decodedString = decodeToString(string);
        for (int i = 0; i<decodedString.length(); i++){
            switch (decodedString.charAt(i)) {
                case 'N':
                    enqueue(Direction.NORTH);
                    break;
                case 'E':
                    enqueue(Direction.EAST);
                    break;
                case 'S':
                    enqueue(Direction.SOUTH);
                    break;
                case 'W':
                    enqueue(Direction.WEST);
                    break;
            }
        }
    }

    private String decodeToString(String string) {
        String decoded = "";
        String num = "";

        if (!(string.charAt(0) == 'N' || string.charAt(0) == 'E' || string.charAt(0) == 'S' || string.charAt(0) == 'W' || ('0' <= string.charAt(0) && string.charAt(0) <= '9'))) throw new IllegalArgumentException("Syntax error!");

        while (this.i < string.length()) {
            if ('0' <= string.charAt(i) && string.charAt(i) <= '9') {
                num += string.charAt(i);
            } else if (string.charAt(i) == '[') {
                if (!('0' <= string.charAt(i-1) && string.charAt(i-1) <= '9')) throw new IllegalArgumentException("Syntax error!");
                stack.push(Integer.parseInt(num));
                num = "";
                i++;
                decoded += decodeToString(string);
            } else if (string.charAt(i) == ']') {
                int popped = 0;
                try {
                    popped = stack.pop();
                } catch(Exception e) {
                    throw new IllegalArgumentException("Syntax error!");
                }
                if (decoded.isEmpty()) throw new IllegalArgumentException("Syntax error!");
                return decoded.repeat(popped);
            } else if (string.charAt(i) == 'N' || string.charAt(i) == 'E' || string.charAt(i) == 'S' || string.charAt(i) == 'W') {
                decoded += string.charAt(i);
            } else {
                throw new IllegalArgumentException("Syntax error: encountered unexpected character!");
            }
            i++;
        }
        return decoded;
    }

    public static void main(String[] args) {
        String test = "3[2[N]2[E]]1[S]";
        ActionQueue actionQueue= new ActionQueue();
        System.out.println(actionQueue.decodeToString(test));
    }

}
