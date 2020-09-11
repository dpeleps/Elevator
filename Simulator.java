/*
Daniel Pelepelin
112096007
Rec 30 Section 2
*/

import java.util.ArrayList;

/**
 * Simulation class which carries out the simulation and prints the results.
 */
public class Simulator {

    /**
     * Method that does the simulation process.
     *
     * @param prob
     * @param numFloors
     * @param numElevators
     * @param simLength
     * @throws IllegalArgumentException
     */
    public static void simulate(double prob, int numFloors, int numElevators, int simLength) throws IllegalArgumentException{
        RequestQueue requests = new RequestQueue();
        ArrayList<Elevator> elevators = new ArrayList<>();
        BooleanSource probability = new BooleanSource(prob);

        int totalWaitTime = 0;
        int totalRequests = 0;
        double averageWaitTime;

        if(numFloors < 2){
            throw new IllegalArgumentException("The total number of floors must be greater than 1.");
        }
        if (numElevators < 1){
            throw new IllegalArgumentException("There must be more than 0 elevators.");
        }
        if(simLength < 1){
            throw new IllegalArgumentException("The length of the simulation must be greater than 0 time units.");
        }

        for (int i = 0; i < numElevators; i++){ //Creates the ArrayList of elevator objects.
            elevators.add(new Elevator());
        }

        //simulation
        for(int i = 0; i < simLength; i++){
            if(probability.requestArrived()){
                Request newRequest = new Request(numFloors);
                newRequest.setTimeEntered(i);
                requests.enqueue(newRequest);
                totalRequests++;
            }
            for(Elevator elevator: elevators){
                if(elevator.getElevatorState() == Elevator.IDLE && !requests.isEmpty()){
                    Request currentRequest = requests.dequeue();
                    elevator.setRequest(currentRequest);
                    if(elevator.getCurrentFloor() == currentRequest.getSourceFloor()){
                        elevator.setElevatorState(Elevator.TO_DESTINATION);
                    }
                    else{
                        elevator.setElevatorState(Elevator.TO_SOURCE);
                    }
                }
            }
            for(Elevator elevator: elevators){
                Request request = elevator.getRequest();
                if(request == null){
                    break;
                }
                switch (elevator.getElevatorState()) {
                    case Elevator.TO_SOURCE:
                        if(request.getSourceFloor() < elevator.getCurrentFloor()){
                            elevator.setCurrentFloor(elevator.getCurrentFloor() - 1);
                        }
                        else{
                            elevator.setCurrentFloor(elevator.getCurrentFloor() + 1);
                        }
                        break;
                    case Elevator.TO_DESTINATION:
                        if(request.getDestinationFloor() < elevator.getCurrentFloor()){
                            elevator.setCurrentFloor(elevator.getCurrentFloor() - 1);
                        }
                        else{
                            elevator.setCurrentFloor(elevator.getCurrentFloor() + 1);
                        }
                        break;
                }
                if(elevator.getCurrentFloor() == request.getDestinationFloor()){
                    elevator.setElevatorState(Elevator.IDLE);
                }
                else if(elevator.getCurrentFloor() == request.getSourceFloor()){
                    elevator.setElevatorState(Elevator.TO_DESTINATION);
                    totalWaitTime += i - request.getTimeEntered();
                }
            }
        }

        averageWaitTime = (double) totalWaitTime / totalRequests;
        System.out.println("\nTotal Wait Time: " + totalWaitTime);
        System.out.println("Total Requests: " + totalRequests);
        System.out.printf("Average Wait Time: %.2f", averageWaitTime);
    }
}
