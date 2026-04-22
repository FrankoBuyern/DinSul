public class HourlyRental extends Rental {
    public HourlyRental(int hours, double pricePerHour) {
        super(hours, pricePerHour);
    }

    @Override
    public double calculateRentalCost() {return getHours() * getPricePerHour();}
}