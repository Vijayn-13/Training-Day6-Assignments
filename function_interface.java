import java.util.*;
import java.util.function.*;
public class function_interface
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter radius: ");
		Double n=sc.nextDouble();
		Function<Double,Double> circle_area=(r)->(3.14*r*r);
        System.out.println("Area of circle: "+circle_area.apply(n));
	}
}