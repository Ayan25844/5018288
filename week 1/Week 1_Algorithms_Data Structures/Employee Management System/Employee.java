public class Employee {

    private String name;
    private double salary;
    private int employeeId;
    private String position;
    private static int idCounter = 0;

    public Employee(String name, double salary, String position) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.employeeId = ++idCounter;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return this.name;
    }

    public String getPosition() {
        return this.position;
    }

    public double getSalary() {
        return this.salary;
    }
}