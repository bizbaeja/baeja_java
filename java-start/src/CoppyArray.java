public class CoppyArray {
    public static void main(String[] args) {
        int[] oldIntArray = {1, 2, 3};
        int[] newIntArray = new int[5];

        for(int i=0; i<oldIntArray.length; i++){
            newIntArray[i] = oldIntArray[i];
        }

        for(int i=0; i<newIntArray.length; i++){
            System.out.println(newIntArray[i]+ ",");
        }

        int[] anotherArr = new int[6];

        //System.arraycopy(원본배열, 원본배열 복사시작 인덱스, 새 배열, 새배열 붙여넣기 시작인덱스, 북사 항목수);
        System.arraycopy(oldIntArray, 0, anotherArr,0,oldIntArray.length);

        for(int i=0 ; i<anotherArr.length; i++){
            System.out.println(anotherArr[i]+ "");
        }
    }
}
