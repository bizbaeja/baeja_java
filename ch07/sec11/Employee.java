package ch07.sec11;

import java.sql.Date;

public final class Employee extends Person {
    public Employee(int empno, String ename, String job, int mgr, Date hiredate, int sal, int comm, int deptno) {
        super();
    }

    public Employee() {

    }

    @Override
	public void work() {
		System.out.println("제품을 생산합니다.");
	}
}