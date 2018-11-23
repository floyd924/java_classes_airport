import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {

    Plane plane1;
    Passenger person1;

    @Before
    public void setup(){
        plane1 = new Plane(PlaneType.CESNA187, "Monarch");
    }

    @Test
    public void canGetPlaneType(){
        assertEquals(PlaneType.CESNA187, plane1.getPlaneType());
    }

    @Test
    public void canGetAirline(){
        assertEquals("Monarch", plane1.getAirline());
    }


    @Test
    public void canGetPassengerCount(){
        assertEquals(0, plane1.getPassengerCount());
    }

    @Test
    public void canGetPlaneCapacity(){
        assertEquals(2, plane1.getCapacity());
    }

    @Test
    public void canAddPassenger(){
        plane1.addPassenger(person1);
        assertEquals(1, plane1.getPassengerCount());
    }

//    @Test
//    public void canGetPassengers(){
//        plane1.addPassenger(person1);
//        assertEquals(person1, plane1.getPassengers());
//    }

    @Test
    public void canGetLuggageAllowance(){
        assertEquals(10, plane1.getLuggageAllowance());
    }
}
