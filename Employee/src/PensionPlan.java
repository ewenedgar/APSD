

import java.time.LocalDate;

public class PensionPlan {
    private String planReferenceNumber;
    private LocalDate enrollmentDate;
    private double monthlyContribution;
    private Employee employee;
    public PensionPlan(String planReferenceNumber,LocalDate enrollmentDate,double monthlyContribution){
        this.planReferenceNumber = planReferenceNumber;
        this.enrollmentDate = enrollmentDate;
        this.monthlyContribution = monthlyContribution;
    }

    public String getPlanReferenceNumber(){
        return this.planReferenceNumber;
    }
    public LocalDate getEnrollmentDate(){
        return this.enrollmentDate;
    }
    public double getMonthlyContribution(){
        return this.monthlyContribution;
    }
    public void setEmployee(Employee employee){
        this.employee = employee;
    }
    public Employee getEmployee(){
        return this.employee;
    }

}
