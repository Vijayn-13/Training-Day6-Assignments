import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.nio.file.Path;
import java.util.function.Function;
import java.util.stream.*;
public class MostFrequentWords_byLambda {
    public static void main(String[] args){
        Path path=Path.of(args[0]);
        int n=Integer.parseInt(args[1]);
        try(Stream<String> lines= Files.lines(path)){
            Map<String,Long> mp=lines.flatMap(l->Arrays.stream(l.split(" "))).map(l->l.toLowerCase().replaceAll("[^a-zA-Z]","")).filter(l->!l.isEmpty()).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
            for(Map.Entry<String,Long> m:mp.entrySet()){
                System.out.println(m.getKey()+" "+m.getValue());
            }
            List<Map.Entry<String,Long>> ls=mp.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(n).collect(Collectors.toList());
            ls.forEach(l->System.out.println(l.getKey()+" "+l.getValue()));
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
