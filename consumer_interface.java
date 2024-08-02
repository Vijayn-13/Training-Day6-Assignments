import java.util.*;
import java.util.function.Consumer;
public class consumer_interface
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
		Consumer<List<String>> co=(list)->{
		    for(int i=0;i<list.size();i++){
		        System.out.println(list.get(i).toUpperCase());
		    }
		};
        System.out.println("Strings after performing consumer function: ");
		co.accept(ls);
	}
}