public enum RentalType {
    HOURLY(1.0),
    DAILY(0.8),
    WEEKEND(0.7),
    NIGHT(0.6),
    PREMIUM(1.5),
    HOLIDAY(0.5),
    VIP(2.0);

    private double coefficient;

    RentalType(double coefficient) {this.coefficient = coefficient;}

    public double calculatePrice(double basePrice, int hours) {return basePrice * hours * coefficient;}

    public boolean isExpensive() {return coefficient > 1;}
}