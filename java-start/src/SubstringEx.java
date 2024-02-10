public class SubstringEx {
    public static void main(String[] args) {
        String phone = "010-2306-7267";

        String front = phone.substring(0, 3);
        String middle =  phone.substring(4,8);
        String back = phone.substring(9,13);

        System.out.println(front+middle+back);
    }
}
