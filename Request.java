/*
Daniel Pelepelin
112096007
Rec 30 Section 2
*/

/**
 * Request Class which contains mutator and accessor methods for 3 parameters
 */
public class Request {
    private int sourceFloor;
    private int destinationFloor;
    private int timeEntered;


    /**
     * The default constructor that sets a random sourceFloor and destinationFloor based
     * on the total number of floors within the building
     *
     * @param totalBuildingFloors
     */
    public Request(int totalBuildingFloors) {
        setSourceFloor((int) (Math.random() * totalBuildingFloors) + 1);
        setDestinationFloor((int) (Math.random() * totalBuildingFloors) + 1);
    }

    /**
     * Gets the source floor
     *
     * @return
     */
    public int getSourceFloor() {
        return sourceFloor;
    }

    /**
     * Sets the source floor
     *
     * @param sourceFloor
     */
    public void setSourceFloor(int sourceFloor) {
        this.sourceFloor = sourceFloor;
    }

    /**
     * Gets the destination floor
     *
     * @return
     */
    public int getDestinationFloor() {
        return destinationFloor;
    }

    /**
     * Sets the destination floor
     *
     * @param destinationFloor
     */
    public void setDestinationFloor(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }

    /**
     * Gets the time entered
     *
     * @return
     */
    public int getTimeEntered() {
        return timeEntered;
    }

    /**
     * Sets the time entered
     *
     * @param timeEntered
     */
    public void setTimeEntered(int timeEntered) {
        this.timeEntered = timeEntered;
    }
}
