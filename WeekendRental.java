public class WeekendRental extends Rental {
    public WeekendRental(int hours, double pricePerHour) {
        super(hours, pricePerHour);
    }

    @Override
    public double calculateRentalCost() {return getHours() * getPricePerHour() * 0.7;}
}