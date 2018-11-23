import java.util.ArrayList;

public class Passenger {

    private static int count;
    private static ArrayList<Passenger> allPassengers = new ArrayList<>();
    private int baggage;

    public Passenger(){
        count++;
        Passenger.allPassengers.add(this);
        baggage = 0;
        this.baggage = baggage;
    }

    public static int getNumberOfInstances(){
        return count;
    }

    public static ArrayList<Passenger> getAllPassengers(){
        return allPassengers;
    }

    public void addBaggage(int weight){
        this.baggage += weight;
    }

    public int getBaggage() {
        return this.baggage;
    }
}
