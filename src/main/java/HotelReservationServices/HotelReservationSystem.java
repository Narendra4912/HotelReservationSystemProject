package HotelReservationServices;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

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

//        LocalDate localDate = LocalDate.of(date.getYear(),date.getMonth(), date.getDate());
//        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        Map.Entry<String,Hotels> entry = hotelsMap.entrySet().iterator().next();
        Hotels ht = entry.getValue();
        int cheapestRate = ht.getHotelRate();
        int totalRate=0;
        String hotelName = null;

//        if(dayOfWeek.toString().equals(Calendar.SATURDAY) || dayOfWeek.toString().equals(Calendar.SUNDAY) )
//            return null;
//        else
//        {
            for(String hotel : hotelsMap.keySet()){
                int hotelRate =hotelsMap.get(hotel).getHotelRate();
                if(hotelRate < cheapestRate)
                {
                    cheapestRate = hotelRate;
                    hotelName = hotelsMap.get(hotel).getHotelName();
                }
            }
            totalRate = cheapestRate * noOfDays;
            return "Hotel Name = "+ hotelName + " Total Rate = "+ totalRate;
 //       }

//        if(dayOfWeek.toString().equals(Calendar.MONDAY) || dayOfWeek.toString().equals(Calendar.TUESDAY) ||
//                dayOfWeek.toString().equals(Calendar.WEDNESDAY) || dayOfWeek.toString().equals(Calendar.THURSDAY) ||
//                dayOfWeek.toString().equals(Calendar.FRIDAY))
//        {
//            for(String hotel : hotelsMap.keySet()){
//                int hotelRate =hotelsMap.get(hotel).getHotelRate();
//                if(hotelRate < cheapestRate)
//                {
//                    cheapestRate = hotelRate;
//                    hotelName = hotelsMap.get(hotel).getHotelName();
//                }
//            }
//            totalRate = cheapestRate * noOfDays;
//            return "Hotel Name = "+ hotelName + " Total Rate = "+ totalRate;
//        }
//        else
//            return null;
    }
}
