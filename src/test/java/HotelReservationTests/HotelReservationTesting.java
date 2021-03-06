package HotelReservationTests;

import HotelReservationServices.HotelReservationSystem;
import HotelReservationServices.Hotels;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

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
            String dateString = "10-Sep-2020";
            SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
            Date date = format.parse(dateString);
            String hotelDetails = hotels.cheapestHotel(date, 2);
            String expectedResult = "Hotel Name = Lakewood Total Amount = 220";
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

    @Test
    public void givenHotelWhenSetDateReturnCheapestHotelName() throws ParseException {
        try
        {
            HotelReservationSystem hotels = new HotelReservationSystem();
            String startDateString = "11-Sep-2020";
            String endDateString = "12-Sep-2020";

            SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
            Date startDate = format.parse(startDateString);
            Date endDate = format.parse(endDateString);
            String hotelDetails = hotels.cheapestHotelOnWeekdayWeekend(startDate,endDate);
            String expectedResult = "Hotel Name = Bridgewood Total Amount = 100";
            Assert.assertEquals(expectedResult,hotelDetails);
            System.out.println(hotelDetails);
        }
        catch (Exception e)
        {
            System.out.println("Incorrect Date format");
        }
    }

    @Test
    public void givenHotelWhenHotelRatingAddedReturnTrue() {
        try
        {
            Hotels lakewood = new Hotels("Lakewood", 110,90,3);
            Hotels bridgewood = new Hotels("Bridgewood", 150,50,4);
            Hotels ridgewood = new Hotels("Ridgewood", 220,150,5);

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
    public void givenHotelWhenSetDateReturnBestRatedCheapestHotelName() throws ParseException {
        try
        {
            HotelReservationSystem hotels = new HotelReservationSystem();
            String startDateString = "11-Sep-2020";
            String endDateString = "12-Sep-2020";

            SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
            Date startDate = format.parse(startDateString);
            Date endDate = format.parse(endDateString);
            String hotelDetails = hotels.cheapestHotelOnWeekdayWeekendWithRating(startDate,endDate);
            String expectedResult = "Hotel Name = Lakewood Total Amount = 100 Rating = 4";
            Assert.assertEquals(expectedResult,hotelDetails);
            System.out.println(hotelDetails);
        }
        catch (Exception e)
        {
            System.out.println("Incorrect Date format");
        }
    }
}
