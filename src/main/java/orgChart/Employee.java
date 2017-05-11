package orgChart;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Employee implements EmployeeContract, Comparable<Employee> {

    private int id;
    private String firstName;
    private String lastName;
    private int position;
    private Date startDate;
    private Collection<Employee> subordinates = new ArrayList<>();
    private Employee manager;
    private boolean isOnHoliday;

    public Employee() {}

    public Employee(int id, String firstName, String lastName, int position, Date startDate, Employee manager) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.startDate = startDate;
        this.manager = manager;
        this.isOnHoliday = false;
    }

    public int getId() {
        return id;
    }

    public void setManager(Employee e) {
        if (position == Position.CEO) {
            System.out.println("CEO cannot have a manager! Manager not updated!");
        } else {
            this.manager = e;
        }
    }

    public Employee getManager() {
        return manager;
    }

    public void addSubordinate(Employee subordinate) {
        this.subordinates.add(subordinate);
    }

    public void addSubordinates(Collection<Employee> subordinates) {
        this.subordinates.addAll(subordinates);
    }

    public void removeSubordinate(Employee subordinate) {
        if (subordinates.contains(subordinate)) {
            subordinates.remove(subordinate);
        } else {
            System.out.println("Subordinate not found in Manager's subordinates! Subordinates not updated!");
        }
    }

    public void removeAllSubordinates() {
        subordinates = new ArrayList<>();
    }

    public Collection<Employee> getSubordinates() {
        return subordinates;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setOnHoliday(boolean isOnHoliday) {
        this.isOnHoliday = isOnHoliday;
    }

    public boolean isOnHoliday() { return isOnHoliday; }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position=" + position +
                ", startDate=" + startDate +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        return this.getStartDate().compareTo(o.getStartDate());
    }
}
