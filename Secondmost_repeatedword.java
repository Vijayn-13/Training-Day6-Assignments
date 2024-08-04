import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.nio.file.Path;
import java.util.function.Function;
import java.util.stream.*;
public class Secondmost_repeatedword {
    public static void main(String[] args){
        Path path=Path.of(args[0]);
        try(Stream<String> str=Files.lines(path)){
            Map<String,Long> mp=str.flatMap(l->Arrays.stream(l.split(" "))).map(l->l.replaceAll("[^a-zA-Z]","").toLowerCase()).filter(l->!l.isEmpty()).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
            List<Map.Entry<String,Long>> ls1=mp.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(2).collect(Collectors.toList());
            List<Map.Entry<String,Long>> ls2=ls1.stream().sorted(Map.Entry.comparingByValue()).limit(1).collect(Collectors.toList());
            System.out.println("Second most repeated word in a sequence:-");
            ls2.forEach(l->System.out.println(l.getKey()+" "+l.getValue()));
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
