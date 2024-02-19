package ch16.sec05.exam01_1;

public class MethodRef {

    public static void main(String[] args) {
        // Mixable 인터페이스 선언 : 커피를 혼합하는 mix 메서드를 정의한다. mix 메서드는 두개의 Coffee 객체를 매개변수로 받아 새로운 Coffee 객체를 반환

        Mixable mixAction;
        Barista barista = new Barista();
        Coffee espresso = new Coffee("Espresso");
        Coffee latte = new Coffee("Latte");

        //정적 메소드 참조
        mixAction = Barista::staticMixMethod;
        Coffee mixedCoffee1 = mixAction.mix(espresso, latte);
        System.out.println("mixed coffee" + mixedCoffee1.getType());

        mixAction = barista::instanceMixMethod;
        Coffee mixedCoffee2 = mixAction.mix(espresso,latte);
        System.out.println("mixed coffee"+ mixedCoffee2.getType());

    }

}
