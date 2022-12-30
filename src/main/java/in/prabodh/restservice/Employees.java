package in.prabodh.restservice;

public class Employees {

    private String emp1;
    private String age;
    private String address;
    private String Date;
    private String experience;
    private String Role;
    private String Salary;

    @Override
    public String toString() {
        return "Employees{" +
                "emp1='" + emp1 + '\'' +
                ", age='" + age + '\'' +
                ", address='" + address + '\'' +
                ", Date='" + Date + '\'' +
                ", experience='" + experience + '\'' +
                ", Role='" + Role + '\'' +
                ", Salary='" + Salary + '\'' +
                '}';
    }
    public void initValues(){
        this.setEmp1("Ramu");
        this.setAge("22");
        this.setDate("1/12/2022");
        this.setExperience("2");
        this.setRole("front end developer");
        this.setAddress("hyd");
        this.setSalary("10000");
    }

    public String getEmp1() {
        return emp1;
    }

    public void setEmp1(String emp1) {
        this.emp1 = emp1;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public String getSalary() {
        return Salary;
    }

    public void setSalary(String salary) {
        Salary = salary;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


}
