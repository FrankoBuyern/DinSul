public class PremiumRental extends Rental {
    public PremiumRental(int hours, double pricePerHour) {
        super(hours, pricePerHour);
    }

    @Override
    public double calculateRentalCost() {return getHours() * getPricePerHour() * 1.5;}
}