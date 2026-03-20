import java.util.Objects;

public class Task {
    private String title;
    private DayOfWeek day;

    public Task(String title, DayOfWeek day) {
        this.title = title;this.day = day;}

    @Override
    public String toString() {
        return "Task{title='" + title + "', day=" + day + "}";}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return Objects.equals(title, task.title) && day == task.day;}

    @Override
    public int hashCode() {return Objects.hash(title, day);}
    public DayOfWeek getDay() {return day;}}