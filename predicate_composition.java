import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
public class predicate_composition
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter size of list: ");
		int n=sc.nextInt();
		List<String> ls=new ArrayList<>();
		String x;
		for(int i=0;i<n;i++){
		    System.out.print("Enter string: ");
		    x=sc.next();
		    ls.add(x);
		}
		System.out.println("List: "+ls);
		System.out.print("Enter substring: ");
		String sub=sc.next();
		Predicate<String> p1=(str)->(str.length()>5);
		Predicate<String> p2=(st)->(st.contains(sub));
		List<String> ls2=ls.stream().filter(s->p1.and(p2).test(s)).collect(Collectors.toList());
		System.out.println("Resultant strings after filter: ");
		ls2.forEach(System.out::println);
	}
}