package homework.Board2;

//게시물 정보를 관리하는 클래스
// 게시물 정보를 저장

import java.util.Date;
//인텔리제이에서 lombok이 안되는 현상 해결
//1. File > Settings > Build, Execution, Deployment > Compiler > Annotation Processors
//2. Enable annotation processing 체크
//3. Build > Rebuild Project
//4. 재시작
//rebild 하는법



import lombok.Data;

@Data
public class Board {
    private int bno;
    private String btitle;
    private String bcontent;
    private String bwriter;
    private Date bdate;

    public Board(int bno, String btitle, String bcontent, String bwriter) {
        this.bno = bno;
        this.btitle = btitle;
        this.bcontent = bcontent;
        this.bwriter = bwriter;
        this.bdate = new Date(); // 현재 날짜로 설정
    }
}


