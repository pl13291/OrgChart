package orgChart;

import java.util.Collection;

public interface CompanyContract {

    /**
     * Get's CEO of the company
     */
    Employee getCEO();

    /**
     * Adds Employee to the company
     * While not implemented here, creating new factory class
     * EmployeeFactory is recommended which translates human input
     * (from GUI for example) and creates Employee e to be added is recommended.
     */
    void addEmployee(Employee e);

    /**
     * Return employee object at given id
     */
    Employee getEmployee(int id);

    /**
     * Return collection of all employees
     */
    Collection<Employee> getAllEmployees();

    /**
     * When an employee is promoted, he effectively becomes a peer of his former
     * manager. Unfortunately, there is a single CEO for the company, so attempting a
     * promotion of one of the CEO’s subordinates should fail.
     */
    void promoteEmployee(Employee e);

    /**
     * An employee can move to another team within the organisation. When moving to
     a different team, an employee starts reporting to a new manager, without
     transferring his past subordinates to the new team. Instead, the most senior
     (based on start date) of his past subordinates should be promoted to manage the
     employee’s former team.
     */
    void changeTeam(Employee e, Employee newManager);

    /**
     When an employee goes on holidays, all his subordinates start reporting to the
     employee's manager temporarily.
     */
    void sendOnHoliday(Employee e);

    /**
     * When an employee comes back from holidays, all his subordinates come back to
     report to him, unless they have moved teams.
     */
    void backFromHoliday(Employee e);

    /**
     * An employee is ready to become a Director if he has at least 20 employees in his
     organisation (people subordinate to him, and his subordinates), including at least
     2 managers (people that also have direct reports).
     ○ An employee is ready to become a Vice President if he has more than 40
     employees in his organisation (people subordinate to him, and his subordinates),
     including at least 4 directors.
     ○ If there are more than one candidates, they are prioritised by the time they’ve
     worked in the organisation.
     */
    void printEligibleForPromotion(Collection<Employee> employees, int position);

    /**
     * Printing the whole organisation tree, starting with the CEO, and then printing all
     other employees one level at a time (i.e. print level 1, then level 2, then level 3, etc).
     */
    void printOrganisationStructure();

    /**
     * Given an employee, prints the path from the CEO to the employee.
     */
    void printPathToCEO(Employee e);

}
