package homework.join2;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

@Data
@AllArgsConstructor
public class Employee {
    private String empno;
    private String deptno;
    private String dname;
    private String job;
    private String mge;
    private int sal;
    private int comm;

    // Constructor, getters and setters

    public  Employee (){
    }

    public Employee(int empno, String ename, String job, int mgr, Date hiredate, int sal, int comm, int deptno) {

    }
//    public Employee(int empno, String ename, String job, int mgr, Date hiredate, int sal, int comm, int deptno) {
//    }

    // 여기에 필요한 getter와 setter 메소드를 추가하세요

    // 이 메소드는 직원 정보를 출력합니다.
    public void printEmployeeInfo() {
        System.out.println("직원번호: " + empno);
        System.out.println("부서번호: " + deptno);
        System.out.println("부서명: " + dname);
        System.out.println("직급: " + job);
        System.out.println("상사: " + mge);
        System.out.println("급여: " + sal);
        System.out.println("커미션: " + comm);
    }


}