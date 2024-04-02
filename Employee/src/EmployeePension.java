

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EmployeePension {
    private static List<Employee> employees = new ArrayList<>();
    private static List<PensionPlan> pensionPlans = new ArrayList<>();

    public static void main(String[] args) {
        initializeSampleData();
        printAllEmployeesInJson();
        printMonthlyUpcomingEnrolleesInJson();
        
    }

    private static void initializeSampleData() {
        employees.add(new Employee(1, "Daniel", "Agar", LocalDate.of(2018, 1, 17), 105945.50));
        employees.add(new Employee(2, "Bernard", "Shaw", LocalDate.of(2018, 10, 20), 90750.00));
        employees.add(new Employee(3, "Carly", "Agar", LocalDate.of(2014, 05, 16), 842000.75));
        employees.add(new Employee(4, "Wesley", "Schneider", LocalDate.of(2018, 11, 3), 74500.00));

        pensionPlans.add(new PensionPlan("EX1089", LocalDate.of(2023,01,17), 100.00));
        pensionPlans.add(new PensionPlan("SM2307", LocalDate.of(2019,11,04), 1555.50));

        assignPension(1, "EX1089");
        assignPension(3, "SM2307");
     
    }
    private static void assignPension(long employeeId, String planReferenceNumber ){
           Employee assignedEmployee = employees.stream()
    .filter(e -> e.getEmployeeId() == employeeId)
    .findFirst()
    .orElse(null);

            PensionPlan assignedPensionPlan = pensionPlans.stream()
    .filter(p -> p.getPlanReferenceNumber().equals(planReferenceNumber))
    .findFirst()
    .orElse(null);

    if (assignedEmployee != null && assignedPensionPlan != null) {
    assignedEmployee.setPensionPlan(assignedPensionPlan); 
    assignedPensionPlan.setEmployee(assignedEmployee); 
    System.out.println("Assigned " + assignedEmployee.getFirstName() + " " + assignedEmployee.getLastName() + 
        " to Pension Plan " + assignedPensionPlan.getPlanReferenceNumber());
} else {
    System.out.println("Either Employee or Pension Plan not found.");
}
    }

   

    

     private static void printAllEmployeesInJson() {
        employees.stream()
                 .sorted(Comparator.comparing(Employee::getLastName)
                         .thenComparing(Employee::getYearlySalary).reversed())
                 .forEach(employee -> System.out.println(employee.toJson()));
    }


    private static void printMonthlyUpcomingEnrolleesInJson() {
        LocalDate nextMonthFirstDay = LocalDate.now().plusMonths(1).with(TemporalAdjusters.firstDayOfMonth());
        LocalDate nextMonthLastDay = nextMonthFirstDay.with(TemporalAdjusters.lastDayOfMonth());

        employees.stream()
                 .filter(e -> e.getPensionPlan() == null && 
                              e.getEmploymentDate().plusYears(5).isAfter(nextMonthFirstDay.minusDays(1)) &&
                              e.getEmploymentDate().plusYears(5).isBefore(nextMonthLastDay.plusDays(1)))
                 .sorted(Comparator.comparing(Employee::getEmploymentDate))
                 .forEach(employee -> System.out.println(employee.toJson()));
    }
    

}

