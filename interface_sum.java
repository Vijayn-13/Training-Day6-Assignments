import java.util.*;
interface func_interface{
    int sum(int a,int b);
}
class interface_sum {
	public static void main(String args[])
	{
	    Scanner sc=new Scanner(System.in);
	    System.out.print("Enter n1: ");
	    int n1=sc.nextInt();
	    System.out.print("Enter n2: ");
	    int n2=sc.nextInt();
	    func_interface fi=(int x,int y)->x+y;
		int s=fi.sum(n1,n2);
		System.out.println("Sum: "+s);
	}
}
