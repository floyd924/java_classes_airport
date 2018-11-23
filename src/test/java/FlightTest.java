import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightTest {

    Flight flight1;
    Plane plane1;
    Passenger passenger1;
    Passenger passenger2;
    Passenger passenger3;

    @Before
    public void setup(){
        plane1 = new Plane(PlaneType.TWINOTTER, "British Airways");
        flight1 = new Flight("RE472", "GVA");
        passenger1 = new Passenger();
    }

//    @Test
//    public void canGetPlane(){
//        assertEquals(plane1, flight1.getPlane());
//    }

    @Test
    public void canGetFlightNumber(){
        assertEquals("RE472", flight1.getFlightNumber());
    }

    @Test
    public void canGetDestination(){
        assertEquals("GVA", flight1.getDestination());
    }

    @Test
    public void canGetBookedPassengerCount(){
        assertEquals(0, flight1.getPassengerBookedCount());
    }

    @Test
    public void canBookPassenger(){
        flight1.bookPassenger(passenger1);
        assertEquals(1, flight1.getPassengerBookedCount());
    }
//
//    @Test
//    public void canGetListOfPassengersBooked(){
//        flight1.bookPassenger(passenger1);
//        assertEquals(passenger1, flight1.getPassengersBooked());
//    }

    @Test
    public void canAssignPlaneToFlight(){
        flight1.assignPlane(plane1);
        assertEquals(plane1, flight1.getPlane());
    }

    @Test
    public void canBoardPassenger(){
        flight1.assignPlane(plane1);
        flight1.boardPassenger(passenger1);
       assertEquals(1, flight1.getPlane().getPassengerCount());
    }

    @Test
    public void canBoardBookedPassengersOntoPlane(){
        flight1.assignPlane(plane1);
        flight1.bookPassenger(passenger1);
        flight1.bookPassenger(passenger2);
        flight1.bookPassenger(passenger3);
        flight1.boardPlane();
        assertEquals(3, flight1.getPlane().getPassengerCount());
    }
}
