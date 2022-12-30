package in.prabodh.restservice;

public class Employee {
    private String empName;
    private String empAge;
    private String dateOfJoining;
    private String address;
    private String role;
    private String salary;
    private String experience;
    private String outputPdf;



    public String getOutputPdf() {
        return outputPdf;
    }

    public void setOutputPdf(String outputPdf) {
        this.outputPdf = outputPdf;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "empName='" + empName + '\'' +
                ", empAge='" + empAge + '\'' +
                ", dateOfJoining='" + dateOfJoining + '\'' +
                ", address='" + address + '\'' +
                ", role='" + role + '\'' +
                ", salary='" + salary + '\'' +
                ", experience='" + experience + '\'' +
                ", outputPdf='" + outputPdf + '\'' +
                '}';
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpAge() {
        return this.empAge;
    }

    public void setEmpAge(String empAge) {
        this.empAge = empAge;
    }

    public String getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(String dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

}
