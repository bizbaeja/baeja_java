package homework.join5;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class DeptService {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    DeptDAO deptDAO;
    public DeptService(DeptDAO deptDAO){
        this.deptDAO = deptDAO;
    }

    public void deptMenu() throws IOException {
        System.out.println("1.추가 | 2. 상세보기 | 3.전체삭제 | 4.종료");
        System.out.print("메뉴 선택: ");
        String menuNo = br.readLine();
        System.out.println();

        switch (menuNo) {
            case "1" -> deptInsert();
            case "2" -> deptDetail();
            case "3" -> deptClear();
            case "4" -> exit();
        }
    }
  public void deptInsert(){}
    public void deptDetail(){}
    public void deptClear(){}
    public void exit(){}

}
