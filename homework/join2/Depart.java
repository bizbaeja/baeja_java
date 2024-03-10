package homework.join2;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Depart {
    private int deptno;
    private String dname;
    private String loc;

    public Depart(String dname, String loc) {
        this(0, dname, loc);
    }

    public Depart(int bno, String title, String content, String writer) {

    }

    public Depart(String title, String content, String writer) {
    }


    public void print() {
        System.out.printf("%-6s%-12s%-16s%-40s \n"
                , deptno
                , dname
                , loc);
    }

    public void printDetail() {
        System.out.println("번호 : " + deptno);
        System.out.println("부서명 : " + dname);
        System.out.println("지역 : " + loc);
    }






}