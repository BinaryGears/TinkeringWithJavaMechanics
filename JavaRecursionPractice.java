package JavaRecursionPractice;

import java.util.Comparator;

public class JavaRecursionPractice{

    public static void main(String[] args) {
        //Here is a cheatsheet, an experiment template to mess around with recursive programming in Java.
	    //recursiveFunc(1);
        //recursiveFuncI(1);
        //recursiveFuncI1(1);
        //recursiveFuncI2(1);
        Type<Integer> theType = new Type<Integer>(1);
        Type<Integer> theType2 = new Type<Integer>(5);
        theType.recursiveFuncT(theType2);
        System.out.println(theType.valueI);
    }
    //This function demonstrates how recursive functions unfold and finish things in the function
    public static void recursiveFunc(int i) {
        System.out.println("test");
        if (i < 10) {
            int thing = i;
            thing++;
            recursiveFunc(thing);
        }

        System.out.println(i);
    }
    //Similar to the above but returns an int when done
    public static int recursiveFuncI(int i) {
        System.out.println("test");
        if (i < 10) {
            int thing = i;
            thing++;
            recursiveFuncI(thing);
        }

        System.out.println(i);
        return 1;
    }

    // Only the last call, or when the if statement is not true, does the System.out.println(i) activate
    public static int recursiveFuncI1(int i) {
        System.out.println("test");
        if (i < 10) {
            int thing = i;
            thing++;
            return recursiveFuncI1(thing);
        }

        System.out.println(i);
        return 1;
    }

    //An example of how not to end a recursive function
    public static int recursiveFuncI2(int i) {
        System.out.println("test");
        if (i < 10) {
            int thing = i;
            thing++;
            return recursiveFuncI2(thing);
        }

        System.out.println(i);
        return recursiveFuncI2(i);
    }

}

//Making a very generic class to play around with the mechanics of generics combined with recursion.
class Type<T> implements Comparator<Integer>{
    int valuei;
    Integer valueI;
    Type(Integer valueI) {
        this.valueI = valueI;
    }

    //Go until the this.valueI is equal to typeT.valueI
    public void recursiveFuncT(Type<T> typeT) {
        if (this.compare(this.valueI, typeT.valueI) > 0) {
            this.valueI--;
            recursiveFuncT(typeT);
        }
        else if (this.compare(this.valueI, typeT.valueI) < 0) {
            this.valueI++;
            recursiveFuncT(typeT);
        }
    }


    //Just need this to implement the comparator interface
    //implements the compare method
    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 > o2) {
            return 1;
        }
        else if (o1 < o2) {
            return -1;
        }
        return 0;
    }
}
