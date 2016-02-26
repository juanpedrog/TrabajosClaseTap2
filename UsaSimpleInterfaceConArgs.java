public class UsaSimpleInterfaceConArgs{
  public static void main(String[] args){
    SimpleInterfaceargs obj=(v1,v2) -> {
      int result=v1*v2;
      System.out.println("El resultado es "+result);
    };
    obj.hasAlgo(10,10);
    obj.hasAlgo(60,80);
  }
}
