import java.util.Objects;

public class Company {
    private String name;

    public Company(String name) {this.name = name;}

    @Override
    public String toString() {
        return "Company{name='" + name + "'}";}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Company)) return false;
        Company company = (Company) o;
        return Objects.equals(name, company.name);}

    @Override
    public int hashCode() {return Objects.hash(name);}}