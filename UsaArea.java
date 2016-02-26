public class UsaArea{
  public static void main(String[] args){
    Area perimetro=(v1,v2) -> {
      int result=2*(v1+v2);
      System.out.println("El perimetro es: "+result);
    };
    Area area=(v1,v2) -> {
    int result=v1*v2;
    System.out.println("El area es: "+result);
    };
    perimetro.calcula(10,10);
    area.calcula(10,10);
  }
}
