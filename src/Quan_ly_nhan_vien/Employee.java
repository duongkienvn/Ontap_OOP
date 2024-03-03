package Quan_ly_nhan_vien;

public class Employee {
    private String id, name;
    private int age;
    private String address;
    private double basicSalary;
    private String email;

    public Employee(String id, String name, int age, String address, double basicSalary, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.basicSalary = basicSalary;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary(){
        return basicSalary;
    }
    public String toString(){
        return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + ", basicSalary="
                + basicSalary + ", email=" + email + "]";
    }
}
