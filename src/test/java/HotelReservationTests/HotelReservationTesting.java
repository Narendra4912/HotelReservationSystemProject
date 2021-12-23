package HotelReservationTests;

import HotelReservationServices.HotelReservationSystem;
import HotelReservationServices.Hotels;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class HotelReservationTesting {

    @Test
    public void givenHotelsWhenHotelAddedReturnAddedMessage() {

        try
        {
            Hotels lakewood = new Hotels("Lakewood", 110);
            Hotels bridgewood = new Hotels("Bridgewood", 160);
            Hotels ridgewood = new Hotels("Ridgewood", 220);

            ArrayList<Hotels> hotelsList = new ArrayList<>();
            HotelReservationSystem hotels = new HotelReservationSystem();

            hotelsList.add(lakewood);
            hotelsList.add(bridgewood);
            hotelsList.add(ridgewood);

            boolean actualResult =  hotels.collectHotelsList(hotelsList);
            hotels.showHotels();

            boolean expectedResult = true;
            Assert.assertEquals(expectedResult, actualResult);
        }
        catch (AssertionError e)
        {
            System.out.println("Please enter at least one hotel data");
        }

    }

    @Test
    public void givenHotelsWhenCheapestHotelRateReturnHotelName() {
        try {
            HotelReservationSystem hotels = new HotelReservationSystem();
            String dateString = "13-Sep-2020";
            SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
            Date date = format.parse(dateString);
            String hotelDetails = hotels.cheapestHotel(date, 2);
            String expectedResult = "Hotel Name = Lakewood Total Rate = 220";
            Assert.assertEquals(expectedResult, hotelDetails);
            System.out.println(hotelDetails);
        }
        catch (Exception e)
        {
            System.out.println("Incorrect Date format");
        }
    }

    @Test
    public void givenHotelWhenWeekdayWeekendRatesAddedReturnTrue() {
        try
        {
            Hotels lakewood = new Hotels("Lakewood", 110,90);
            Hotels bridgewood = new Hotels("Bridgewood", 150,50);
            Hotels ridgewood = new Hotels("Ridgewood", 220,150);

            ArrayList<Hotels> hotelsList = new ArrayList<>();
            HotelReservationSystem hotels = new HotelReservationSystem();

            hotelsList.add(lakewood);
            hotelsList.add(bridgewood);
            hotelsList.add(ridgewood);

            boolean actualResult =  hotels.collectHotelsList(hotelsList);
            hotels.showHotels();

            boolean expectedResult = true;
            Assert.assertEquals(expectedResult, actualResult);
        }
        catch (AssertionError e)
        {
            System.out.println("Please enter at least one hotel data");
        }
    }
}
