package Basics;

public class Exercises
{
    public static void main(String[] args)
    {
        //Let's test your code!

        //You complete the methods below, and then run this program to test them!


        System.out.println("Testing!!!!!!");
        int result1 = 15;
        int yourResult = increaseByX(7,8);
        if(yourResult != result1)
            System.out.println("Your code didn't increment the variable correctly!");
        else
            System.out.println("Test passed!");

        System.out.println("Testing countdown!");
        countDown(7);
        System.out.println("Does that look right?");


        String vowelTester = "WELCOME TO COMP250!";
        if(countVowels(vowelTester) != 5)
            System.out.println("Wrong amount of vowels!");
        else
            System.out.println("Test passed!");


        System.out.println("Testing your even and odd counter!");
        int[] testArray = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println("Test 1: ");
        System.out.println("Expected: 0 Even, 10 Odd");
        System.out.println("Your output: ");
        evensAndOdds(testArray);

        int[] secondTestArray = {2, 2, 2, 2, 2, 2, 1, 1, 1, 1};
        System.out.println("Test 2: ");
        System.out.println("Expected: 6 Even, 4 Odd");
        System.out.println("Your output: ");
        evensAndOdds(secondTestArray);


        System.out.println("Testing your shape drawers!");

        System.out.println("Does this look correct?");

        drawFullRectangle(10,10);

        System.out.println("What about this?");
        drawEmptyRectangle(10, 10);

        System.out.println("And this?");
        drawTriangle(9);

        System.out.println("And finally?");
        drawEquilateralTriangle(10);


        System.out.println("Did you pass all the tests?!!!!");

        System.out.println("If so, then congrats! < 3");


    }

    static int increaseByX(int variable, int increment)
    {

        return variable + increment;
    }

    static void countDown(int start)
    {
        //Count from start to 0 INCLUDED, and print each result

        for (int i = start; i>=0; i--) {
            System.out.println(i);
        }

    }

    //Let's crank things up shall we?


    static int countVowels(String input)
    {
        //Write a method that counts the number of vowels in a given String!
        //Only count vowels that are in capital letter form! A E I O U Y

        int vowels = 0;

        for (int i = 0; i < input.length(); i++) {

            if (input.charAt(i) == 'A' || input.charAt(i) == 'E' || input.charAt(i) == 'I' || input.charAt(i) == 'O' || input.charAt(i) == 'U' || input.charAt(i) == 'Y') vowels ++;

        }

        return vowels; //Replace by the number of vowels!
    }

    static void evensAndOdds(int[] array)
    {
        //Write a method that find the number of even and the number of odd entries in a given array. Print both results!

        int numEven = 0;
        int numOdd = 0;

        for (int i = 0; i < array.length; i++) {

            if (array[i]%2 == 0) {
                // If element is even
                numEven++;
            } else {
                // Element is odd
                numOdd++;
            }

        }

        System.out.println("Even: " + numEven);
        System.out.println("Odd: " + numOdd);

    }

    static void drawFullRectangle(int height, int width)
    {

        //Write a method that draws a shape like this:
        /*
        x x x x x
        x x x x x
        x x x x x
        (This should be the output of drawFullRectangle(3,5) )
         */

        String strOutput = "";

        for (int i = 0; i < height; i++) {

            for (int j = 0; j < width; j++) {

                strOutput += "x ";

            }

            strOutput += "\n";
        }

        System.out.println(strOutput);

    }

    static void drawEmptyRectangle(int height, int width)
    {
        //Write a method that draws a shape like this:

        /*
        x x x x x
        x       x
        x       x
        x       x
        x       x
        x x x x x
        (This should be the output of drawEmptyRectangle(6,5) )
         */


        String strOutput = "";

        for (int i = 0; i < height; i++) {

            if (i == 0 || i == height-1) {

                for (int j = 0; j < width; j++) {

                    strOutput += "x ";

                }
            } else {

                strOutput += "x ";

                for (int j = 1; j < width-1; j++) {

                    strOutput += "  ";

                }

                strOutput += "x ";
            }


            strOutput += "\n";
        }

        System.out.println(strOutput);

    }


    static void drawTriangle(int height)
    {
        //Write a method that draws a triangle of this shape:
        /*
        x
        xx
        xxx
        xxxx
        xxxxx
        xxxxxx
        xxxxxxx
        xxxxxxxx
        xxxxxxxxx
        xxxxxxxxxx
        (This is the output for height 10)
         */

        String strOutput = "";

        for (int i = 0; i < height; i++) {

            for (int j = 0; j <= i; j++) {

                strOutput += "x";

            }

            strOutput += "\n";

        }

        System.out.println(strOutput);

    }

    static void drawEquilateralTriangle(int height)
    {
        //Write a method that draws a triangle of this shape:

        /*

           *
          ***
         *****
        *******

        (This should be the output for height 4)
         */

        String strOutput = "";

        for (int i = 0; i < height; i++) {

            for (int j = 0; j < height-i; j++) {

                strOutput += " ";

            }

            for (int j = 0; j < (i*2)+1; j++) {

                strOutput += "*";

            }

            strOutput += "\n";

        }

        System.out.println(strOutput);

    }


}
