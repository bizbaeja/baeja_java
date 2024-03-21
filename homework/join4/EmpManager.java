package homework.join4;

import java.util.List;
import java.util.Scanner;

public class EmpManager {
    private Scanner scanner;
    private EmpDAO empDAO;

    public EmpManager() {
        this.scanner = new Scanner(System.in);
        this.empDAO = new EmpDAO();
    }

    // viewAllEmployees, addEmployeeUI, updateEmployeeUI, deleteEmployeeUI 등의 메서드 구현
    // 예시: viewAllEmployees 메서드
//    public void viewAllEmployees() {
//        List<Employee> employees = empDAO.getAllEmployees();
//        for (Employee emp : employees) {
//            System.out.println(emp);
//        }
//    }
    // 다른 UI 메서드 구현
}