package assignment2;

public class TargetQueue extends MyQueue<Position>{

    private MyStack<String> stack;

    public TargetQueue() {
        super();
        this.stack = new MyStack<String>();
    }

    public void clear() {
        stack.clear();
        super.clear();
    }

    public void addTargets(String string) {

        String num = "";

        if (string.charAt(string.length()-1) != ')' && string.charAt(string.length()-1) != '.') throw new IllegalArgumentException("Syntax error!");

        for (int i = 0; i<string.length(); i++) {

            if (string.charAt(i) == '(') {
                if (!(i==0)) if(string.charAt(i-1) != '.') throw new IllegalArgumentException("Syntax error!");
                if (stack.isEmpty() && num.isEmpty()) stack.push("(");
                else throw new IllegalArgumentException("Syntax error!");
            }

            else if (string.charAt(i)>='0' && string.charAt(i)<='9') {
                num += string.charAt(i);
            }

            else if (string.charAt(i) == ',') {
                // check if num is a valid int
                try {
                    int testNum = Integer.parseInt(num);
                }
                catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Syntax error!");
                }
                stack.push(num);
                stack.push(",");
                num = "";
            }

            else if (string.charAt(i) == ')') {
                //The stack should contain 3 elements with exactly the order a comma, an integer, and a left parenthesis from the top. If the order is not correct or any of the elements are missing, the input string has a syntax error.
                String pop1 = "", pop2 = "", pop3 = "";
                if (stack.getSize() == 3) {
                    pop1 = stack.pop();
                    pop2 = stack.pop();
                    pop3 = stack.pop();
                    if (!(pop1.equals(",") && pop3.equals("("))){
                        throw new IllegalArgumentException("Syntax error!");
                    }
                } else {
                    throw new IllegalArgumentException("Syntax error!");
                }
                //num should be an integer representing the y-coordinate. If num is empty, we must have reached the right parenthesis without finding a y-coordinate, which is a syntax error.
                if (!num.isEmpty()) {
                    // check if num is a valid int
                    try {
                        int testNum = Integer.parseInt(num);
                    }
                    catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Syntax error!");
                    }
                    Position newPosition = new Position(Integer.parseInt(pop2), Integer.parseInt(num));
                    num = "";
                    this.enqueue(newPosition);
                } else {
                    throw new IllegalArgumentException("Syntax error!");
                }
            }

            else if (string.charAt(i) == '.') {
                if (!(stack.isEmpty() && num.isEmpty())) {
                    throw new IllegalArgumentException("Syntax error!");
                }
                if (i != 0) if (string.charAt(i-1) != ')') throw new IllegalArgumentException("Syntax error!");
                if (i != string.length()-1) if (string.charAt(i+1) != '(') throw new IllegalArgumentException("Syntax error!");
            }

            else {
                throw new IllegalArgumentException("Syntax error: unexpected character");
            }

        }

    }

}
