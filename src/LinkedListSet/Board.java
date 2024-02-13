package src.LinkedListSet;

import jdk.jfr.DataAmount;

import java.util.Objects;

@DataAmount
public class Board {
    private int id;
    private String subject;
    private String content;
    private String writer;

    public Board(int id){
        this(id, "","","");
    }

//    @Override
//    public String toString() {
//        return "Board{" +
//                "writer='" + writer + '\'' +
//                '}';
//    }

    public Board(int id, String s, String s1, String s2) {
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Board board = (Board) obj;
        return id == board.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getSubject() {
        return subject;
    }

    public String getWriter() {
        return writer;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}
