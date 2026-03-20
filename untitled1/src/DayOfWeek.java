public enum DayOfWeek {
    MONDAY("Рабочий"),
    TUESDAY("Рабочий"),
    WEDNESDAY("Рабочий"),
    THURSDAY("Рабочий"),
    FRIDAY("Рабочий"),
    SATURDAY("Выходной"),
    SUNDAY("Выходной");
    private final String type;

    DayOfWeek(String type) {this.type = type;}

    public boolean isWeekend() {
        return this == SATURDAY || this == SUNDAY;}

    public String getType() {return type;}}