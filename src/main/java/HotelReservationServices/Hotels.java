package HotelReservationServices;

public class Hotels {

    private String hotelName;
    private int hotelRate;
    private int weekdayRate, weekendRate;

    public Hotels(String hotelName, int hotelRate) {
        this.hotelName = hotelName;
        this.hotelRate = hotelRate;
    }

    public Hotels(String hotelName, int weekdayRate, int weekendRate) {
        this.hotelName = hotelName;
        this.weekdayRate = weekdayRate;
        this.weekendRate = weekendRate;
    }

    public String getHotelName() {
        return hotelName;
    }

    public int getHotelRate() {
        return hotelRate;
    }

    @Override
    public String toString() {
        return "Hotels{" +
                "hotelName='" + hotelName + '\'' +
                ", hotelRate=" + hotelRate +
                '}';
    }
}
