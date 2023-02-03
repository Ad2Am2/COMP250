public class Week2 {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    // Primitive Data Types and Strings


    private static char charRightShift(char c, int n) {
        return (char) (c+n);
    }

    private static boolean passwordChecker(String password) {
        if (password.equals("password")) return true;
        return false;
    }

    private static boolean indexIsVowel(String s, int i) {
        if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u') return true;
        return false;
    }

    private static boolean isUpperCase(char c) {
        if ('A' <= c && c <= 'Z') return true;
        return false;
    }

    private static int countUpper(String input) {
        int output = 0;

        for (int i; i < input.length(); i++) {
            if('A' <= input.charAt(i) && input.charAt(i) <= 'Z') output ++;
        }
        return output;
    }



    // Arrays

    private static int largestValue(int[] array) {
        int highest = array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i] > highest) highest = array[i];
        }
        return highest;
    }

    ç



}