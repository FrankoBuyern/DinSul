class Box implements Mail {
    private double weight;
    private double price;
    private DeliveryType deliveryType;

    public Box(double weight, double price, DeliveryType deliveryType) {
        this.weight = weight;
        this.price = price;
        this.deliveryType = deliveryType;
    }

    public double getWeight() { return weight; }
    public double getPrice() { return price; }
    public DeliveryType getDeliveryType() { return deliveryType; }
}