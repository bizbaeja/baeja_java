package homework.join2;

import java.util.Scanner;

public class Main {
    // Field
    private Scanner scanner = new Scanner(System.in);

    public void mainMenu() {
        while (true) {
            System.out.println("\n-----------------------------------------------------------------------");
            System.out.println("메인 메뉴: 1.부서관리 | 2.사원관리 | 3.Exit");
            System.out.print("메뉴 선택: ");
            String menuNo = scanner.nextLine();

            switch (menuNo) {
                case "1" -> departManager();
                case "2" -> employeeManager();
                case "3" -> exit();
                default -> System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
            }
        }
    }

    private void employeeManager() {
        EmployeeService employeeService = new EmployeeService(new EmployeeDAO());
        employeeService.mainMenu(); // 사원 관리 서비스 메인 메뉴 호출
    }

    private void departManager() {
        DepartService departService = new DepartService(new DepartDAO());
        departService.mainMenu(); // 부서 관리 서비스 메인 메뉴 호출
    }

    private void exit() {
        System.out.println("프로그램을 종료합니다.");
        System.exit(0);
    }

    public static void main(String [] args) {
        new Main().mainMenu();
    }
}