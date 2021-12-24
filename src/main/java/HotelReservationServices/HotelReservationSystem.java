package HotelReservationServices;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class HotelReservationSystem {

    Map<String, Hotels> hotelsMap = new HashMap<>();

    public boolean collectHotelsList(ArrayList<Hotels> hotelsList) {
        for (Hotels hotels : hotelsList)
        {
            hotelsMap.putIfAbsent(hotels.getHotelName(),hotels);
        }
        return true;
    }

    public void showHotels(){
        System.out.println("Available Hotels => ");
        for(String hotelName : hotelsMap.keySet()){
            String value =hotelsMap.get(hotelName).toString();
            System.out.println(hotelName+" --> "+value);
        }
    }

    public String cheapestHotel(Date date, int noOfDays)
    {
        Hotels lakewood = new Hotels("Lakewood", 110);
        Hotels bridgewood = new Hotels("Bridgewood", 160);
        Hotels ridgewood = new Hotels("Ridgewood", 220);

        HotelReservationSystem hotels = new HotelReservationSystem();
        ArrayList<Hotels> hotelsList = new ArrayList<>();

        hotelsMap.putIfAbsent("Lakewood",lakewood);
        hotelsMap.putIfAbsent("Bridgewood",bridgewood);
        hotelsMap.putIfAbsent("Ridgewood",ridgewood);

        Map.Entry<String,Hotels> entry = hotelsMap.entrySet().iterator().next();
        Hotels ht = entry.getValue();
        int cheapestRate = ht.getHotelRate();
        int totalAmount=0;
        String hotelName = null;

        for(String hotel : hotelsMap.keySet()){
            int hotelRate =hotelsMap.get(hotel).getHotelRate();
            if(hotelRate < cheapestRate)
            {
                cheapestRate = hotelRate;
                hotelName = hotelsMap.get(hotel).getHotelName();
            }
        }
        totalAmount = cheapestRate * noOfDays;
        return "Hotel Name = "+ hotelName + " Total Amount = "+ totalAmount;
    }

    public String cheapestHotelOnWeekdayWeekend(Date startDate, Date endDate)
    {
        Hotels lakewood = new Hotels("Lakewood", 110,90);
        Hotels bridgewood = new Hotels("Bridgewood", 150,50);
        Hotels ridgewood = new Hotels("Ridgewood", 220,150);

        HotelReservationSystem hotels = new HotelReservationSystem();
        ArrayList<Hotels> hotelsList = new ArrayList<>();

        hotelsMap.putIfAbsent("Lakewood",lakewood);
        hotelsMap.putIfAbsent("Bridgewood",bridgewood);
        hotelsMap.putIfAbsent("Ridgewood",ridgewood);

        String startDateDayName = new SimpleDateFormat("EEEE").format(startDate);
        String endDateDayName = new SimpleDateFormat("EEEE").format(endDate);

        long difference = endDate.getTime() - startDate.getTime();
        int noOfDays = (int) TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS) + 1;

        Map.Entry<String,Hotels> entry = hotelsMap.entrySet().iterator().next();
        Hotels ht = entry.getValue();
        int cheapestRate = ht.getWeekdayRate();
        int totalAmount=0;
        String hotelName = null;

        if(startDateDayName.toString().equals("Saturday") || startDateDayName.toString().equals("Sunday")
            || endDateDayName.toString().equals("Saturday") || endDateDayName.toString().equals("Sunday"))
        {
            for(String hotel : hotelsMap.keySet()){
                int hotelRate =hotelsMap.get(hotel).getWeekendRate();
                if(hotelRate < cheapestRate)
                {
                    cheapestRate = hotelRate;
                    hotelName = hotelsMap.get(hotel).getHotelName();
                }
            }
            totalAmount = cheapestRate * noOfDays;
            return "Hotel Name = "+ hotelName + " Total Amount = "+ totalAmount;
        }
        else
        {
            for(String hotel : hotelsMap.keySet()){
                int hotelRate =hotelsMap.get(hotel).getWeekdayRate();
                if(hotelRate < cheapestRate)
                {
                    cheapestRate = hotelRate;
                    hotelName = hotelsMap.get(hotel).getHotelName();
                }
            }
            totalAmount = cheapestRate * noOfDays;
            return "Hotel Name = "+ hotelName + " Total Amount = "+ totalAmount;
        }
    }
}
