import java.util.*;
public class Optional_handling
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter size of list: ");
		int n=sc.nextInt(),x;
		List<Integer> ls=new ArrayList<>();
		for(int i=0;i<n;i++){
		    System.out.print("Enter element: ");
		    x=sc.nextInt();
		    ls.add(x);
		}
		System.out.println("List: "+ls);
		Optional<Integer> op=ls.stream().max(Comparator.comparing(Integer::valueOf));
		if(op.isPresent()){
		    System.out.println("Maximum element: "+op.get());
		}
		else{
		    System.out.println("List is empty");
		}
	}
}