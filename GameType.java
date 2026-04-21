public enum GameType {
    FORTNITE("Battle Royale", 0),
    BRAWL_STARS("Mobile MOBA", 0),
    CSGO("FPS Shooter", 15),
    HOI4("Strategy", 40),
    RUST("Survival", 20),
    DOTA2("MOBA", 0),
    MINECRAFT("Sandbox", 30);

    private String genre;
    private double basePrice;

    GameType(String genre, double basePrice) {
        this.genre = genre;
        this.basePrice = basePrice;
    }

    public String getGenre() {return genre;}

    public double getBasePrice() {return basePrice;}

    public boolean isFree() {return basePrice == 0;}
}