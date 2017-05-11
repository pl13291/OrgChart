package orgChart;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class CompanyTest {

    Company nvidia;

    @Before
    public void setUp() throws Exception {
        nvidia = new Company();

        //Set up employees (68 employees)
        Employee ceo = new Employee(1, "ceo", "ceo", Position.CEO, new Date(120), null);
        Employee vp = new Employee(2, "vp", "vp", Position.VicePresident, new Date(240), ceo);
        Employee d1 = new Employee(3, "d1", "d1", Position.Director, new Date(360), vp);
        Employee d2 = new Employee(4, "d2", "d2", Position.Director, new Date(480), vp);
        Employee d3 = new Employee(5, "d3", "d3", Position.Director, new Date(600), d2);
        Employee d4 = new Employee(6, "d4", "d4", Position.Director, new Date(720), d2);
        Employee d5 = new Employee(7, "d5", "d5", Position.Director, new Date(840), d2);
        Employee d6 = new Employee(8, "d6", "d6", Position.Director, new Date(960), d2);

        Employee m1 = new Employee(9, "m1", "m1", Position.Manager, new Date(1080), d3);
        Employee m2 = new Employee(10, "m2", "m2", Position.Manager, new Date(1200), d3);
        Employee m3 = new Employee(11, "m3", "m3", Position.Manager, new Date(1320), d3);
        Employee m4 = new Employee(12, "m4", "m4", Position.Manager, new Date(1440), d3);
        Employee m5 = new Employee(13, "m5", "m5", Position.Manager, new Date(1560), d4);
        Employee m6 = new Employee(14, "m6", "m6", Position.Manager, new Date(1680), d4);
        Employee m7 = new Employee(15, "m7", "m7", Position.Manager, new Date(1800), d4);
        Employee m8 = new Employee(16, "m8", "m8", Position.Manager, new Date(1920), d4);
        Employee m9 = new Employee(17, "m9", "m9", Position.Manager, new Date(2040), d5);
        Employee m10 = new Employee(18, "m10", "m10", Position.Manager, new Date(2160), d5);
        Employee m11 = new Employee(19, "m11", "m11", Position.Manager, new Date(2280), d5);

        Employee e1 = new Employee(20, "e1", "e1", Position.Employee, new Date(2400), m1);
        Employee e2 = new Employee(21, "e2", "e2", Position.Employee, new Date(2520), m1);
        Employee e3 = new Employee(22, "e3", "e3", Position.Employee, new Date(2640), m1);
        Employee e4 = new Employee(23, "e4", "e4", Position.Employee, new Date(2860), m1);
        Employee e5 = new Employee(24, "e5", "e5", Position.Employee, new Date(2980), m1);
        Employee e6 = new Employee(25, "e6", "e6", Position.Employee, new Date(3100), m1);
        Employee e7 = new Employee(26, "e7", "e7", Position.Employee, new Date(3220), m1);
        Employee e8 = new Employee(27, "e8", "e8", Position.Employee, new Date(3340), m1);
        Employee e9 = new Employee(28, "e9", "e9", Position.Employee, new Date(3460), m1);
        Employee e10 = new Employee(29, "e10", "e10", Position.Employee, new Date(3580), m1);
        Employee e11 = new Employee(30, "e11", "e11", Position.Employee, new Date(3700), m1);
        Employee e12 = new Employee(31, "e12", "e12", Position.Employee, new Date(3820), m1);
        Employee e13 = new Employee(32, "e13", "e13", Position.Employee, new Date(3940), m1);
        Employee e14 = new Employee(33, "e14", "e14", Position.Employee, new Date(4060), m1);
        Employee e15 = new Employee(34, "e15", "e15", Position.Employee, new Date(4180), m1);
        Employee e16 = new Employee(35, "e16", "e16", Position.Employee, new Date(4300), m1);
        Employee e17 = new Employee(36, "e17", "e17", Position.Employee, new Date(4420), m1);
        Employee e18 = new Employee(37, "e18", "e18", Position.Employee, new Date(4540), m1);
        Employee e19 = new Employee(38, "e19", "e19", Position.Employee, new Date(4660), m1);
        Employee e20 = new Employee(39, "e20", "e20", Position.Employee, new Date(4780), m1);

        Employee e21 = new Employee(40, "e21", "e21", Position.Employee, new Date(4900), m9);
        Employee e22 = new Employee(41, "e22", "e22", Position.Employee, new Date(5020), m9);
        Employee e23 = new Employee(42, "e23", "e23", Position.Employee, new Date(5140), m9);
        Employee e24 = new Employee(43, "e24", "e24", Position.Employee, new Date(5260), m9);

        Employee e25 = new Employee(44, "e25", "e25", Position.Employee, new Date(5380), m10);
        Employee e26 = new Employee(45, "e26", "e26", Position.Employee, new Date(5500), m10);
        Employee e27 = new Employee(46, "e27", "e27", Position.Employee, new Date(5620), m10);
        Employee e28 = new Employee(47, "e28", "e28", Position.Employee, new Date(5740), m10);
        Employee e29 = new Employee(48, "e29", "e29", Position.Employee, new Date(5860), m10);

        Employee e30 = new Employee(49, "e30", "e30", Position.Employee, new Date(5980), m11);
        Employee e31 = new Employee(50, "e31", "e31", Position.Employee, new Date(6100), m11);
        Employee e32 = new Employee(51, "e32", "e32", Position.Employee, new Date(6220), m11);
        Employee e33 = new Employee(52, "e33", "e33", Position.Employee, new Date(6340), m11);
        Employee e34 = new Employee(53, "e34", "e34", Position.Employee, new Date(6460), m11);
        Employee e35 = new Employee(54, "e35", "e35", Position.Employee, new Date(6580), m11);
        Employee e36 = new Employee(55, "e36", "e36", Position.Employee, new Date(5700), m11);
        Employee e37 = new Employee(56, "e37", "e37", Position.Employee, new Date(5820), m11);
        Employee e38 = new Employee(57, "e38", "e38", Position.Employee, new Date(5940), m11);
        Employee e39 = new Employee(58, "e39", "e39", Position.Employee, new Date(6060), m11);
        Employee e40 = new Employee(59, "e40", "e40", Position.Employee, new Date(6180), m11);
        Employee e41 = new Employee(60, "e41", "e41", Position.Employee, new Date(6300), m11);
        Employee e42 = new Employee(61, "e42", "e42", Position.Employee, new Date(6420), m11);
        Employee e43 = new Employee(62, "e43", "e43", Position.Employee, new Date(6540), m11);
        Employee e44 = new Employee(63, "e44", "e44", Position.Employee, new Date(6660), m11);
        Employee e45 = new Employee(64, "e45", "e45", Position.Employee, new Date(6780), m11);
        Employee e46 = new Employee(65, "e46", "e46", Position.Employee, new Date(6900), m11);
        Employee e47 = new Employee(66, "e47", "e47", Position.Employee, new Date(7020), m11);
        Employee e48 = new Employee(67, "e48", "e48", Position.Employee, new Date(7140), m11);
        Employee e49 = new Employee(68, "e49", "e49", Position.Employee, new Date(7260), m11);

        nvidia.addEmployee(ceo);
        nvidia.addEmployee(vp);

        nvidia.addEmployee(d1);
        nvidia.addEmployee(d2);
        nvidia.addEmployee(d3);
        nvidia.addEmployee(d4);
        nvidia.addEmployee(d5);
        nvidia.addEmployee(d6);

        nvidia.addEmployee(m1);
        nvidia.addEmployee(m2);
        nvidia.addEmployee(m3);
        nvidia.addEmployee(m4);
        nvidia.addEmployee(m5);
        nvidia.addEmployee(m6);
        nvidia.addEmployee(m7);
        nvidia.addEmployee(m8);
        nvidia.addEmployee(m9);
        nvidia.addEmployee(m10);
        nvidia.addEmployee(m11);

        nvidia.addEmployee(e1);
        nvidia.addEmployee(e2);
        nvidia.addEmployee(e3);
        nvidia.addEmployee(e4);
        nvidia.addEmployee(e5);
        nvidia.addEmployee(e6);
        nvidia.addEmployee(e7);
        nvidia.addEmployee(e8);
        nvidia.addEmployee(e9);
        nvidia.addEmployee(e10);
        nvidia.addEmployee(e11);
        nvidia.addEmployee(e12);
        nvidia.addEmployee(e13);
        nvidia.addEmployee(e14);
        nvidia.addEmployee(e15);
        nvidia.addEmployee(e16);
        nvidia.addEmployee(e17);
        nvidia.addEmployee(e18);
        nvidia.addEmployee(e19);
        nvidia.addEmployee(e20);
        nvidia.addEmployee(e21);
        nvidia.addEmployee(e22);
        nvidia.addEmployee(e23);
        nvidia.addEmployee(e24);
        nvidia.addEmployee(e25);
        nvidia.addEmployee(e26);
        nvidia.addEmployee(e27);
        nvidia.addEmployee(e28);
        nvidia.addEmployee(e29);
        nvidia.addEmployee(e30);
        nvidia.addEmployee(e31);
        nvidia.addEmployee(e32);
        nvidia.addEmployee(e33);
        nvidia.addEmployee(e34);
        nvidia.addEmployee(e35);
        nvidia.addEmployee(e36);
        nvidia.addEmployee(e37);
        nvidia.addEmployee(e38);
        nvidia.addEmployee(e39);
        nvidia.addEmployee(e40);
        nvidia.addEmployee(e41);
        nvidia.addEmployee(e42);
        nvidia.addEmployee(e43);
        nvidia.addEmployee(e44);
        nvidia.addEmployee(e45);
        nvidia.addEmployee(e46);
        nvidia.addEmployee(e47);
        nvidia.addEmployee(e48);
        nvidia.addEmployee(e49);

    }

    @After
    public void tearDown() throws Exception {
        nvidia = new Company();
    }

    @Test
    public void getCEO() throws Exception {
        //CEO should have id = 1
        Assert.assertEquals(nvidia.getCEO().getId(), 1);

        //CEO shouldn't have a manager
        Assert.assertNull(nvidia.getCEO().getManager());

        //CEO should have numerical value of position equal to 0 which is also equal to Position.CEO
        Assert.assertEquals(nvidia.getCEO().getPosition(), 0);
        Assert.assertEquals(nvidia.getCEO().getPosition(), Position.CEO);

    }

    @Test
    public void addEmployee() throws Exception {

        int employeesNumber = nvidia.getAllEmployees().size();
        int subordinatesNumber = nvidia.getCEO().getSubordinates().size();

        Employee newEmployee = new Employee(69, "e69", "e69", Position.Employee, new Date(), nvidia.getCEO());

        nvidia.addEmployee(newEmployee);

        //Adding employee should increase total number of employees in the company by 1
        Assert.assertNotEquals(employeesNumber, nvidia.getAllEmployees().size());
        Assert.assertEquals(employeesNumber + 1, nvidia.getAllEmployees().size());

        //Adding employee should increase total number of subordinates for his manager => CEO in this case by 1
        Assert.assertEquals(nvidia.getEmployee(newEmployee.getId()).getManager().getSubordinates().size(), subordinatesNumber + 1);

        //newEmployee should have a manager - CEO
        Assert.assertEquals(nvidia.getEmployee(newEmployee.getId()).getManager(), nvidia.getCEO());

        //newEmployee should be subordinate of his manager
        Assert.assertEquals(true, nvidia.getEmployee(newEmployee.getManager().getId()).getSubordinates().contains(newEmployee));

        //newEmployee should have position Employee, which should also be equal to int 4
        Assert.assertEquals(Position.Employee, nvidia.getEmployee(newEmployee.getId()).getPosition());
        Assert.assertEquals(4, nvidia.getEmployee(newEmployee.getId()).getPosition());

        //Adding threadSleep of 1ms to prevent newEmployee and newEmployee2 to have the same date.
        //It is necessary as there's no synchronization.
        //Remove when synchronization implemented.
        Thread.sleep(1);

        //newEmployee2's startDate should be the earliest (as it's epoch we're looking for MAX value)
        Employee newEmployee2 = new Employee(70, "e70", "e70", Position.Employee, new Date(), nvidia.getCEO());
        nvidia.addEmployee(newEmployee2);
        Assert.assertEquals(nvidia.getEmployee(newEmployee2.getId()), Collections.max(nvidia.getAllEmployees()));

    }

    @Test
    public void getEmployee() throws Exception {

        //getEmployee with id 1 should return CEO
        Assert.assertEquals(nvidia.getEmployee(1), nvidia.getCEO());

        //getEmployee with id greater than newest employee should return null
        Assert.assertNull(nvidia.getEmployee(Integer.MAX_VALUE));

    }

    @Test
    public void getAllEmployees() throws Exception {

        //getAllEmployees should return collection containing all employees
        for (Employee e : nvidia.getAllEmployees()) {
            Assert.assertNotNull(nvidia.getEmployee(e.getId()));
        }

        //nvidia should have 68 employees
        Assert.assertEquals(nvidia.getAllEmployees().size(), 68);
    }

    @Test
    public void promoteEmployee() throws Exception {

        //employee with id 39 is promoted.
        nvidia.promoteEmployee(nvidia.getEmployee(39));

        //should become a peer of his former manager (employee with id 9).
        Assert.assertEquals(nvidia.getEmployee(39).getPosition(), nvidia.getEmployee(9).getPosition());

        //his position should change to level up
        Assert.assertNotEquals(nvidia.getEmployee(39).getPosition(), Position.Employee);
        Assert.assertEquals(nvidia.getEmployee(39).getPosition(), nvidia.getEmployee(9).getPosition());

        //should have new manager - manager of his previous manager
        Assert.assertEquals(nvidia.getEmployee(39).getManager(), nvidia.getEmployee(9).getManager());

        //there can be only 1 CEO so VP cannot be promoted
        //nvidia employee with id 2 is VP
        nvidia.promoteEmployee(nvidia.getEmployee(2));
        Assert.assertEquals(nvidia.getCEO(), nvidia.getEmployee(1));
    }

    @Test
    public void changeTeam() throws Exception {
//        An employee can move to another team within the organisation. When moving to
//        a different team, an employee starts reporting to a new manager, without
//        transferring his past subordinates to the new team. Instead, the most senior
//        (based on start date) of his past subordinates should be promoted to manage the
//        employee’s former team.

        //most senior of m10 subordinates should be e25
        Assert.assertEquals(Collections.min(nvidia.getEmployee(18).getSubordinates()), nvidia.getEmployee(44));

        //e25 position should be Position.Employee (before promotion)
        Assert.assertEquals(nvidia.getEmployee(44).getPosition(), Position.Employee);

        //e25 shouldn't have any subordinates now
        Assert.assertEquals(nvidia.getEmployee(44).getSubordinates().size(), 0);

        //Employee m10 (id = 18) who responds to d5 (id = 7) changes teams to respond to d6 (id = 8)
        //most senior of m10 is e25 who should be promoted and manage e26-e29
        nvidia.changeTeam(nvidia.getEmployee(18), nvidia.getEmployee(8));

        //8 should be subordinate of 18
        Assert.assertEquals(nvidia.getEmployee(18).getManager(), nvidia.getEmployee(8));
        Assert.assertEquals(nvidia.getEmployee(8).getSubordinates().contains(nvidia.getEmployee(18)), true);

        //18 shouldn't be a subordinate of 7 anymore
        Assert.assertNotEquals(nvidia.getEmployee(18).getManager(), nvidia.getEmployee(7));
        Assert.assertEquals(nvidia.getEmployee(7).getSubordinates().contains(nvidia.getEmployee(18)), false);

        //e25 should have more than 0 subordinates now
        Assert.assertNotEquals(nvidia.getEmployee(44).getSubordinates().size(), 0);

        //e25 should have exactly 4 subordinates
        Assert.assertEquals(nvidia.getEmployee(44).getSubordinates().size(), 4);

        //e26 should respond to e25 now
        Assert.assertEquals(nvidia.getEmployee(45).getManager(), nvidia.getEmployee(44));

        //ceo who is position 0 cannot change teams to respond to lower position
        nvidia.changeTeam(nvidia.getCEO(), nvidia.getEmployee(3));

        //ceo should still be at position 1
        Assert.assertEquals(nvidia.getCEO(), nvidia.getEmployee(1));

        //employee with id 3 shouldn't have CEO as a subordinate
        Assert.assertNotEquals(nvidia.getEmployee(3).getSubordinates().contains(nvidia.getCEO()), true);

    }

    @Test
    public void sendOnHoliday() throws Exception {
//        When an employee goes on holidays, all his subordinates start reporting to the
//        employee's manager temporarily.

        Assert.assertEquals(nvidia.getEmployee(17).getSubordinates().size(), 4);
        Assert.assertEquals(nvidia.getEmployee(17).getSubordinates().contains(nvidia.getEmployee(40)), true);

        //m9 (id = 17) goes on holiday. His subordinates (e21-e24) (id = 40-43) should start responding to m9's manager d5 (id = 7)
        nvidia.sendOnHoliday(nvidia.getEmployee(17));

        //e21 (id=40) should have a new manager (id=7)
        Assert.assertEquals(nvidia.getEmployee(7).getSubordinates().contains(nvidia.getEmployee(40)), true);

        //e24 (id=43) should have a new manager (id=7)
        Assert.assertEquals(nvidia.getEmployee(7).getSubordinates().contains(nvidia.getEmployee(40)), true);

        //sending ceo on holiday should fail
        nvidia.sendOnHoliday(nvidia.getCEO());
        Assert.assertNotNull(nvidia.getEmployee(2).getManager());
    }

    @Test
    public void backFromHoliday() throws Exception {
//        When an employee comes back from holidays, all his subordinates come back to
//        report to him, unless they have moved teams.

        //Employee goes on holiday and instantly returns. No changes should take place
        nvidia.sendOnHoliday(nvidia.getEmployee(17));
        nvidia.backFromHoliday(nvidia.getEmployee(17));

        Assert.assertEquals(nvidia.getEmployee(17).getSubordinates().size(), 4);
        Assert.assertEquals(nvidia.getEmployee(41).getManager(), nvidia.getEmployee(17));

        //If employee changes teams while manager is on holiday they shouldn't come back to the manager
        //after he comes back from holiday.
        nvidia.sendOnHoliday(nvidia.getEmployee(17));
        nvidia.changeTeam(nvidia.getEmployee(41), nvidia.getEmployee(2));
        nvidia.backFromHoliday(nvidia.getEmployee(17));

        Assert.assertEquals(nvidia.getEmployee(41).getManager(), nvidia.getEmployee(2));
        Assert.assertNotEquals(nvidia.getEmployee(17).getSubordinates().contains(41), true);

    }

    @Test
    public void canBecomeDirector() throws Exception {
        //Currently nvidia shouldn't have any managers ready for promotion
        Assert.assertNull(nvidia.canBecomeDirector(nvidia.getAllEmployees()));

        //Adding managers to make some managers ready to become Director
        Employee test1 = new Employee(75, "test1", "test1", Position.Manager, new Date(10000), nvidia.getEmployee(9));
        Employee test2 = new Employee(76, "test2", "test2", Position.Manager, new Date(11000), nvidia.getEmployee(9));

        nvidia.addEmployee(test1);
        nvidia.addEmployee(test2);

        Assert.assertNotNull(nvidia.canBecomeDirector(nvidia.getAllEmployees()));
        Assert.assertEquals(nvidia.canBecomeDirector(nvidia.getAllEmployees()).size(), 1);

        //Adding more managers to make 2 managers ready to become Director
        Employee test3 = new Employee(78, "test3", "test3", Position.Manager, new Date(10000), nvidia.getEmployee(19));
        Employee test4 = new Employee(79, "test4", "test4", Position.Manager, new Date(11000), nvidia.getEmployee(19));

        nvidia.addEmployee(test3);
        nvidia.addEmployee(test4);

        Assert.assertEquals(nvidia.canBecomeDirector(nvidia.getAllEmployees()).size(), 2);

        //Making sure canBecomeDirector returns managers in the order of startDate
        Assert.assertEquals(nvidia.canBecomeDirector(nvidia.getAllEmployees()).get(0), nvidia.getEmployee(9));
    }

    @Test
    public void canBecomeVP() throws Exception {
        //Currently nvidia should have 1 employee eligible for promotion - id = 4
       Assert.assertEquals(nvidia.canBecomeVP(nvidia.getAllEmployees()).size(), 1);
       Assert.assertEquals(nvidia.canBecomeVP(nvidia.getAllEmployees()).contains(nvidia.getEmployee(4)), true);

    }

}