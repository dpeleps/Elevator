/*
Daniel Pelepelin
112096007
Rec 30 Section 2
*/

/**
 * BooleanSource class which shows the probability
 */
public class BooleanSource {
    private double probability;

    /**
     * Checks if the probability entered is less than 0 or greater than 1. If so, throw an exception.
     * @param prob
     * @throws IllegalArgumentException
     */
    public BooleanSource(double prob) throws IllegalArgumentException{
        if(prob < 0.0 || prob > 1.0){
            throw new IllegalArgumentException("The probability has to be within 0.00 and 1.00.");
        }
        probability = prob;
    }

    /**
     * Checks if the random number between 0-1 is less than probability then returns the boolean value.
     * @return
     */
    public boolean requestArrived(){
        return Math.random() <= probability;
    }
}
