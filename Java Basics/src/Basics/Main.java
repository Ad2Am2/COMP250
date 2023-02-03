package Basics;

import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Hello world!"); //Prints the string (sentence) "Hello World"
        System.out.println(4); //Prints the number 4
        System.out.println(true); //Prints a true value
        System.out.println(); //Prints an empty line
        //Shortcut: type "sout" without the " " signs, then press TAB









        //****************Variables****************\\
        //Usage: type variableName = value; OR type variableName;
        //Variables are used to store data and information needed for the program you're making. It can

        int number=51; //int represents integers
        float floatingPointNumber =21f; //float represents a floating point number. You add "f" after its value
        double decimal = 55.1; //double represents a decimal with higher precision than a float
        char character ='a'; //char represents a character. It can be either the character between ' ' or an ASCII number
        String sentence = "Hello, World!"; //String represents a group of characters. Note that declaring it requires a Capital letter at the beginning of the word "String"
        boolean bool = false; //boolean represents a true or false value. These are useful for checking conditions (we'll see those later on)

        //You can also print these
        System.out.println(number); //Outputs 51
        System.out.println(bool); //Outputs "false"
        //You can change the values of variables using the following approaches:

        number*=5;
        number = number*5;
        //Both multiply by 5

        number++; //This syntax "uses" the variable then augments its value!
        number= number+1;
        ++number; //This syntax augments the value of the variable, then uses it!
        //These increase by 1

        number+=5;
        number= number-5;
        number/=5;
        number=number/5;
        //Etc!

        //To raise a number to a power, use the Math.pow() method!

        decimal = Math.pow(decimal,2); //Basically does decimal*decimal. Remember, using methods is usually cleaner and results in a more readable code!



        //****************Conditionals****************\\
        //Conditions and operators can be used to implement logic into your program to make them responsive

        //The if() statement checks the given argument it's given, if the output is true, it will execute the code block attached to it.
        //For more conditions, you can use an else if() or an else.

        int number1 = 250, number2 =202; //You can also declare multiple variables of the same type on a same line using a comma to separate them

        if(number1>number2) //Checks if 250 > 202. If so, runs the code in the curly braces. Once a condition is met, the program ignores all "else if" statements below it.
        {
            System.out.println("250 is larger than 202");
        }
        else if(number2>number1) //If the first condition fails, this condition is checked
        {
            System.out.println("202 is larger than 250");
        }
        else //else means "for every other case not mentioned above"
        {
            System.out.println("250 is equal to 202");
        }



        //You can omit the curly braces if you only have one line of code to execute. The following code does the exact same job as the code above. Note that this is NOT recommended if you don't have experience with such style

        if(number1>number2)
            System.out.println("250 is larger than 202");

        else if(number2>number1)
            System.out.println("202 is larger than 250");

        else
            System.out.println("250 is equal to 202");


        //You can compare numbers (and characters) using the following operators: >, <, >=, <=, == (double equality signs = = without a space in between), != ( ! = , an exclamation mark means "NOT")
        //Remember, one = means assignment, two = means condition check for equality

        //NOTE: To compare Strings, do the following:
        String s1 = "Hello!", s2="World!";
        System.out.println(s1.equals(s2)); //Outputs FALSE. DO NOT USE == FOR STRINGS!

        //You can add more logic to your if statements. Note that the arguments in an if statement will be a boolean true or false, and the if statement runs accordingly
        //You can use conditional operators such as || (OR) and && (AND). You can also use ! for negation.

        boolean condition1 = false, condition2 = true, condition3=false, condition4=false;

        //You can also evaluate conditions in a print statement
        System.out.println(condition2 && condition3); //Outputs true if BOTH condition 2 AND condition 3 are TRUE. This will output "false"
        System.out.println(condition2 || condition1); //Outputs true if EITHER condition 2 OR condition 3 is TRUE. This will output "true"
        System.out.println(!condition4 && !condition1); //Outputs true if BOTH condition 4 AND condition 1 are FALSE. This will output "true"

        //Can you guess what this outputs?
        System.out.println((condition2 && ! condition3) || (condition4 || !condition1)); // ANSWER IS -----------------------------------------------------------------------------------------> TRUE




        //****************Loops****************\\
        //Loops are useful when performing a task multiple times in a row
        //There are many types of loops, we'll look at the two you'll use 99% of the time:

        //The WHILE loop:
        //Usage: while(condition) { // Do stuff }.  This executes everything between the { } as long as the condition given as argument is true. This condition is checked at every iteration
        int loopNumber = 0;
        while(loopNumber<10) //As long as loopNumber is less than 10, execute the code block
        {
            System.out.println(loopNumber);
            loopNumber++; //Increments loopNumber by 1, you can also use loopNumber = loopNumber+1;
        }

        //The FOR loop:
        //Useful when iterating through a data structure. Usage : for(int index = 0; index < conditionToFinish; index++)

        for(int index = 0; index < 10; index++) //This does the exact same thing as the while loop shown above. Note that "index" is simply a variable name and can be changed. People usually use "i", but this makes the code hard to read!
        {
            System.out.println(index);
        }
        //We'll use these later on


        //****************User Input and Random****************\\
        //To store the input from a user, you need to use a Scanner Object:
        Scanner input  = new Scanner(System.in);
        int num = input.nextInt(); //Stores a number
        String sen = input.nextLine(); //Stores a String


        //To generate a random number, you'll need a Random Object:
        Random random = new Random();
        int ran = random.nextInt(101); //Generates a pseudo-random integer between 0 and 100. Notice how I used "101" instead of 100. This is because nextInt() is exclusive!
        int ran2 = random.nextInt(51)+50; //Generates a number between 50 and 100

        double ranDouble = random.nextDouble()*100; //Generates a decimal number between 0 and 100. Note that "nextDouble" will have a decimal output between 0.0 and 1.0, so we need to multiply its output by the maximum number we want to get.




        //****************Arrays****************\\
        //Arrays are the most basic data structure. They are used to store different elements of the same nature:
        //Usage: type[] name = { //VALUES} OR type[] name = new type[numberOfElements]

        int[] numbers = new int[10]; //Creates an array of 10 numbers
        //This array will contain 10 elements, with index 9 being the end because we start from 0 !
        //Indices: 0 1 2 3 4 5 6 7 8 9
        //Each index will contain an integer value in this array. So we are now storing 10 numbers in a single structure!

        //Let's now fill it randomly with values between 25 and 50!

        Random valueRandomizer = new Random(); //Initialize a new Random Object

        for(int index = 0; index<numbers.length; index++) //Loop from 0 to 9.
        {
            numbers[index] = valueRandomizer.nextInt(26)+25; //To assign or access an array element, you do arrayName[index]
        }

        //Printing the array needs a little work. The following won't work:
        System.out.println(numbers); //This will NOT print the elements

        //To print an array, you need to loop through it and print each value. Example:
        for (int index : numbers)
        {
            System.out.println(index);
        }
        //This is called an "enhanced" for loop. It does the same as a regular "for" loop and will be VERY useful for non-linear data structures!:D

        //You can also use a usual for loop:
        for(int index =0; index<numbers.length; index++)
        {
            System.out.println(numbers[index]);
        }
        //Once again, you can omit the { } if you have experience with the style:
        for (int index : numbers)
            System.out.println(index);


        //Congrats on learning the basics! Check out the "Methods" file, then go do the Exercises !



    }
}









