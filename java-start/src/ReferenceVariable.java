public class ReferenceVariable {
    public static void main(String[] args) {
        // 배열변수는 번지를 갖고있는 참조타입
        int[] arr1;
        int[] arr2;
        int[] arr3;
// arr1,2,3은 배열을 저장하는게 아니라 배열을 힙에 생성한 번지를 저장하고 있는 것이다.
        arr1 = new int[]{1, 2, 3};
        arr2 = new int[]{1, 2, 3};
        arr3 = arr2;

        System.out.println(arr1 == arr2);

        System.out.println(arr2 == arr3);

    }
}
