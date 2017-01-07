import java.util.Scanner;
import java.util.InputMismatchException;

public class Tree {
    private int endRod, numRing;
    private int[] currentRods;
    private Node start = new Node();

    public Tree(){

        /*Entering baseline data*/
        System.out.println("Input number ring");
        numRing = inputInt();
        System.out.println("Number ring = " + numRing);
        System.out.println("Input start rod (1, 2, 3)");
        int startRod = inputRod()-1;
        System.out.println("Start rod = " + startRod);
        System.out.println("Input end rod (1, 2 or 3 and no equals start rod)");
        endRod = inputRod()-1;
        while (endRod == startRod){
            System.out.print("ERROR! End rod = start rod! Try again;");
            endRod = inputRod();
        }
        System.out.println("End rod = " + endRod);


        currentRods = new int[numRing];
        for(int i = 0; i < numRing; i++){
            currentRods[i] = startRod;
        }

        //Calculation of binary tree
        System.out.print("Start the calculation of binary tree");
        start.create(numRing, endRod, currentRods);
        System.out.print("Calculations completed");



    }

    private int inputInt(){//Entering int and try-catch input exception
        int iInt;
        Scanner sc = new Scanner(System.in);
        try {
            iInt = sc.nextInt();
        }
        catch(InputMismatchException e){
            System.out.println("INPUT ERROR! Try again");
            iInt = inputInt();
        }
        return iInt;
    }

    private int inputRod(){//Entering number rod. Tracking the number of rods is exceeded.
        int iInt = inputInt();
        if(iInt < 1 || iInt > 3){
            System.out.println("ERROR! Only 1, 2 or 3. Try again");
            iInt = inputInt();
        }
        return iInt;
    }

    public static void main(String[] args){
        Tree tree = new Tree();
    }
}
