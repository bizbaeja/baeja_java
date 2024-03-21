package homework.join5;

import lombok.Data;

@Data
public class Emp {
    private int empno;
    private String ename;
    private String job;
    private int mgr;
    private String hiredate;
    private int sal;
    private int comm;
    private int deptno;

    public Emp(int empno, String ename, String job, int mgr, String hiredate, int sal, int comm, int deptno) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.sal = sal;
        this.comm = comm;
        this.deptno = deptno;
    }

    public void print() {
        System.out.printf("%-13s%-13s%-13s%-13s%-13s%-13s%-13s%-13s\n", empno, ename, job, mgr, hiredate, sal, comm, deptno);
    }
}
