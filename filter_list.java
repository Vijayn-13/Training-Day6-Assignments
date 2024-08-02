import java.util.*;
import java.util.stream.Collectors;
class filter_list{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter size of the list: ");
        int n=sc.nextInt();
        List<String> ls=new ArrayList<>();
        String str;
        for(int i=0;i<n;i++){
            System.out.print("Enter string: ");
            str=sc.next();
            ls.add(str);
        }
        System.out.println("List: "+ls);
        List<String> result_list=ls.stream().filter(st->st.startsWith("A")).collect(Collectors.toList());
        System.out.println("Filtered strings for those starting letter is \"A\": ");
        result_list.forEach(System.out::println);
    }
}