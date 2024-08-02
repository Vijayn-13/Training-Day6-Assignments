import java.util.*;
interface custom_interface{
    int square_number(int n);
    default void print(int x){
        System.out.println("Square of the number: "+x);
    }
}
class subclass implements custom_interface{
    public int square_number(int n){
        return n*n;
    }
}
public class custom_functional_interface
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter number: ");
		int x=sc.nextInt();
		subclass c1=new subclass();
		int m=c1.square_number(x);
		c1.print(m);
	}
}