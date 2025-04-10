import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

abstract class Employee {
    private int empId;
    private String name;
    private String gender;
    private double basicSalary;
    private String dateOfJoining;

    public Employee(int empId, String name, String gender, double basicSalary, String dateOfJoining) {
        this.empId = empId;
        this.name = name;
        this.gender = gender;
        this.basicSalary = basicSalary;
        this.dateOfJoining = dateOfJoining;
    }

    public abstract void displayInformation();

    public double calculateGrossSalary(double TA, double DA, double HRA) {
        return basicSalary + TA + DA + HRA;
    }

    public double calculateGrossSalary(double TA, double DA, double HRA, double specialAllowance) {
        return basicSalary + TA + DA + HRA + specialAllowance;
    }

    public String getName() {
        return name;
    }

    public void changeName(String newName) throws NameNotFoundException {
        if (newName == null) {
            throw new NameNotFoundException("Name Not Found");
        }
        this.name = newName;
    }
}

class Sales extends Employee {
    private int totalSales;

    public Sales(int empId, String name, String gender, double basicSalary, String dateOfJoining, int totalSales) {
        super(empId, name, gender, basicSalary, dateOfJoining);
        this.totalSales = totalSales;
    }

    public int getTotalSales() {
        return totalSales;
    }
}

class Production extends Employee {
    private int totalProduction;

    public Production(int empId, String name, String gender, double basicSalary, String dateOfJoining, int totalProduction) {
        super(empId, name, gender, basicSalary, dateOfJoining);
        this.totalProduction = totalProduction;
    }

    
    }

    public class int getTotalProduction() {
        return totalProduction;
    }


class NameNotFoundException extends Exception {
    public NameNotFoundException(String message) {
        super(message);
    }
}

public class OOPSTA1 {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        // Create 10 employees
        employees.add(new Sales(1, "John Doe", "Male", 5000, "2022-01-01", 10000));
        employees.add(new Production(2, "Jane Smith", "Female", 4000, "2022-02-01", 500));
        employees.add(new Sales(3, "Michael Johnson", "Male", 5500, "2022-03-01", 15000));
        employees.add(new Production(4, "Emily Davis", "Female", 4500, "2022-04-01", 800));
        employees.add(new Sales(5, "David Brown", "Male", 5200, "2022-05-01", 12000));
        employees.add(new Production(6, "Olivia Wilson", "Female", 4300, "2022-06-01", 600));
        employees.add(new Sales(7, "James Miller", "Male", 4800, "2022-07-01", 9000));
        employees.add(new Production(8, "Sophia Taylor", "Female", 4100, "2022-08-01", 700));
        employees.add(new Sales(9, "Daniel Anderson", "Male", 5300, "2022-09-01", 13000));
        employees.add(new Production(10, "Ava Martinez", "Female", 4200, "2022-10-01", 550));

        // Display information of all employees
        for (Employee employee : employees) {
            employee.displayInformation();
            System.out.println();
        }

        // Calculate and display the highest paid employee
        Employee highestPaidEmployee = getHighestPaidEmployee(employees);
        System.out.println("Highest Paid Employee:");
        highestPaidEmployee.displayInformation();

        // Change the name of an employee
        try {
            Employee employee = findEmployeeByName(employees, "John Doe");
            if (employee != null) {
                employee.changeName("John Smith");
                System.out.println("\nEmployee name changed successfully.");
            } else {
                throw new NameNotFoundException("Name Not Found");
            }
        } catch (NameNotFoundException e) {
            System.out.println("\n" + e.getMessage());
        }
    }

    public static Employee getHighestPaidEmployee(List<Employee> employees) {
        Employee highestPaidEmployee = null;
        double highestGrossSalary = 0;

        for (Employee employee : employees) {
            double grossSalary = employee.calculateGrossSalary(100, 200, 300);
            if (grossSalary > highestGrossSalary) {
                highestGrossSalary = grossSalary;
                highestPaidEmployee = employee;
            }
        }

        return highestPaidEmployee;
    }

    public static Employee findEmployeeByName(List<Employee> employees, String name) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        return null;
    }
}
