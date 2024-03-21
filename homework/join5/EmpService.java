package homework.join5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
public class EmpService {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    EmpDAO empDAO;
    DeptDAO deptDAO;

    public EmpService(EmpDAO empDAO, DeptDAO deptDAO){
        this.empDAO = empDAO;
        this.deptDAO = deptDAO;
    }

    public void empMenu() throws IOException {
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        System.out.println("1.추가 | 2.상세보기 | 3.전체삭제 | 4.종료");
        System.out.print("메뉴 선택: ");
        String menuNo = br.readLine();
        System.out.println();

        switch (menuNo) {
            case "1" -> empInsert();
            case "2" -> empDetail();
            case "3" -> empClear();
            case "4" -> exit();
        }
    }
    public int subMenu() throws IOException {
        System.out.println("1.등록 | 2.취소");
        System.out.print("메뉴 선택: ");
        return Integer.parseInt(br.readLine());
    }
    public  void empUpdate() throws IOException {
        System.out.println("[사원 수정]");
        System.out.print("변경할 사원명 : ");
        String ename = br.readLine();
        System.out.print("변경할 직업 : ");
        String job = br.readLine();
        System.out.print("변경할 관리자(사원번호) : ");
        int mgr = Integer.parseInt(br.readLine());
        System.out.print("변경할 입사일 : ");
        String hiredate = br.readLine();
        System.out.print("변경할 급여 : ");
        int sal = Integer.parseInt(br.readLine());
        System.out.print("변경할 커미션 : ");
        int c
    }
    public void empList() throws IOException{
        System.out.println();
        System.out.println("[사원 목록]");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s%-12s%-16s%-16s%-16s%-10s%-13s%-16s%-10s\n", "사원번호", "사원명", "직업", "관리자(사원번호)", "입사일", "급여", "부서명", "장소", "등급");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");

        List<Emp> empList = empDAO.empList();

        for (Emp emp : empList) {
            emp.print();
        }

        if (empList.size() == 0) {
            System.out.println("사원 자료가 존재하지 않습니다.");
        }

        empMenu();
    };

    public  void empInsert() throws IOException {

        System.out.println();
        System.out.println("[사원 목록]");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s%-12s%-16s%-16s%-16s%-10s%-13s%-16s%-10s\n", "사원번호", "사원명", "직업", "관리자(사원번호)", "입사일", "급여", "부서명", "장소", "등급");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");

        List<Emp> empList = empDAO.empList();

        for (Emp emp : empList) {
            emp.print();
        }

        if (empList.size() == 0) {
            System.out.println("사원 자료가 존재하지 않습니다.");
        }

        empMenu();
    }
    public  void empDetail() throws IOException{
        System.out.println("[사원 등록]");
        System.out.print("사원번호 : ");
        int empno = Integer.parseInt(br.readLine());
        System.out.print("사원명 : ");
        String ename = br.readLine();
        System.out.print("직업 : ");
        String job = br.readLine();
        System.out.print("관리자(사원번호) : ");
        int mgr = Integer.parseInt(br.readLine());
        System.out.print("급여 : ");
        int sal = Integer.parseInt(br.readLine());
        System.out.print("커미션 : ");
        int comm = Integer.parseInt(br.readLine());
        System.out.print("부서번호 : ");
        int deptno = Integer.parseInt(br.readLine());
        System.out.println();

        // 부서번호가 존재하는지 확인
        boolean existDeptno = deptDAO.isExistDeptno(deptno);
        if (existDeptno) {
            int menuNo = subMenu();
            if (menuNo == 1) {
                empDAO.empInsert(new Emp(empno, ename, job, mgr, null, sal, comm, deptno));
            } else if (menuNo == 2) {
                System.out.println("\n취소되었습니다.");
            }
        } else {
            System.out.println("\n부서번호가 존재하지 않습니다.");
            exit();
        }

        empList();
    }
    public  void empClear(){}
    public  void exit(){}

    public  void  empDetail() throws IOException{
        System.out.println("[특정 사원 조회]");
        System.out.print("조회할 사원번호 입력 : ");
        int empno = Integer.parseInt(br.readLine());

        Emp emp = empDAO.empDetail(empno);

        if (emp == null) {
            System.out.println("\n사원 정보가 존재하지 않습니다.");
        } else {
            System.out.println("\n사원번호 : " + emp.getEmpno());
            System.out.println("사원명 : " + emp.getEname());
            System.out.println("직업 : " + emp.getJob());
            System.out.println("관리자(사원번호) : " + emp.getMgr());
            System.out.println("입사일 : " + emp.getHiredate());
            System.out.println("급여 : " + emp.getSal());
            System.out.println("부서명 : " + emp.getDname());
            System.out.println("장소 : " + emp.getLoc());
            System.out.println("등급 : " + emp.getGrade());

            System.out.println("---------------------------------------------------------------------------------------------------------------------------");
            System.out.println("보조 메뉴: 1.Update | 2.Delete | 3.List");
            System.out.print("메뉴 선택: ");

            int menuNo = Integer.parseInt(br.readLine());

            switch (menuNo) {
                case 1 -> empUpdate(empno);
                case 2 -> empDelete(empno);
                case 3 -> empList();
            }
        }
        empList();
    }
}
