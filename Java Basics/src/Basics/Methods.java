package Basics;

public class Methods
{
    //Methods help you write clean, readable, and scalable code
    //Methods are blocks of code that execute when called. They can have a return type (aka assign a value) or they can be void (you call the method, and it does its job on its own)


    //Let's take a look at an example method

    //Don't worry about the "static" for now.
    //This is a void method called sayHello(). It is void because it does the job on its own when called.
    static void sayHello()
    {
        System.out.println("Hello, World!");
    }

    //Here's how to call it

    /*
    public static void main(String[] args)
    {
        sayHello(); //prints "Hello, World!"
    }
    */

    //Methods can update values too using their return type.
    //This method "Returns" an integer value to the main program so it can use it. We gave it a "parameter" or an "argument" of type int called "number".

    static int multiplyByFive(int number)
    {
        return number*5;
    }

    //Here's how to use it

    /*
    public static void main(String[] args)
    {
        int num = 2; //Declare a variable
        num = multiplyByFive(num); // assign it to the return value of the function. After execution, "num" will be equal to 10

        //Note that the following won't do anything:
        multiplyByFive(num);
        //The method is being called, but we're not storing its output anywhere, so nothing happens.
    }
    */



    //You can use methods within each other, or as parameters of each other:

    static int incrementByOne(int number)
    {
        return ++number; //Returns the value received as input, + 1. If given 5, it'll return 6. You can also do number+1 if you prefer
    }

    static int doubleNumber(int number)
    {
        return number*2; //Returns number * 2.
    }

    static void voidDoubleNumber(int number)
    {
        number*=2;
    }

    //Example use:
    public static void main(String[] args)
    {
        int result = incrementByOne(doubleNumber(4)); // What does this output? xD
        //Let's see!
        System.out.println(result);


        voidDoubleNumber(result); //What about this? Does it output anything?
        //Let's print "result" again
        System.out.println(result);
        //You can run this using the green triangle on the left of line 69. As you can see, any primitive parameter passed to a void function would do nothing.
        //Note that primitives include char, int, float, short, double, long, and boolean. Arrays can be modified within void functions since they're "Objects" and not primitives

        //Take the following code: (you can see the code for each method, written below)

        int[] array = {1,2,3,4,5,6,7,8,9};
        printArray(array);
        modifyArray(array);
        printArray(array);

        //Notice how the values changed, despite using void functions. This is due to the way arrays work

    }

    static void modifyArray(int[] array)
    {
        for(int index = 0; index< array.length; index++)
         array[index]*=2;
    }

    static void printArray(int[] array)
    {
        for (int index : array)
            System.out.print(index+"  ");
        System.out.println();
    }





}
