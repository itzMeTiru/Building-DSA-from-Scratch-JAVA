import java.util.HashMap;

public class ThreeTwo{
    public static void main(String[] args){


    //when not using a pointer
    // int num1 = 11;
    // int num2 = num1;
    // num1 = 22;
    // System.out.println("num1: " + num1);
    // System.out.println("num2: " + num2);



   //USING A POINTER
    HashMap<String, Integer> map1 = new HashMap<>();
    HashMap<String, Integer> map2 = new HashMap<>();

    map1.put("value", 11);
    map2 = map1;

    map1.put("value", 22);


    System.out.println(map1);
    System.out.println(map2);
    }
}