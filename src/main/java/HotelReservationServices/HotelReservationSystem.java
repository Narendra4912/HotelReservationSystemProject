package HotelReservationServices;

import java.util.HashMap;
import java.util.Map;

public class HotelReservationSystem {

    Map<String, Hotels> hotelsMap = new HashMap<>();

    public boolean addHotels(String hotelName, Hotels hotel)
    {
        hotelsMap.putIfAbsent(hotelName, hotel);
        return true;
    }

}
