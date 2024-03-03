package Quan_ly_nhan_vien;

public class Marketer extends Employee{
    private int no_customers;

    public Marketer(String id, String name, int age, String address, double basicSalary,
                    String email, int no_customer){
        super(id, name, age, address, basicSalary, email);
        this.no_customers = no_customer;
    }
    public int getNo_customer(){
        return no_customers;
    }
    public void setNo_customer(int no_customer){
        this.no_customers = no_customer;
    }
    public double getSalary() {
	      /*
	        Lương của nhân viên tiếp thị = lương cơ bản + tiền thưởng hoa hồng
	        (trong đó tiền thưởng hoa hồng = số lượng khách hàng mua sản phẩm *  250.000)
	    */
        return getBasicSalary() + no_customers * 250000;
    }
    public String toString(){
        return "Marketer [id=" + getId() + ", name=" + getName() + ", age=" + getAge() + ", address=" + getAddress() + ", basicSalary="
                + getBasicSalary() + ", email=" + getEmail() + ", no_customers=" + no_customers + "]";
    }
}
