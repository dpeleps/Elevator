/*
Daniel Pelepelin
112096007
Rec 30 Section 2
*/

import java.util.ArrayDeque;

/**
 * ReqeustQueue class that extends ArrayDeque which creates the methods for the queue.
 */
public class RequestQueue extends ArrayDeque<Request> {
    private ArrayDeque<Request> requests;

    public RequestQueue(){
        requests = new ArrayDeque<Request>();
    }

    public void enqueue(Request item){
        requests.add(item);
    }

    public Request dequeue(){
        return requests.removeFirst();
    }

    public int size(){
        return requests.size();
    }

    public boolean isEmpty(){
        return(requests.size() == 0);
    }
}
