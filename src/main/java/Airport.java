import java.util.ArrayList;

public class Airport {

    private ArrayList<Plane> hanger1;
    private ArrayList<Plane> hanger2;
    private ArrayList<Flight> departures;
    private String code;

    public Airport(String code){
        this.code = code;
        this.hanger1 = new ArrayList<>();
        this.hanger2 = new ArrayList<>();
        this.departures = new ArrayList<>();
    }


}
