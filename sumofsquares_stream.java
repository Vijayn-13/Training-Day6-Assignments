import java.util.*;
import java.util.stream.Collectors;
public class sumofsquares_stream
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter size of list: ");
		int n=sc.nextInt();
		List<Integer> ls=new ArrayList<>();
		int x;
		for(int i=0;i<n;i++){
		    System.out.print("Enter element: ");
		    x=sc.nextInt();
		    ls.add(x);
		}
		System.out.println("List: "+ls);
		List<Integer> ls1=ls.stream().filter((y)->(y%2)==0).collect(Collectors.toList());
		System.out.println("Filtered data based on even condition: "+ls1);
		Optional<Integer> op1=ls1.stream().map((a)->(a*a)).reduce((b,c)->(b+c));
		System.out.print("Sum of squares of even numbers in the list: ");
		op1.ifPresent(System.out::println);
	}
}