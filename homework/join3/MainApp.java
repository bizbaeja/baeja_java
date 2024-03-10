package homework.join3;

import java.util.Scanner;

public class MainApp {
    private DeptManager deptManager;
    private EmpManager empManager;
    private Scanner scanner;

    public MainApp() {
        deptManager = new DeptManager();
        empManager = new EmpManager();
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("1. 부서 관리");
            System.out.println("2. 사원 관리");
            System.out.println("3. 리스트 보기");
            System.out.println("4. 종료");
            System.out.print("메뉴를 선택하세요: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    manageDepartment();
                    break;
                case 2:
                    manageEmployee();
                    break;
                case 3:
                    empManager.viewAllEmployees();
                    break;
                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 시도하세요.");
                    break;
            }
        }
    }

    private void manageDepartment() {
        System.out.println("1. 등록");
        System.out.println("2. 상세보기");
        System.out.println("3. 전체삭제");
        System.out.println("4. 종료");
        System.out.print("부서 관리 메뉴를 선택하세요: ");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                deptManager.addDepartment();
                break;
            case 2:
                deptManager.viewDepartmentDetails();
                break;
            case 3:
                deptManager.deleteAllDepartments();
                break;
            case 4:
                return;
            default:
                System.out.println("잘못된 입력입니다. 다시 시도하세요.");
                break;
        }
    }

    private void manageEmployee() {
        while (true) {
            System.out.println("1. 사원 추가");
            System.out.println("2. 사원 수정");
            System.out.println("3. 사원 삭제");
            System.out.println("4. 전체 사원 보기");
            System.out.println("5. 돌아가기");
            System.out.print("사원 관리 메뉴를 선택하세요: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    empManager.addEmployee();
                    break;
                case 2:
                    empManager.updateEmployee();
                    break;
                case 3:
                    empManager.deleteEmployee();
                    break;
                case 4:
                    empManager.viewAllEmployees();
                    break;
                case 5:
                    return; // 메인 메뉴로 돌아간다.
                default:
                    System.out.println("잘못된 입력입니다. 다시 시도하세요.");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        new MainApp().start();
    }
}
