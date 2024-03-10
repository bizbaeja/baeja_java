package homework.join2;

import java.util.List;
import java.util.Scanner;

public class EmployeeService {
    private Scanner scanner = new Scanner(System.in);
    private EmployeeDAO employeeDAO;

    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public void mainMenu() {
        // 기존의 메뉴 구현 유지
        // ...
    }

    public void join() {
        // 기존의 join 메소드 구현 유지
        // ...
    }
    public void read(){
        System.out.println("직원 ID를 입력하세요: ");
        String id = scanner.nextLine();
        try {
            Employee employee = employeeDAO.read(id);
            if (employee != null) {
                employee.printEmployeeInfo(); // Employee 클래스에 printEmployeeInfo 메소드 구현 필요
            } else {
                System.out.println("[" + id + "] 해당하는 직원이 존재하지 않습니다.");
            }
        } catch (Exception e) {
            System.out.println("직원 정보 조회 중 오류가 발생했습니다.");
        }
    }
    private String convertJob(String jobNumber) {
        // 기존의 convertJob 메소드 구현 유지
        // ...
        return jobNumber;
    }

    public void detail() {
        // 수정된 detail 메소드 구현
        System.out.println("직원 ID를 입력하세요: ");
        String id = scanner.nextLine();
        try {
            Employee employee = employeeDAO.read(id);
            if (employee != null) {
                employee.printEmployeeInfo(); // Employee 클래스에 printEmployeeInfo 메소드 구현 필요
            } else {
                System.out.println("[" + id + "] 해당하는 직원이 존재하지 않습니다.");
            }
        } catch (Exception e) {
            System.out.println("직원 정보 조회 중 오류가 발생했습니다.");
        }

    }

    public void update(String id) {
        System.out.println("직원 ID를 입력하세요: ");
        id = scanner.nextLine();
        try {
            Employee employee = employeeDAO.read(id);
            if (employee != null) {
                employee.printEmployeeInfo();
                System.out.println("수정할 직원 정보를 입력하세요.");
                System.out.print("직원 이름: ");
                String name = scanner.nextLine();
                employee.setEmpno(name);
                System.out.print("직원 부서: ");
                String department = scanner.nextLine();
                employee.setDeptno(department);
                System.out.print("직원 직급: ");
                String job = scanner.nextLine();
                employee.setJob(job);
                System.out.print("직원 연봉: ");
                int salary = scanner.nextInt();
                employee.setSal(salary);

                employeeDAO.update(employee);
                System.out.println("직원 정보가 수정되었습니다.");
            } else {
                System.out.println("[" + id + "] 해당하는 직원이 존재하지 않습니다.");
            }

        } catch (Exception e) {
            System.out.println("직원 정보 수정 중 오류가 발생했습니다.");
        }
    }

    public void delete(String id) {

    }

    public void clear() {
        // 수정된 clear 메소드 구현
        // ...
    }

    public void exit() {
        System.out.println("프로그램 종료");
        System.exit(0);
    }

    public void list() {
        System.out.println("직원 목록을 출력합니다.");
        System.out.println("직원번호\t직원이름\t직급\t상사\t입사일\t급여\t커미션\t부서번호");
        System.out.println("-------------------------------------------------------------");
        try {
            List<Employee> list = employeeDAO.list();
            for (Employee employee : list) {
                employee.printEmployeeInfo();
            }
            if (list.isEmpty()) {
                System.out.println("직원 정보가 존재하지 않습니다.");
            }
        } catch (Exception e) {
            System.out.println("직원 목록 조회 중 오류가 발생했습니다.");
        }
//        try {
//            List<ch07.sec11.Employee> list = employeeDAO.list();
//            for (Employee employee : list) {
//                employee.printEmployeeInfo();
//            }
//            if (list.isEmpty()) {
//                System.out.println("직원 정보가 존재하지 않습니다.");
//            }
//        } catch (Exception e) {
//            System.out.println("직원 목록 조회 중 오류가 발생했습니다.");
//        }
//        mainMenu();
    }

    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService(new EmployeeDAO());
        employeeService.mainMenu();
    }
}