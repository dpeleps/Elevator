/*
Daniel Pelepelin
112096007
Rec 30 Section 2
*/

/**
 * Elevator Class which creates the elevator object and contains the state of the elevator
 */
public class Elevator {
    private int currentFloor;
    private int elevatorState;
    Request request; // Request object representing the request being handled or null if the Elevator is idle

    //States of the elevator
    static final int IDLE = 0;
    static final int TO_SOURCE = 1;
    static final int TO_DESTINATION = 2;

    /**
     * Default constructor for Elevator Class
     */
    public Elevator() {
        request = null;
        setElevatorState(IDLE);
        setCurrentFloor(1);
    }

    /**
     * gets the current request
     * @return
     */
    public Request getRequest() {
        return request;
    }

    /**
     * sets the current request
     * @param request
     */
    public void setRequest(Request request) {
        this.request = request;
    }

    /**
     * Gets the current floor of the elevator
     *
     * @return
     */
    public int getCurrentFloor() {
        return currentFloor;
    }

    /**
     * Sets the current floor of the elevator
     *
     * @param currentFloor
     */
    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    /**
     * Gets the currents state at which the elevator is in
     *
     * @return
     */
    public int getElevatorState() {
        return elevatorState;
    }

    /**
     * Sets the state of the elevator
     *
     * @param elevatorState
     */
    public void setElevatorState(int elevatorState) {
        this.elevatorState = elevatorState;
    }
}
