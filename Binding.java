// In Binding two objects (primitive or non primitive) can be binded so that change in value of one object reflects equivalent change in 
// other object too.
public class Binding{
  public static void main(String[] args){
    IntegerProperty x = new SimpleIntegerProperty(3);
    IntegerProperty y = new SimpleIntegerProperty();
    y.bind(x.multiply(10));  
    System.out.println("x = " + x.getValue());   // 3
    System.out.println("y = " + y.getValue());   // 30
    
    x.setValue(10);
    System.out.println("x = " + x.getValue());   // 10
    System.out.println("y = " + y.getValue());   // 100
    
  }

}
