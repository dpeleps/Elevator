/*
Daniel Pelepelin
112096007
Rec 30 Section 2
*/

import java.util.Scanner;

/**
 * Analyzer class which contains the main method which prompts the user, on separate lines, for
 * each of the 4 parameters required for the simulate method of the Simulator class.
 */
public class Analyzer {
    public static void main(String[] args) {
        Simulator sim = new Simulator();
        Scanner input = new Scanner(System.in);

        double prob;
        int numFloors;
        int numElevators;
        int totalTime;

        boolean invalidInput;
        do {
            invalidInput = false;
            try {
                System.out.println("Welcome to the Elevator simulator!\n");

                System.out.print("Please enter the probability of arrival for Requests: ");
                prob = input.nextDouble();

                System.out.print("Please enter the number of floors: ");
                numFloors = input.nextInt();

                System.out.print("Please enter the number of elevators: ");
                numElevators = input.nextInt();

                System.out.print("Please enter the length of the simulation (in time units): ");
                totalTime = input.nextInt();

                sim.simulate(prob, numFloors, numElevators, totalTime);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Try again\n");
                invalidInput = true;
            }
        }
        while (invalidInput);
    }
}


