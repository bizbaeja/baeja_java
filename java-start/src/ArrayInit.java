public class ArrayInit {
    public static void main(String[] args) {
        // new 연산자로 배열을 처음 생성하면 배열은 기본값으로 초기화된다. 값이 없는게 아님
        int[] intArray = new int[5];
        System.out.println(intArray[0]);
        System.out.println(intArray[1]);
        System.out.println(intArray[2]);
        System.out.println(intArray[3]);
        System.out.println(intArray[4]);

        // byte[] -> 0
        // char[] -> '\u0000'
        // short[] -> 0
        // int[] -> 0
        // long[] -> 0L
        // float[] -> 0.0
        // boolean -> false

        // 참조타입은 null 로 초기화된다.
        // 클래스 -> null
        // 인터페이스 -> null
    }
}
