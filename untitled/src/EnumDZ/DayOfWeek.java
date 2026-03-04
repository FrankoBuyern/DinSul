package EnumDZ;

public enum DayOfWeek {
    MONDAY("Понедельник", true),
    TUESDAY("Вторник", true),
    WEDNESDAY("Среда", true),
    THURSDAY("Четверг", true),
    FRIDAY("Пятница", true),
    SATURDAY("Суббота", false),
    SUNDAY("Воскресенье", false);

    private String russianName;
    private boolean workingDay;

    DayOfWeek(String russianName, boolean workingDay) {
        this.russianName = russianName;
        this.workingDay = workingDay;
    }

    public String getRussianName() {return russianName;}
    public boolean isWorkingDay() {return workingDay;}
    public void printInfo() {System.out.println(russianName + " рабочий день: " + workingDay);}
}
