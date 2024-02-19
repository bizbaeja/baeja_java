package ch16.sec05.exam01_02;

public class CopangMan {
    // void 로 고치고 return 을 없앴다.
    public static void staticDeliveryMethod(Address address1, Address address2){
   new Address("쿠팡맨이"+address1.getType()+"와"+address2.getType()+"에 갑니다");
    }

    public void instanceDeliveryMethod(Address address1, Address address2){
         new Address("쿠팡맨이"+address1.getType()+"와"+address2.getType()+"에 갑니다");
    }


}
