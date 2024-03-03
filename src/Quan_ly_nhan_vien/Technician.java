package Quan_ly_nhan_vien;

public class Technician extends Employee{
    private int no_test_equipments;
    private double allowance;
    public Technician(String id, String name, int age, String address, double basicSalary,
                      String email, int no_test_equipments, double allowance){
        super(id, name, age, address, basicSalary, email);
        this.no_test_equipments = no_test_equipments;
        this.allowance = allowance;
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }

    public int getNo_test_equipments() {
        return no_test_equipments;
    }

    public void setNo_test_equipments(int no_test_equipments) {
        this.no_test_equipments = no_test_equipments;
    }

    public String getField() {

	    /*
	        Lĩnh vực mà mỗi kỹ thuật viên phụ trách được xác định dựa vào việc phân tích tên miền trong địa chỉ email của kỹ thuật viên
	        ví dụ:
	        + Địa chỉ email: minhht@smp.vitech.vn: kỹ thuật viên phụ trách lĩnh vực về điện thoại
			+ Địa chỉ emal: duongkl@comp.vitech.vn: kỹ thuật viên phụ trách lĩnh vực về máy tính
	    */
        if(getEmail().contains("smp")){
            return "smart phone";
        }
        if(getEmail().contains("comp")){
            return "computer";
        }
        return null;
    }
    public double getSalary() {
	    /*
	        Lương của kỹ thuật viên = lương cơ bản  + số thiết bị kiểm tra thành công * 150.000 + phụ cấp
	    */
        return getBasicSalary() + no_test_equipments * 150000 + allowance;
    }
    public String toString(){
        return "Technician [id=" + getId() + ", name=" + getName() + ", age=" + getAge() + ", address=" + getAddress() + ", basicSalary="
                + getBasicSalary() + ", email=" + getEmail() + ", no_test_equipments=" + no_test_equipments + ", allowance=" + allowance + "]";
    }
}
