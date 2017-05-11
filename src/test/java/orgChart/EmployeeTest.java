package orgChart;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class EmployeeTest {

    Employee ceo;
    Employee e1;
    Employee e2;
    Employee e3;

    @Before
    public void setUp() throws Exception {
        ceo = new Employee(1, "Pawel", "Laskowski", Position.CEO, new Date(1494263321), null);
        e1 = new Employee(2,"Paw", "Paw", Position.VicePresident, new Date(1494263358), ceo);
        e2 = new Employee(3,"PawPaw", "PawPaw", Position.Director, new Date(1494263370), e1);
        e3 = new Employee(4,"PawPawPaw", "PawPawPaw", Position.Director, new Date(1494263380), e1);
    }

    @After
    public void tearDown() throws Exception {
        ceo = null;
        e1 = null;
        e2 = null;
        e3 = null;
    }

    @Test
    public void getId() throws Exception {
        Assert.assertEquals(ceo.getId(), 1);
        Assert.assertNotEquals(e1.getId(), 1);
        Assert.assertEquals(e3.getId(), 4);
    }

    @Test
    public void setManager() throws Exception {
        Assert.assertNull(ceo.getManager());

        //Check setting manager for normal employees
        Assert.assertEquals(e2.getManager(), e1);
        e2.setManager(ceo);
        Assert.assertEquals(e2.getManager(), ceo);

        //Makes sure you cannot set manager to CEO
        ceo.setManager(e1);
        Assert.assertNull(ceo.getManager());

    }

    @Test
    public void getManager() throws Exception {
        //Manager for CEO should return null
        Assert.assertNull(ceo.getManager());

        //Ceo is manager of e1
        Assert.assertEquals(e1.getManager(), ceo);

        //E1 is manager of e3
        Assert.assertEquals(e3.getManager(), e1);
    }

    @Test
    public void addSubordinate() throws Exception {
        //CEO shouldn't have any subordinates
        Assert.assertEquals(ceo.getSubordinates().size(), 0);

        //e1 should be subordinate of ceo
        ceo.addSubordinate(e1);

        Assert.assertEquals(ceo.getSubordinates().size(), 1);
        Assert.assertEquals(ceo.getSubordinates().contains(e1), true);
    }

    @Test
    public void addSubordinates() throws Exception {
        //e1 shouldn't have any subordinates
        Assert.assertEquals(e1.getSubordinates().size(), 0);

        //e2 and e3 should be subordinate to e1
        List<Employee> subordinates = Arrays.asList(e2,e3);
        e1.addSubordinates(subordinates);

        //e1 should have 2 subordinates now - e2 and e3
        Assert.assertEquals(e1.getSubordinates().size(), 2);
        Assert.assertEquals(e1.getSubordinates().contains(e2), true);
        Assert.assertEquals(e1.getSubordinates().contains(e3), true);

    }

    @Test
    public void removeSubordinate() throws Exception {
        ceo.addSubordinate(e1);

        //CEO should have e1 as a subordinate
        Assert.assertEquals(ceo.getSubordinates().contains(e1), true);

        ceo.removeSubordinate(e1);

        //CEO shouldn't have e1 as a subordinate
        Assert.assertEquals(ceo.getSubordinates().contains(e1), false);

        //Removing subordinate who isn't in the list shouldn't affect the list
        ceo.removeSubordinate(e2);

        Assert.assertEquals(ceo.getSubordinates().size(), 0);
        Assert.assertEquals(ceo.getSubordinates().contains(e2), false);
    }

    @Test
    public void removeAllSubordinates() throws Exception {
        ceo.addSubordinate(e1);
        ceo.addSubordinate(e2);

        //CEO should have 2 subordinates
        Assert.assertEquals(ceo.getSubordinates().size(), 2);

        ceo.removeAllSubordinates();

        //CEO shouldn't have any subordinates
        Assert.assertEquals(ceo.getSubordinates().size(), 0);
    }

    @Test
    public void getSubordinates() throws Exception {
        //Add 2 subordinates to CEO
        ceo.addSubordinate(e1);
        ceo.addSubordinate(e2);

        //Get subordinates should have 2 entries
        Assert.assertEquals(ceo.getSubordinates().size(), 2);

        //e1 and e2 should be returned by getSubordinates
        Assert.assertEquals(ceo.getSubordinates().contains(e1), true);
        Assert.assertEquals(ceo.getSubordinates().contains(e2), true);

    }

    @Test
    public void getFirstName() throws Exception {
        //CEO first name should be Pawel
        Assert.assertEquals(ceo.getFirstName(), "Pawel");
    }

    @Test
    public void setFirstName() throws Exception {

        Assert.assertNotEquals(ceo.getFirstName(), "tester");

        //CEO name should be tester
        ceo.setFirstName("tester");
        Assert.assertEquals(ceo.getFirstName(), "tester");
    }

    @Test
    public void getLastName() throws Exception {
        //CEO last name should be Laskowski
        Assert.assertEquals(ceo.getLastName(), "Laskowski");
    }

    @Test
    public void setLastName() throws Exception {
        ceo.setLastName("Tester");
        Assert.assertEquals(ceo.getLastName(), "Tester");
    }

    @Test
    public void getPosition() throws Exception {
        //ceo position should be Position.CEO
        Assert.assertEquals(ceo.getPosition(), Position.CEO);

        //ceo position should also be a numerical value 0
        Assert.assertEquals(ceo.getPosition(), 0);
    }

    @Test
    public void setPosition() throws Exception {
        //set e1 to be CEO
        e1.setPosition(Position.CEO);

        //e1 should be a CEO
        Assert.assertEquals(e1.getPosition(), Position.CEO);
    }

    @Test
    public void getStartDate() throws Exception {
        Assert.assertEquals(ceo.getStartDate(), new Date(1494263321));
    }

    @Test
    public void setStartDate() throws Exception {
        //Change ceo startDate
        ceo.setStartDate(new Date(135));

        Assert.assertEquals(ceo.getStartDate(), new Date(135));
    }

}