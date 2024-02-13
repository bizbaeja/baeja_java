package InheritConstructor;

public class SmartPhone extends Phone{
  public SmartPhone(String model, String color){
      super(model,color);

      this.model = model;
      this.color = color;
      System.out.println("SmartPhone(String model, String color) 생성자 실행됨");
  }


}
