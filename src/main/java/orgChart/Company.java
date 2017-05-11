package orgChart;

import java.util.*;

public class Company implements CompanyContract {

    private HashMap<Integer, Employee> employeesHashMap;

    public Company() {
        employeesHashMap = new HashMap<>();
    }

    public Employee getCEO() {
        for (Employee e: employeesHashMap.values()) {
            if (e.getPosition() == Position.CEO) {
                return e;
            }
        }
        return null;
    }

    public void addEmployee(Employee newEmployee) {
        
        if (employeesHashMap.keySet().contains(newEmployee.getId())) {
            System.out.println("Id is not unique! user not added!");
            return;
        }

        //Handle special case - CEO has no manager
        if (newEmployee.getPosition() == Position.CEO) {
            if (getCEO() != null) {
                System.out.println("This company already has 1 CEO, employee not added!");
                return;
            }
        } else {
            Employee employeeManager = newEmployee.getManager();
            employeeManager.addSubordinate(newEmployee);
            employeesHashMap.put(employeeManager.getId(), employeeManager);
        }

        //add employee to the ArrayList
        employeesHashMap.put(newEmployee.getId(), newEmployee);
    }

    public Employee getEmployee(int id) {
        return employeesHashMap.get(id);
    }

    public Collection<Employee> getAllEmployees() {
        return employeesHashMap.values();
    }

    public void promoteEmployee(Employee e) {

        //Special case - promoting to CEO
        if (e.getPosition() == Position.VicePresident) {
            if (getCEO() != null) {
                System.out.println("This company already has 1 CEO, employee not promoted!");
                return;
            }
            e.setPosition(Position.CEO);
        }
        else {
            Employee employeeManager = e.getManager();
            employeeManager.removeSubordinate(e);
            employeesHashMap.put(employeeManager.getId(), employeeManager);
            e.setManager(employeeManager.getManager());

            //It's important to notice employee becomes peer of his manager
            //so we cannot do e.getPosition - 1 but we have to assign manager's position
            //in case manager is 2 levels above e
            e.setPosition(employeeManager.getPosition());
        }

        employeesHashMap.put(e.getId(), e);
    }

    public void changeTeam(Employee e, Employee newManager) {

        //Changing teams to the same team shouldn't be allowed
        //This also fixes bug with employee changing teams while manager is on holiday
        if (e.getManager() == newManager) {
            System.out.println("Cannot change team to the same one! Not updating..");
            return;
        }

        //Changing teams to team with manager lower than e's position is not allowed
        //as it essentially means downgrading positions
        if (e.getPosition() < newManager.getPosition()) {
            System.out.println("Cannot change teams to respond to person with lower position!");
            return;
        }

        //oldManager loses him as subordinate
        e.getManager().removeSubordinate(e);
        employeesHashMap.put(e.getManager().getId(), e.getManager());

        //e starts responding to newManager
        e.setManager(newManager);
        newManager.addSubordinate(e);

        //most senior (based on the start date) from his subordinates is promoted (call him e_p)
        if (e.getSubordinates().size() != 0) {
            Employee mostSeniorSubordinate = getMostSeniorSubordinate(e);
            promoteEmployee(getMostSeniorSubordinate(e));

            //e_p takes all of the e's subordinates
            mostSeniorSubordinate = employeesHashMap.get(mostSeniorSubordinate.getId());
            mostSeniorSubordinate.addSubordinates(e.getSubordinates());

            //updating all of the e's subordinates to new manager
            for (Employee subordinate: e.getSubordinates()) {
                subordinate.setManager(mostSeniorSubordinate);
                employeesHashMap.put(subordinate.getId(), subordinate);
            }

            //e loses all of his subordinates
            e.removeAllSubordinates();

            employeesHashMap.put(mostSeniorSubordinate.getId(), mostSeniorSubordinate);
        }


        //update hashMap
        employeesHashMap.put(e.getId(), e);
        employeesHashMap.put(newManager.getId(), newManager);

    }

    public void sendOnHoliday(Employee e) {

        //CEO shouldn't go on holiday, who will run the company then?
        if (e.getPosition() == Position.CEO) {
            System.out.println("CEO cannot go on holidays, who will run the company then?");
            return;
        }

        //Subordinates start responding to e's manager
        Collection<Employee> subordinates = e.getSubordinates();
        for (Employee subordinate : subordinates) {
            subordinate.setManager(e.getManager());
            employeesHashMap.put(subordinate.getId(), subordinate);
        }

        //manager is taking over e's subordinates
        e.getManager().addSubordinates(subordinates);
        employeesHashMap.put(e.getManager().getId(), e.getManager());

        //e is going on holiday
        e.setOnHoliday(true);
        employeesHashMap.put(e.getId(), e);
    }

    public void backFromHoliday(Employee e) {

        Employee eManager = e.getManager();

        //Subordinates start responding back to e
        for (Employee subordinate : e.getSubordinates()) {

            //Unless the changed teams - in which case they
            //also changed managers
            if (subordinate.getManager() == eManager) {
                subordinate.setManager(e);
                eManager.removeSubordinate(subordinate);
                employeesHashMap.put(subordinate.getId(), subordinate);
            }
        }

        //Updating hashMap
        e.setOnHoliday(false);
        employeesHashMap.put(e.getId(), e);
        employeesHashMap.put(eManager.getId(), eManager);
    }

    public void printEligibleForPromotion(Collection<Employee> employees, int position) {
        switch (position) {
            case Position.Director:
                System.out.println("Eligible for VP position");
                for (Employee e : canBecomeVP(employeesHashMap.values())) {
                    System.out.println(e.toString());
                }
                break;
            case Position.Manager:
                System.out.println("Eligible for Director position");
                for (Employee e: canBecomeDirector(employeesHashMap.values())) {
                    System.out.println(e.toString());
                }
                break;
            default:
                System.out.println("Promotion rules for this position not defined!");
        }
    }

    public void printOrganisationStructure() {
        ArrayList<Employee> employees = new ArrayList<>(employeesHashMap.values());

        //Sorting by position
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.getPosition() > o2.getPosition()) {
                    return 1;
                } else if (o1.getPosition() == o2.getPosition()) {
                    return 0;
                } else {
                    return -1;
                }

            }
        });

        for (Employee e : employees) {
            System.out.println(e.toString());
        }
    }

    public void printPathToCEO(Employee e) {
        ArrayList<Employee> path = getPathToCEO(e);

        for (Employee employee : path) {
            System.out.println(employee.toString());
        }
    }

    /**
     * Efficient bottom-up function traversing graph
     * from employee to the CEO
     */
    private ArrayList<Employee> getPathToCEO(Employee e) {
        //Create an empty path and add employee
        ArrayList<Employee> path = new ArrayList<>();
        path.add(e);


        //If this employee is an CEO we found our path
        if (e.getPosition() == Position.CEO) {
            return path;
        }

        //Get manager, add to the path and assign
        //manager to manager of manager till we get to
        //Position.CEO. This pseudo-recursive function
        //traverse graph till it finds employee who responds
        //directly to CEO
        Employee manager = e.getManager();

        while (manager.getPosition() != Position.CEO) {
            path.add(manager);
            manager = manager.getManager();
        }

        //We need to add CEO to complete the path
        path.add(getCEO());

        return path;
    }

    /**
     *  Made public only for testing.
     *  This function could be made much more efficient if we'd
     *  decide to store getTotalNumberOfSubordinates(e) in employee object
     *  and update it on every change of the object. For employees list
     *  it makes more sense to use this approach though as we don't want to
     *  compromise IN approach and this function won't be run as frequently
     *  as addEmployee(e) or any updates on employees.
     */
    public ArrayList<Employee> canBecomeDirector(Collection<Employee> employees) {


        ArrayList<Employee> eligibleEmployees = new ArrayList<>();

        for (Employee e: employees) {

            //Conditions specified in requirements
            //Consider storing them separately in static fields
            //That make ease any changes made
            if (e.getPosition() == Position.Manager &&
                     getTotalNumberOfSubordinates(e) >= 20 &&
                     getTotalNumberOfSubordinatesAtPosition(e, Position.Manager) >= 2) {
                eligibleEmployees.add(e);
            }
        }

        if (eligibleEmployees.size() == 0) {
            System.out.println("No employees eligible for promotion to Director");
            return null;
        }

        Collections.sort(eligibleEmployees);

        return eligibleEmployees;
    }

    /**
     *  Made public only for testing.
     *  This function could be made much more efficient if we'd
     *  decide to store getTotalNumberOfSubordinates(e) in employee object
     *  and update it on every change of the object. For employees list
     *  it makes more sense to use this approach though as we don't want to
     *  compromise IN approach and this function won't be run as frequently
     *  as addEmployee(e) or any updates on employees.
     */
    public ArrayList<Employee> canBecomeVP(Collection<Employee> employees) {


        ArrayList<Employee> eligibleEmployees = new ArrayList<>();

        for (Employee e: employees) {

            //Conditions specified in requirements
            //Consider storing them separately in static fields
            //That make ease any changes made
            if (e.getPosition() == Position.Director &&
                    getTotalNumberOfSubordinates(e) >= 40  &&
                    getTotalNumberOfSubordinatesAtPosition(e, Position.Director) >= 4) {
                eligibleEmployees.add(e);
            }
        }

        if (eligibleEmployees.size() == 0) {
            System.out.println("No employees eligible for promotion to Vice President");
            return null;
        }

        Collections.sort(eligibleEmployees);

        return eligibleEmployees;
    }

    /**
     * It's a recursive method which uses quite a lot of memory
     * Recursive option has been used as it seems to be most elegant one.
     *
     * Another way would be to store information about totalNumberOfSubordinates
     * on every update of the employeesHashMap. Then retrieval would be O(1).
     * In this case arrays will never get to size of millions so it doesn't make
     * much difference.
     */
    private int getTotalNumberOfSubordinatesAtPosition(Employee e, int position) {



        //Initiate count at 0
        int count = 0;

        //Recursive finaliser - when no subordinates simply
        //return 0
        if (e.getSubordinates().size() == 0) {
            return 0;
        }

        //Recursive part. For each subordinate increase count by 1
        //And increase count by the number of subordinate's subordinates.
        for (Employee subordinate : e.getSubordinates()) {
            if (subordinate.getPosition() == position) {
                count++;
            }
            count += getTotalNumberOfSubordinatesAtPosition(subordinate, position);
        }
        return count;
    }

    /**
     * It's a recursive method which uses quite a lot of memory
     * Recursive option has been used as it seems to be most elegant one.
     *
     * Another way would be to store information about totalNumberOfSubordinates
     * on every update of the employeesHashMap. Then retrieval would be O(1).
     * In this case arrays will never get to size of millions so it doesn't make
     * much difference.
     */
    private int getTotalNumberOfSubordinates(Employee e) {
        //intialise counter to 0
        int count = 0;

        //Recursive finaliser - when no subordinates simply
        //return 0
        if (e.getSubordinates().size() == 0) {
            return 0;
        }
        //Recursive part. For each subordinate increase count by 1
        //And increase count by the number of subordinate's subordinates.
        for (Employee subordinate : e.getSubordinates()) {
            count++;
            count += getTotalNumberOfSubordinates(subordinate);
        }

        return count;
    }

    /**
     * According to Java documentation
     * complexity of this sorting vastly depends on
     * various factors but is likely to be O(nlogn)
     */
    private Employee getMostSeniorSubordinate(Employee e) {
        return Collections.min(e.getSubordinates());
    }

}
