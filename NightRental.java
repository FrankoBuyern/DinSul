public class NightRental extends Rental {
    public NightRental(int hours, double pricePerHour) {
        super(hours, pricePerHour);
    }

    @Override
    public double calculateRentalCost() {return getHours() * getPricePerHour() * 0.6;}
}