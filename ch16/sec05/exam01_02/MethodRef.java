package ch16.sec05.exam01_02;public class MethodRef {
    public static void main(String[] args) {
        Delivery deliveryAction;
        CopangMan copangMan = new CopangMan();
        Address address1 = new Address("서울시");
        Address address2 = new Address("부산시");

        //정적 메소드 참조
        deliveryAction = CopangMan::staticDeliveryMethod;






    }
}
