package Matrices;

public class Matrices
{

    public static void main(String[] args)
    {
        //Matrices are arrays of arrays. In other words, they're "2-Dimensional arrays"

        //Here's how to create matrices
        int[][] numbers = new int[3][3]; //As usual, you define the type, name the array, and set its size.

        //Let's fill it! To do so, we'll use 2 loops, one within another!
        int value = 1;
        for(int yIndex = 0; yIndex < numbers.length; yIndex++) //Loop through each array in the array of arrays
        {
            for(int xIndex = 0; xIndex < numbers[yIndex].length; xIndex++) //Loop through each value in that array
            {
                numbers[yIndex][xIndex] = value++; //Assign the value of "value" to that array slot located at xIndex, yIndex in the array. Note that we use the yIndex first for arrays!
                // Doing "value++" is equivalent to doing this:
                /*
                  numbers[yIndex][xIndex] = value;
                  value++;
                 */
            }
        }
        //Now let's print it, using a method so we can practice our method creation!
        printMatrix(numbers);

        //Great! Now let's do some exercises!
        //Try to create the following patterns with matrices, WITHOUT hard-coding!
        //Here's an example:

        /*
        1 0 1
        0 1 0
        1 0 1
        This can be easily hardcoded (where you manually give each slot a value). This won't help you learn!
        Use loops and any other tools to help you. If you achieve the output shown above, then your code must also show this for a bigger array:

       1 0 1 0
       0 1 0 1
       1 0 1 0
       0 1 0 1
       etc...


         */

        //Now for the exercises: Don't forget, try them out first, and if you fail, ask on Ed!

        /* We'll be using 5x5 matrices, but these should also work on 6x6 and 7x7 and any other size! (bigger or smaller)

        10 11 12 13
        14 15 16 17
        18 19 20 21
        22 23 24 25
        -----------
        1 0 1 0 1
        0 1 0 1 0
        1 0 1 0 1
        0 1 0 1 0
        1 0 1 0 1
        -----------
        1 0 0 0 1
        0 1 0 1 0
        0 0 1 0 0
        0 1 0 1 0
        1 0 0 0 1
        also for even sizes: (Same code should work for both cases!)
        1 0 0 1
        0 1 1 0
        0 1 1 0
        1 0 0 1
        -----------
        These next two are tough!
        5  6  7  8  9
        14 13 12 11 10
        15 16 17 18 19
        24 23 22 21 20
        25 26 27 28 29
        -----------
        3  3  3  3  3
        3  6  6  6  3
        3  6  12 6  3
        3  6  6  6  3
        3  3  3  3  3
        //This should work for any starting number (not only 3) and should work for both even and odd-sized matrices!

        //Hint for the last one:

        |
        |
        |
        |
        |
        |
        |
        3 loops! (You can probably do it with only 2, but using a 3rd loop makes it easier!




         */

    }

    static void printMatrix(int[][] matrix)
    {
        for(int yIndex = 0; yIndex < matrix.length; yIndex++) //Loop through each array in the array of arrays
        {
            for (int xIndex = 0; xIndex < matrix[yIndex].length; xIndex++) //Loop through each value in that array
            {
                System.out.print(matrix[yIndex][xIndex]+"\t"); //print without ln prints on a same line and does not create a new line. "\t" indicates a tab character! (equivalent to 4 spaces by default)
            }
            System.out.println(); //Print an empty line after each sub-array
        }
    }
}
