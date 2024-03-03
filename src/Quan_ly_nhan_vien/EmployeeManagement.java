package Quan_ly_nhan_vien;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagement {
    /*
	    Hàm nhập dữ liệu từ tệp và trả về một ArrayList danh sách các nhân viên
	    Biến fileName là tên tệp dữ liệu
	    Nhập n nhân viên từ tệp dữ liệu

	*/
    public ArrayList<Employee> readData(String fileName) {
        ArrayList<Employee> employees = new ArrayList<>();
        Scanner sc = null;
        File file = null;
        try {
            file = new File(fileName);
            sc = new Scanner(file);
            int n = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < n; i++) {
                int idx = Integer.parseInt(sc.nextLine());
                String id = sc.nextLine();
                String name = sc.nextLine();
                int age = Integer.parseInt(sc.nextLine());
                String address = sc.nextLine();
                double basicSalary = Double.parseDouble(sc.nextLine());
                String email = sc.nextLine();
                if (idx == 1) {
                    int no_test_equipments = Integer.parseInt(sc.nextLine());
                    double allowance = Double.parseDouble(sc.nextLine());
                    Technician tech = new Technician(id, name, age, address, basicSalary, email, no_test_equipments, allowance);
                    employees.add(tech);
                }
                if (idx == 0) {
                    int no_customers = Integer.parseInt(sc.nextLine());
                    Marketer marketer = new Marketer(id, name, age, address, basicSalary, email, no_customers);
                    employees.add(marketer);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return employees;
    }

    /*
	    In ra danh sách tất cả các nhân viên, mỗi nhân viên trên một hàng
	*/
    public void printInforEmployees(ArrayList<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }

    /*
	    Hàm trả về danh sách các kỹ thuật viên phụ trách lĩnh vực "field".
	    Nếu không có trả về giá trị null
	*/
    public ArrayList<Employee> filterTech(ArrayList<Employee> employees, String fields) {
        ArrayList<Employee> filter = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee instanceof Technician) {
                Technician technician = (Technician) employee;
                if (technician.getField().equals(fields)) {
                    filter.add(technician);
                }
            }
        }
        return filter;
    }

    /*
	    Hàm sắp xếp lương của nhân viên theo thứ tự tăng dần
	*/
    public void sortBySalary(ArrayList<Employee> arr_e) {
        int n = arr_e.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr_e.get(i).getSalary() > arr_e.get(j).getSalary()) {
                    Employee tmp = arr_e.get(i);
                    arr_e.set(i, arr_e.get(j));
                    arr_e.set(j, tmp);
                }
            }
        }
    }

    /*
	    Hàm tìm những nhân viên tiếp thị có mức lương cao hơn mức lương cao nhất
	    của các kỹ thuật viên. Yêu cầu kết quả đầu ra của nhân viên tiếp thị phải
	    được sắp xếp theo thứ tự tăng dần của lương
	*/
    public ArrayList<Employee> filterMarketerBySalary(ArrayList<Employee> employees) {
        ArrayList<Employee> filter = new ArrayList<>();
        double max = Double.MIN_VALUE;
        for (Employee employee : employees) {
            if (employee instanceof Technician) {
                Technician technician = (Technician) employee;
                if (max < technician.getSalary()) {
                    max = technician.getSalary();
                }
            }
        }
        for (Employee employee : employees) {
            if (employee instanceof Marketer) {
                Marketer marketer = (Marketer) employee;
                if (marketer.getSalary() > max) {
                    filter.add(marketer);
                }
            }
        }
        sortBySalary(filter);
        return filter;
    }

    public static void main(String[] args) {
        EmployeeManagement employeeManagement = new EmployeeManagement();
        ArrayList<Employee> employees = employeeManagement.readData("C:\\Users\\Dell\\eclipse-workspace\\Ontap_OOP\\src\\Quan_ly_nhan_vien\\data.txt");
        employeeManagement.printInforEmployees(employees);
        System.out.println();

        ArrayList<Employee> fields = employeeManagement.filterTech(employees, "computer");
        employeeManagement.printInforEmployees(fields);
        System.out.println();

        employeeManagement.sortBySalary(employees);
        employeeManagement.printInforEmployees(employees);
        System.out.println();

        ArrayList<Employee> filterMarketer = employeeManagement.filterMarketerBySalary(employees);
        employeeManagement.printInforEmployees(filterMarketer);
    }
}
