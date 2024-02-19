package ch16.sec05.exam01_1;

import ch16.sec05.exam01.Calcuable;

public class Barista {
 	public static Coffee staticMixMethod(Coffee coffee1 ,Coffee coffee2){
		 return new Coffee(coffee1.getType() + "과"+ coffee2.getType());
	}

	public Coffee instanceMixMethod(Coffee coffee1, Coffee coffee2){
		 return new Coffee(coffee1.getType()+"를" +coffee2.getType()+"와 섞습니다.");

	}


}
