

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee {

    private long employeeId;
    private String firstName;
    private String lastName;
    private LocalDate employmentDate;
    private double yearlySalary;
    private PensionPlan pensionPlan;

    public Employee(){

    }
    public Employee(long employeeId, String firstName, String lastName, LocalDate employmentDate, double yearlySalary){
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.employmentDate = employmentDate;
        this.lastName = lastName;
        this.yearlySalary = yearlySalary;
    }
    
    public void setEmployeeId(long employeeId){
        this.employeeId = employeeId;
    }
    public long getEmployeeId(){
        return employeeId;
    }
    public void setFirstName( String firstName){
        this.firstName = firstName;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public void setLastName( String lastName){
        this.lastName = lastName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public void setEmploymentDate(LocalDate employmentDate){
        this.employmentDate = employmentDate;
    }
    public LocalDate getEmploymentDate(){
        return this.employmentDate;
    }
    public void setPensionPlan(PensionPlan pensionPlan){
        this.pensionPlan = pensionPlan;
    }
    public PensionPlan getPensionPlan(){
        return this.pensionPlan;
    }
    public void setYearlySalary(double yearlySalary){
        this.yearlySalary= yearlySalary;
    }
    public double getYearlySalary(){
        return this.yearlySalary;
    }
     public String toJson() {
        String pensionPlanJson = this.pensionPlan == null ? "null" :
            String.format("{\"planReferenceNumber\":\"%s\", \"enrollmentDate\":\"%s\", \"monthlyContribution\":%.2f}",
                          this.pensionPlan.getPlanReferenceNumber(),
                          this.pensionPlan.getEnrollmentDate().format(DateTimeFormatter.ISO_LOCAL_DATE),
                          this.pensionPlan.getMonthlyContribution());

        return String.format("{\"employeeId\":%d, \"firstName\":\"%s\", \"lastName\":\"%s\", \"employmentDate\":\"%s\", \"yearlySalary\":%.2f, \"pensionPlan\":%s}",
                             this.employeeId,
                             this.firstName,
                             this.lastName,
                             this.employmentDate.format(DateTimeFormatter.ISO_LOCAL_DATE),
                             this.yearlySalary,
                             pensionPlanJson);
    }
}
