package orgChart;

import java.util.Collection;
import java.util.Date;

public interface EmployeeContract {

    int getId();

    Employee getManager();

    void setManager(Employee e);

    void addSubordinate(Employee subordinate);

    void addSubordinates(Collection<Employee> subordinates);

    void removeSubordinate(Employee subordinate);

    void removeAllSubordinates();

    Collection<Employee> getSubordinates();

    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);

    int getPosition();

    void setPosition(int position);

    Date getStartDate();

    void setStartDate(Date startDate);

    void setOnHoliday(boolean isOnHoliday);

    boolean isOnHoliday();
}
