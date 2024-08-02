import java.util.*;
import java.util.function.*;
public class bifunction_interface
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter string1: ");
		String str1=sc.next();
		System.out.print("Enter string2: ");
		String str2=sc.next();
		BiFunction<String,String,String> concatenate=(x,y)->(x+" "+y);
        System.out.println("Concatenated String: "+concatenate.apply(str1,str2));
	}
}