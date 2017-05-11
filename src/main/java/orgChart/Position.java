package orgChart;

public class Position {

    /**
     * New class with static's created as of requirement.
     * Alternatively enum field could be created but as of numerical
     * requirement this way is more clear as enums are objects
     * and do not directly translate to int (spec requirement)
     */

    public static final int CEO = 0;
    public static final int VicePresident = 1;
    public static final int Director = 2;
    public static final int Manager = 3;
    public static final int Employee = 4;

}
