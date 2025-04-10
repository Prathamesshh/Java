class Human {

public static void walk()

{

System.out.println("Human walks");

}

}

class Boy extends Human

{

public static void walk()
{

System.out.println("boy walks");

}
}
public class bore{
    public static void main(String args[]){
        
        Human aman = new Boy();
        aman.walk();
    }}
 