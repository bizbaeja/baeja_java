package homework.join5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    DeptService deptService = new DeptService();
    EmpService empService = new EmpService();

    public Main(DeptService deptService, EmpService empService) {
        this.deptService = deptService;
        this.empService = empService;
    }

    private void mainMemu() throws IOException {
        System.out.println("메인 메뉴: 1.부서 관리 | 2.사원 관리 | 3.Exit");
        System.out.print("메뉴 선택: ");
        String menuNo = br.readLine();
        System.out.println();

//        switch (menuNo) {
//            case "1" -> deptService.list();
//            case "2" -> empService.list();
//            case "3" -> exit();
//        }
    }

    public static void main(String[] args) {
      Main main = new Main(new DeptService(new DeptDAO()),new EmpService(new EmpDAO(), new DeptDAO()));
      main.mainMemu();
    }
}
