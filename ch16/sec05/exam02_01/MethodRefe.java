package ch16.sec05.exam02_01;

public class MethodRefe {
    public static void main(String[] args) {
        Snack snack = new Snack();
        snack.exercise(String::compareToIgnoreCase);
    }
}
