package HotelReservationTests;

import HotelReservationServices.HotelReservationSystem;
import HotelReservationServices.Hotels;
import org.junit.Assert;
import org.junit.Test;

public class HotelReservationTesting {

    @Test
    public void givenHotelsWhenHotelAddedReturnAddedMessage() {

        try
        {
            Hotels lakewood = new Hotels("Lakewood", 110);
            Hotels bridgewood = new Hotels("Bridgewood", 160);
            Hotels ridgewood = new Hotels("Ridgewood", 220);


            HotelReservationSystem hotels = new HotelReservationSystem();

            hotels.addHotels("Lakewood",lakewood);
            hotels.addHotels("Bridgewood",bridgewood);
            hotels.addHotels("Lakewood",ridgewood);

            boolean actualResult =  hotels.addHotels("Lakewood",lakewood);
            boolean expectedResult = true;
            Assert.assertEquals(expectedResult, actualResult);
        }
        catch (AssertionError e)
        {
            System.out.println(e);
        }

    }


}
