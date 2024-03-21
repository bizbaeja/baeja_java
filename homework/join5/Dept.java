package homework.join5;
import lombok.Data;

import java.util.List;

@Data
public class Dept {
private int deptno;
private String dname;
private String loc;

    public Dept(int deptno, String dname, String loc) {
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;

    }
    public void print() {
        System.out.printf("%-13s%-13s%-13s\n", deptno, dname, loc);
    }


}

