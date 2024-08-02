import java.util.*;
import java.util.stream.Collectors;
import java.util.function.*;
public class Insurance_Application {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        Policy p1=new Policy("Pn123","vijay",1000);
        Policy p2=new Policy("Pn124","mahendra singh dhoni",3000);
        Policy p3=new Policy("Pn125","sridivya",1200);
        Policy p4=new Policy("Pn126","divya",1300);
        Policy p5=new Policy("Pn127","vetrimaran",2300);
        Policy p6=new Policy("Pn128","shyam singh",1200);
        Policy p7=new Policy("Pn129","lokesh kanagaraj",1300);
        Policy p8=new Policy("Pn130","sridivya",2300);

        List<Policy> ls=new ArrayList<>();
        ls.add(p1);
        ls.add(p2);
        ls.add(p3);
        ls.add(p4);
        ls.add(p5);
        ls.add(p6);
        ls.add(p7);
        ls.add(p8);

        System.out.println("\nPolicies with premium greater than $1200:- ");
        List<Policy> lp=ls.stream().filter(x->(x.premium_amount>1200)).collect(Collectors.toList());
        for(Policy p:lp){
            System.out.println(p.policy_number+" "+" "+p.policyholder_name+" "+p.premium_amount);
        }

        System.out.println("\nSorted Policies by Holder Name:- ");
        List<Policy> lp1=ls.stream().sorted((x,y)->Character.compare(x.policyholder_name.charAt(0),y.policyholder_name.charAt(0))).toList();
        for(Policy p:lp1){
            System.out.println(p.policy_number+" "+" "+p.policyholder_name+" "+p.premium_amount);
        }

        System.out.print("\nTotal Premium amount: ");
        Optional<Double> op1=ls.stream().map(x->x.premium_amount).reduce((a,b)->a+b);
        op1.ifPresent(System.out::println);

        System.out.print("\nPolicy details:-");
        List<Policy> lp2=ls.stream().toList();
        for(Policy p:lp2){
            System.out.println("\nPolicy number: "+p.policy_number);
            System.out.println("Policy holder name: "+p.policyholder_name);
            System.out.println("Premium amount: "+p.premium_amount);
        }

        System.out.println("\nFiltered policies based on range:-");
        List<Policy> lp3=ls.stream().filter(x->(x.premium_amount>=1000 && x.premium_amount<=2000)).toList();
        for(Policy p:lp3){
            System.out.println(p.policy_number+" "+" "+p.policyholder_name+" "+p.premium_amount);
        }

        System.out.println("\nPolicy with Highest Premium:-");
        Optional<Double> op2=ls.stream().map(x->x.premium_amount).max(Comparator.comparing(Double::valueOf));
        double d1=op2.get();
        List<Policy> lp4=ls.stream().filter(x->(x.premium_amount==d1)).toList();
        for(Policy p:lp4){
            System.out.println("Policy number: "+p.policy_number);
            System.out.println("Policy holder name: "+p.policyholder_name);
            System.out.println("Premium amount: "+p.premium_amount);
        }

        System.out.println("\nGrouped Policies by Holder Name Initial:-");
        Map<Character,List<Policy>> mp1=ls.stream().collect(Collectors.groupingBy(x->x.policyholder_name.charAt(0)));
        int i=1;
        for(Map.Entry<Character,List<Policy>> m:mp1.entrySet()){
            List<Policy> lps=m.getValue();
            System.out.println("Group "+i+":");
            for(Policy p:lps){
                System.out.println(p.policy_number+" "+p.policyholder_name+" "+p.premium_amount);
            }
            System.out.println();
            i++;
        }

        System.out.print("Average Premium amount: ");
        OptionalDouble op3=ls.stream().map(x->x.premium_amount).mapToDouble(Double::valueOf).average();
        op3.ifPresent(System.out::println);

        System.out.println("\nSorted Policies by Premium amount:- ");
        List<Policy> lp5=ls.stream().sorted((x,y)->Double.compare(x.premium_amount,y.premium_amount)).toList();
        for(Policy p:lp5){
            System.out.println(p.policy_number+" "+p.policyholder_name+" "+p.premium_amount);
        }

        System.out.println("\nPolicy that exceeds premium amount of $2000:- ");
        List<Policy> lp6=ls.stream().filter(x->(x.premium_amount>2000)).toList();
        for(Policy p:lp6){
            System.out.println(p.policy_number+" "+p.policyholder_name+" "+p.premium_amount);
        }

        System.out.println("\nPolicies count for Each Premium Range:-");
        System.out.print("Number of policies between $0 and $1000: ");
        OptionalLong op4=OptionalLong.of(ls.stream().filter(x->(x.premium_amount>=0 && x.premium_amount<=1000)).count());
        System.out.print(op4.getAsLong());
        System.out.print("\nNumber of policies between $1001 and $2000: ");
        OptionalLong op5=OptionalLong.of(ls.stream().filter(x->(x.premium_amount>=1001 && x.premium_amount<=2000)).count());
        System.out.print(op5.getAsLong());
        System.out.print("\nNumber of policies above $2000: ");
        OptionalLong op6=OptionalLong.of(ls.stream().filter(x->(x.premium_amount>2000)).count());
        System.out.println(op6.getAsLong());

        System.out.println("\nUnique Policy Holder Names:-");
        List<String> lp7=ls.stream().map(x->x.policyholder_name).distinct().toList();
        for(String s:lp7){
            System.out.println(s);
        }

        System.out.print("\nEnter substring: ");
        String st=sc.next();
        System.out.println("Policies by Holder Name Substring \""+st+"\":-");
        List<Policy> lp8=ls.stream().filter(x->(x.policyholder_name.contains(st))).toList();
        for(Policy p:lp8){
            System.out.println(p.policy_number+" "+p.policyholder_name+" "+p.premium_amount);
        }

        System.out.println("\nMap of Policy Numbers to Premium Amounts:-");
        Map<String,Double> mp2=ls.stream().collect(Collectors.toMap(policy->policy.policy_number,policy->policy.premium_amount));
        for(Map.Entry<String,Double> m:mp2.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }
    }
}
